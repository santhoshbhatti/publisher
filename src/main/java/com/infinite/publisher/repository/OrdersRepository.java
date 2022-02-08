package com.infinite.publisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.publisher.model.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
