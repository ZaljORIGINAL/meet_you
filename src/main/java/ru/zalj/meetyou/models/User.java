package ru.zalj.meetyou.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.zalj.meetyou.models.Enums.Role;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;

    @Column(name = "email")
    private String email;

    @Column(name = "blocked")
    private boolean blocked = false;

    @Column(name = "password", length = 1024)
    private String password;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "user")
    private UserProfile userProfile;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = EnumSet.noneOf(Role.class);

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOfCreate(LocalDateTime dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateOfCreate() {
        return dateOfCreate;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
