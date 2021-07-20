package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
