/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "projectgroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projectgroups.findAll", query = "SELECT p FROM Projectgroups p"),
    @NamedQuery(name = "Projectgroups.findByGroupname", query = "SELECT p FROM Projectgroups p WHERE p.projectgroupsPK.groupname = :groupname"),
    @NamedQuery(name = "Projectgroups.findByUsername", query = "SELECT p FROM Projectgroups p WHERE p.projectgroupsPK.username = :username")})
public class Projectgroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProjectgroupsPK projectgroupsPK;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projectusers projectusers;

    public Projectgroups() {
    }

    public Projectgroups(ProjectgroupsPK projectgroupsPK) {
        this.projectgroupsPK = projectgroupsPK;
    }

    public Projectgroups(String groupname, String username) {
        this.projectgroupsPK = new ProjectgroupsPK(groupname, username);
    }

    public ProjectgroupsPK getProjectgroupsPK() {
        return projectgroupsPK;
    }

    public void setProjectgroupsPK(ProjectgroupsPK projectgroupsPK) {
        this.projectgroupsPK = projectgroupsPK;
    }

    public Projectusers getProjectusers() {
        return projectusers;
    }

    public void setProjectusers(Projectusers projectusers) {
        this.projectusers = projectusers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectgroupsPK != null ? projectgroupsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectgroups)) {
            return false;
        }
        Projectgroups other = (Projectgroups) object;
        if ((this.projectgroupsPK == null && other.projectgroupsPK != null) || (this.projectgroupsPK != null && !this.projectgroupsPK.equals(other.projectgroupsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Projectgroups[ projectgroupsPK=" + projectgroupsPK + " ]";
    }
    
}
