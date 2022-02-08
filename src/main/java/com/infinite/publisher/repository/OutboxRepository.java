package com.infinite.publisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.publisher.model.Outbox;

public interface OutboxRepository extends JpaRepository<Outbox, Integer>{

}
