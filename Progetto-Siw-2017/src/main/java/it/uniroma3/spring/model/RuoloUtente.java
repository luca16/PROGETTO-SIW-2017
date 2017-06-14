package it.uniroma3.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "ruolo"})})
public class RuoloUtente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_role_id")
    private Integer userRoleId;
    
 
    @JoinColumn(name = "username")
    private String username;
   
    private String ruolo;

    public RuoloUtente() {
    }

    public RuoloUtente(String ruolo) {
        this.ruolo=ruolo;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return ruolo;
    }

    public void setRole(String role) {
        this.ruolo = role;
    }
}
