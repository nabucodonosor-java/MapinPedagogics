package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
