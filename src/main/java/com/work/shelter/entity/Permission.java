package com.work.shelter.entity;

/**
 *
 * Enumeration "Permission" defines permissions for reading and writing content.
 *
 */
public enum Permission {

    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
