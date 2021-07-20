package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
