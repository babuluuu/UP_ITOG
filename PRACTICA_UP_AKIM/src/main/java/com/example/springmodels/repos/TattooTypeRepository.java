package com.example.springmodels.repos;

import com.example.springmodels.models.TattooType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TattooTypeRepository extends JpaRepository<TattooType, Long> {
}
