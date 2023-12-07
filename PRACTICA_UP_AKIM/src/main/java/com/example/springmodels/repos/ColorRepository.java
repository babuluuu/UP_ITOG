package com.example.springmodels.repos;

import com.example.springmodels.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    // Дополнительные методы для запросов к базе данных, если необходимо
}
