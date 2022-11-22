package com.app.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Orders;
@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {

}
