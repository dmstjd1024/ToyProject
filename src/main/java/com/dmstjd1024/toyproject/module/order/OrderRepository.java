package com.dmstjd1024.toyproject.module.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByAccountId(Long accountId);
}
