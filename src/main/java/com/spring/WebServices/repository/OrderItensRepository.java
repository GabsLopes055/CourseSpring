package com.spring.WebServices.repository;

import com.spring.WebServices.entities.OrderItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItensRepository extends JpaRepository<OrderItens, Long> {
}
