
package jwtrest;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.inject.Model;
import javax.security.enterprise.credential.Credential;

//@SessionScoped
@Model
public class JWTCredential implements Credential, Serializable {
private static final long serialVersionUID = 1L;
    private final String principal;
    private final Set<String> authorities;

    public JWTCredential(String principal, Set<String> authorities) {
        this.principal = principal;
        this.authorities = authorities;
    }

//    public JWTCredential() {
//    }

    public String getPrincipal() {
        return principal;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

}
