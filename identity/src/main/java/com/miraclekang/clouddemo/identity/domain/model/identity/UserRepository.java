package com.miraclekang.clouddemo.identity.domain.model.identity;

import com.miraclekang.clouddemo.identity.domain.model.identity.User;
import com.miraclekang.clouddemo.identity.domain.repository.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
