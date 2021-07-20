package com.mapin.pedagogics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapin.pedagogics.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
