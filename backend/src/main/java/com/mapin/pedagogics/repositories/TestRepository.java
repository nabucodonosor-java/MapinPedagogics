package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
