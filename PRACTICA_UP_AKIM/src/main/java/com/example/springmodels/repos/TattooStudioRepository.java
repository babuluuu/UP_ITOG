package com.example.springmodels.repos;

import com.example.springmodels.models.Color;
import com.example.springmodels.models.TattooStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TattooStudioRepository extends JpaRepository<TattooStudio, Long> {
    // Дополнительные методы для запросов к базе данных, если необходимо
}
