package com.mapin.pedagogics.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Role;
import com.mapin.pedagogics.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String name);

	@Query("SELECT DISTINCT obj FROM User obj INNER JOIN obj.roles role WHERE "
			+ "(COALESCE(:roles) IS NULL OR role IN :roles) AND "
			+ "(LOWER(obj.authority) LIKE LOWER(CONCAT('%',:authority,'%'))) ")
	Page<User> find(List<Role> roles, String authority, Pageable pageable);
	
	@Query("SELECT obj FROM User obj JOIN FETCH obj.roles WHERE obj IN :usuarios")
	List<User> find(List<User> usuarios);

}
