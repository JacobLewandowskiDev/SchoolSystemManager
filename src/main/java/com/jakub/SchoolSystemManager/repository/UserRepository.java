package com.jakub.SchoolSystemManager.repository;

import com.jakub.SchoolSystemManager.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findUserByEmail(String username);
}
