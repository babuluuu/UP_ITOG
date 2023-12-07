package com.example.springmodels.repos;

import com.example.springmodels.models.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
    // Дополнительные методы для запросов к базе данных, если необходимо
}
