import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class DecisionTreeVisualizer {
	private static final int HORIZ_SKIP = 10;
	private static final int VERT_SKIP = 50;
	private static final int NODE_WIDTH = 60;
	private static final int NODE_HEIGHT = 20;
	private static final Font NORMAL_FONT = new Font("Dialog", Font.PLAIN, 9);
	private static final Color LEAF_COLOR0 = Color.RED;
	private static final Color LEAF_COLOR1 = Color.GREEN;
	private static final Color LEAF_COLOR_UNDEFINED = Color.ORANGE;
	private static final Color HIDDEN_NODES_COLOR = new Color(165, 196, 242);
	/*
	 * Comment out the following line and uncomment the line after that to see
	 * the full tree. Note that this may make the tree hard to read if the
	 * height is large.
	 */
	private static final int MAX_DEPTH = 5;
	// private static final int MAX_DEPTH = Integer.MAX_VALUE;

	private JFrame window;

	public DecisionTreeVisualizer(DecisionTree dt, String header) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI(dt, header);
			}
		});
	}

	private void createAndShowGUI(DecisionTree dt, String header) {
		window = new JFrame();
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.setSize(1400, 800);
		window.setLocationRelativeTo(null);

		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		window.add(pane);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(15);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		pane.add(scrollPane, BorderLayout.CENTER);

		String headerText = "DecisionTree Visualizer: " + header;

		// Draw tree
		if (dt == null) {
			JLabel nullLabel = new JLabel("[null]");
			nullLabel.setFont(NORMAL_FONT);
			nullLabel.setBounds(400, 250,
					(int) nullLabel.getPreferredSize().getWidth(),
					(int) nullLabel.getPreferredSize().getHeight());
			contentPane.add(nullLabel);
		} else {
			int h = getHeight(dt.rootDTNode);
			if (h > MAX_DEPTH)
				headerText += " [trimmed to depth of " + MAX_DEPTH + "]";
			h = Math.min(h, MAX_DEPTH);

			int maxBottomNodes = (int) Math.pow(2, h);
			int imageWidth = maxBottomNodes * (NODE_WIDTH + HORIZ_SKIP)
					+ HORIZ_SKIP;
			int imageHeight = (1 + h) * (NODE_HEIGHT + VERT_SKIP) + VERT_SKIP;
			contentPane.setMinimumSize(new Dimension(imageWidth, imageHeight));
			contentPane
					.setPreferredSize(new Dimension(imageWidth, imageHeight));
			contentPane.setMaximumSize(new Dimension(imageWidth, imageHeight));
			drawTree(dt.rootDTNode,
					new Rectangle(0, 30, imageWidth, imageHeight), contentPane,
					0);
		}

		// Header
		window.setTitle(headerText);
		window.setVisible(true);
	}

	private int getHeight(DecisionTree.DTNode root) {
		if (root.left == null && root.right == null)
			return 0;

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	private void drawTree(DecisionTree.DTNode root, Rectangle canvas,
			JPanel contentPane, int depth) {
		if (root == null)
			return;

		boolean isAtMaxDepth = (depth >= MAX_DEPTH);

		JLabel rootLabel = makeLabel(root);
		contentPane.add(rootLabel);
		double centerX = canvas.getCenterX();
		rootLabel.setBounds((int) (centerX - NODE_WIDTH / 2),
				(int) canvas.getMinY(), NODE_WIDTH,
				NODE_HEIGHT);

		int parentX = (int) centerX;
		int parentY = (int) (canvas.getY() + NODE_HEIGHT);

		if (root.left != null && !isAtMaxDepth) {
			int newX = (int) canvas.getX();
			int newY = (int) (canvas.getMinY() + NODE_HEIGHT + VERT_SKIP);
			int newWidth = (int) (canvas.getWidth() / 2);
			int newHeight = (int) (canvas.getHeight() - NODE_HEIGHT
					- VERT_SKIP);
			Rectangle leftCanvas = new Rectangle(newX, newY, newWidth,
					newHeight);
			drawTree(root.left, leftCanvas, contentPane, depth + 1);

			// Connect parent to child
			int leftChildX = (int) (leftCanvas.getCenterX());
			int leftChildY = parentY + VERT_SKIP;
			Line line = new Line(parentX, parentY, leftChildX, leftChildY);
			contentPane.add(line);
		}
		if (root.right != null && !isAtMaxDepth) {
			int newX = (int) (canvas.getX() + canvas.getWidth() / 2);
			int newY = (int) (canvas.getMinY() + NODE_HEIGHT + VERT_SKIP);
			int newWidth = (int) (canvas.getWidth() / 2);
			int newHeight = (int) (canvas.getHeight() - NODE_HEIGHT
					- VERT_SKIP);
			Rectangle rightCanvas = new Rectangle(newX, newY, newWidth,
					newHeight);
			drawTree(root.right, rightCanvas, contentPane, depth + 1);

			// Connect parent to child
			int rightChildX = (int) (rightCanvas.getCenterX());
			int rightChildY = parentY + VERT_SKIP;
			Line line = new Line(parentX, parentY, rightChildX, rightChildY);
			contentPane.add(line);
		}

		if (isAtMaxDepth && !root.leaf) {
			// Add label to show that there are more labels
			JLabel extendedLabel = new JLabel("   ...   ");
			extendedLabel.setHorizontalAlignment(SwingConstants.CENTER);
			extendedLabel.setFont(NORMAL_FONT);
			extendedLabel
					.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			extendedLabel.setOpaque(true);
			extendedLabel.setBackground(HIDDEN_NODES_COLOR);

			int x = (int) (canvas.getCenterX()
					- extendedLabel.getPreferredSize().getWidth() / 2);
			int y = (int) (canvas.getY() + NODE_HEIGHT + VERT_SKIP);
			int width = (int) (extendedLabel.getPreferredSize().getWidth());
			int height = (int) (extendedLabel.getPreferredSize().getHeight());
			extendedLabel.setBounds(x, y, width, height);

			// Line
			Line l = new Line(parentX, y - VERT_SKIP, parentX, y);
			contentPane.add(l);

			contentPane.add(extendedLabel);
			return;
		}
	}

	private JLabel makeLabel(DecisionTree.DTNode node) {
		JLabel nodeLabel = new JLabel();
		nodeLabel.setSize(NODE_WIDTH, NODE_HEIGHT);
		nodeLabel.setFont(NORMAL_FONT);
		nodeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		nodeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		if (node.leaf) {
			nodeLabel.setText(Integer.toString(node.label));
			nodeLabel.setOpaque(true);
			if (node.label == 0)
				nodeLabel.setBackground(LEAF_COLOR0);
			else if (node.label == 1)
				nodeLabel.setBackground(LEAF_COLOR1);
			else
				nodeLabel.setBackground(LEAF_COLOR_UNDEFINED);
		} else {
			nodeLabel.setText(String.format("x%d < %.2f", node.attribute,
					node.threshold));
		}

		return nodeLabel;
	}

	private class Line extends JPanel {
		private static final long serialVersionUID = -5451293947087728291L;

		int x0;
		int y0;
		int x1;
		int y1;

		private Line(int x0, int y0, int x1, int y1) {
			this.x0 = x0;
			this.y0 = y0;
			this.x1 = x1;
			this.y1 = y1;

			int x = Math.min(x0, x1);
			int y = Math.min(y0, y1);
			int width = Math.abs(x1 - x0);
			width = Math.max(width, 5);
			int height = Math.abs(y1 - y0);
			height = Math.max(height, 5);

			this.setBounds(x, y, width, height);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int x = Math.min(x0, x1);
			int y = Math.min(y0, y1);

			g.drawLine(x0 - x, y0 - y, x1 - x, y1 - y);
		}
	}
}
