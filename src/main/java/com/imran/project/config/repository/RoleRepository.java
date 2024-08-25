package com.imran.project.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imran.project.config.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>
{

}
