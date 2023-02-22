package com.javaproject.Ecommerce.Order;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
