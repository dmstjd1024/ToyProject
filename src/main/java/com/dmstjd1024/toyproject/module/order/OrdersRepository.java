package com.dmstjd1024.toyproject.module.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByAccountId(Long accountId);
}
