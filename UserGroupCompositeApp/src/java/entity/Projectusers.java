/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "projectusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Projectusers.findAll", query = "SELECT p FROM Projectusers p"),
    @NamedQuery(name = "Projectusers.findByUsername", query = "SELECT p FROM Projectusers p WHERE p.username = :username"),
    @NamedQuery(name = "Projectusers.findByPassword", query = "SELECT p FROM Projectusers p WHERE p.password = :password")})
public class Projectusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectusers")
    private Collection<Projectgroups> projectgroupsCollection;

    public Projectusers() {
    }

    public Projectusers(String username) {
        this.username = username;
    }

    public Projectusers(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Projectgroups> getProjectgroupsCollection() {
        return projectgroupsCollection;
    }

    public void setProjectgroupsCollection(Collection<Projectgroups> projectgroupsCollection) {
        this.projectgroupsCollection = projectgroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projectusers)) {
            return false;
        }
        Projectusers other = (Projectusers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Projectusers[ username=" + username + " ]";
    }
    
}
