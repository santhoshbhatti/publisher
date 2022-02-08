package com.infinite.publisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinite.publisher.model.LineItem;

@Repository
public interface LineItemsRepository extends JpaRepository<LineItem, Integer> {

}
