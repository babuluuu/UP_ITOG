package com.example.springmodels.repos;

import com.example.springmodels.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    // Дополнительные методы для запросов к базе данных, если необходимо
}
