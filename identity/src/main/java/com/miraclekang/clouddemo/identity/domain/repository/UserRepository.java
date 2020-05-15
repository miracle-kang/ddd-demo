package com.miraclekang.clouddemo.identity.domain.repository;

import com.miraclekang.clouddemo.identity.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
