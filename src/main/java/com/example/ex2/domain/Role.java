package com.example.ex2.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, MOD1, MOD2;
    @Override
    public String getAuthority() {
        return name();
    }

}
