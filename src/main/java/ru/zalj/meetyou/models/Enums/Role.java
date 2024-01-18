package ru.zalj.meetyou.models.Enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SIMPLE;

    @Override
    public String getAuthority() {
        return name();
    }
}
