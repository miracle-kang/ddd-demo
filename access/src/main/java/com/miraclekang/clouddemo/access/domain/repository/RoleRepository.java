package com.miraclekang.clouddemo.access.domain.repository;

import com.miraclekang.clouddemo.access.domain.model.permission.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
