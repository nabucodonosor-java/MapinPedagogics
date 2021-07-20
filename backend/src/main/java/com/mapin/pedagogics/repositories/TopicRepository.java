package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

}
