package com.yogaapp.backend.entity;

public enum Role {
    ADMIN, USER;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
