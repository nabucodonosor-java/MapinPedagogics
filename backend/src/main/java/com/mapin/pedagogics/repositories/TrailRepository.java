package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Trail;

@Repository
public interface TrailRepository extends JpaRepository<Trail, Long> {

}
