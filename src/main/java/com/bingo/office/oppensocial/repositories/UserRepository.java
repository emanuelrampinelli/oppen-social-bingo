package com.bingo.office.oppensocial.repositories;

import com.bingo.office.oppensocial.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByCode(int code);
}
