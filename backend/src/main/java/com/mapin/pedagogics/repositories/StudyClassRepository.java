package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.StudyClass;

@Repository
public interface StudyClassRepository extends JpaRepository<StudyClass, Long> {

}
