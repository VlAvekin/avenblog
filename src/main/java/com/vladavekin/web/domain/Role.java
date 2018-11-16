package com.vladavekin.web.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{

    USER, ADMIN;

//    @Override
//    public String getAuthority() {
//        return name();
//    }

    @Override
    public String getAuthority() {
        return name();
    }
}
