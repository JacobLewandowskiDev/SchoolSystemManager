package com.jakub.SchoolSystemManager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String ROLE_STUDENT = "STUDENT";
    public static final String ROLE_TEACHER = "TEACHER";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_MAIN_ADMIN = "MAIN_ADMIN";

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer role_id;
    @Column(name = "name")
    private final String name;


    public Role(Integer role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> appUsers;

    @Override
    public int hashCode() {
        final int primary = 69;
        int result = 1;
        result = primary * result + (((name == null)) ? 0: name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(name, ((Role) obj).getName());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(role_id).append("]");
        return builder.toString();
    }
}
