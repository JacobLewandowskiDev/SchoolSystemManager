package com.jakub.SchoolSystemManager.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    STUDENT(Sets.newHashSet(
        UserPermission.STUDENT_READ
    )),
    TEACHER(Sets.newHashSet(
            UserPermission.TEACHER_READ,
            UserPermission.TEACHER_WRITE,
            UserPermission.TEACHER_UPDATE,
            UserPermission.TEACHER_DELETE
    )),
    ADMIN(Sets.newHashSet(
            UserPermission.ADMIN_READ,
            UserPermission.ADMIN_WRITE,
            UserPermission.ADMIN_UPDATE
    )),
    MAIN_ADMIN(Sets.newHashSet(
            UserPermission.ADMIN_READ,
            UserPermission.ADMIN_WRITE,
            UserPermission.ADMIN_UPDATE,
            UserPermission.MAIN_ADMIN_READ,
            UserPermission.MAIN_ADMIN_WRITE,
            UserPermission.MAIN_ADMIN_UPDATE,
            UserPermission.MAIN_ADMIN_DELETE
    ));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions =  getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }

}
