package com.example.demo.Security.ConfigUserDTO;

import com.example.demo.Security.ConfigModels.Role;
import com.example.demo.Security.ConfigModels.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
public class UserDetailsImpl implements UserDetails {

    private User user;
    private int id;

    private String username;
    private String password;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(User user) {
        this.user = user;
        log.info(user.toString());
        this.password=user.getPassword();
        this.username=user.getUsername();

    }

    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authoritiess=new ArrayList<>();
        log.info(user.toString());
        for(Role role :user.getRoles()){
            authoritiess.add(new SimpleGrantedAuthority(role.getNomRole()));
            role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).forEach((authoritiess::add));
        };
        this.authorities=authoritiess;
        return authorities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public String getPassword() {
        return password;
    }


    public UserDetailsImpl(int id, String username, String password,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities=authorities;
    }

    public static UserDetailsImpl build(User user){

        List<GrantedAuthority> authoritiess=new ArrayList<>();

        for(Role role :user.getRoles()){
            authoritiess.add(new SimpleGrantedAuthority(role.getNomRole()));
            role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).forEach((authoritiess::add));

        }
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authoritiess);
        }
    }


