package com.bilalalp.cxfjaxrssecurity.security;

import com.bilalalp.cxfjaxrssecurity.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@EqualsAndHashCode
public class SystemUser implements UserDetails {


    private Collection<GrantedAuthority> grantedAuthorities;

    private User user;

    public SystemUser(final User user) {
        this.user = user;
        this.grantedAuthorities = new ArrayList<>();
        this.grantedAuthorities.addAll(getRoles(user.getRoles()));
    }

    private List<SimpleGrantedAuthority> getRoles(final List<String> roles) {

        final List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for(final String role : roles){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}