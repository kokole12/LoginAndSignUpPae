package com.example.loginandsignuppae.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppUserRepository extends JpaRepository<AppUSer, Long> {
    Optional<AppUSer> findByEmail (String email);
}
