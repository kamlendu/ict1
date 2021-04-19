
package jwtrest;

//import com.sun.xml.ws.security.impl.policy.Claims;
//import static com.sun.xml.ws.security.impl.policy.Constants.SignatureAlgorithm;
import static jwtrest.Constants.REMEMBERME_VALIDITY_SECONDS;
import io.jsonwebtoken.*;
import java.io.FileInputStream;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
//import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

//@SessionScoped
@Named
@ApplicationScoped

public class TokenProvider implements Serializable {
private static final long serialVersionUID = 1L;
    
     
    private static final Logger LOGGER = Logger.getLogger(TokenProvider.class.getName());

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey;  
    private String privateKey;
     
    private String publicKey;
    private PrivateKey myprivateKey;
    private PublicKey mypublicKey;
    private long tokenValidity;

    private long tokenValidityForRememberMe;

    @PostConstruct
    public void init() {
        // load from config
        this.secretKey = "my-secret-jwt-key";
        
       /******************** 
        try{
        System.out.println(System.getProperty("user.dir")+"/prencode");
        FileInputStream keyfis = new FileInputStream(System.getProperty("user.dir")+"/prencode");
      //  FileInputStream keyfis = new FileInputStream(System.getProperty("user.dir")+"/privateencoded");
  
        byte[] prencKey = new byte[keyfis.available()];  
        keyfis.read(prencKey);
         FileInputStream keyfis1 = new FileInputStream(System.getProperty("user.dir")+"/pbencode");
        // FileInputStream keyfis1 = new FileInputStream(System.getProperty("user.dir")+"/publicencoded");
    
         byte[] pbencKey = new byte[keyfis1.available()];  
        keyfis1.read(pbencKey);

        keyfis.close();
        
        KeyFactory kf = KeyFactory.getInstance("RSA"); // or "EC" or whatever
        myprivateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(prencKey));
        mypublicKey = kf.generatePublic(new X509EncodedKeySpec(pbencKey));

        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
 
 * **********************/
        this.tokenValidity = TimeUnit.HOURS.toMillis(10);   //10 hours
        this.tokenValidityForRememberMe = TimeUnit.SECONDS.toMillis(REMEMBERME_VALIDITY_SECONDS);   //24 hours
    }

    public String createToken(String username, Set<String> authorities, Boolean rememberMe) {
        long now = (new Date()).getTime();
        long validity = rememberMe ? tokenValidityForRememberMe : tokenValidity;
        System.out.println("TokenProvider - In create Token");
        String remembertoken= Jwts.builder()
                .setSubject(username)
                .setIssuer("localhost")
                .claim(AUTHORITIES_KEY, authorities.stream().collect(joining(",")))
                .signWith(SignatureAlgorithm.HS512, secretKey)
               // .signWith(SignatureAlgorithm.RS256, myprivateKey)
                .setExpiration(new Date(now + validity))
                .compact();
        System.out.println("Remember Me Token :"+remembertoken);
        return remembertoken;
    }

    public JWTCredential getCredential(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
              //  .setSigningKey(mypublicKey)
                .parseClaimsJws(token)
                .getBody();
        System.out.println("TokenProvider - Token Provider - In Get Credential");
        Set<String> authorities
                = Arrays.asList(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .stream()
                        .collect(Collectors.toSet());

        return new JWTCredential(claims.getSubject(), authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            System.out.println("TokenProvider - TokenProvider - validate token");
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
         // Jwts.parser().setSigningKey(mypublicKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            LOGGER.log(Level.INFO, "Invalid JWT signature: {0}", e.getMessage());
            return false;
        }
    }
}
