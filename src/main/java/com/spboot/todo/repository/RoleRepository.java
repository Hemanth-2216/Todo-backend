package com.spboot.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spboot.todo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
