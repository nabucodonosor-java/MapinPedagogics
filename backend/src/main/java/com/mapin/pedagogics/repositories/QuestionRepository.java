package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
