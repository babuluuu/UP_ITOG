package com.example.springmodels.services;

import com.example.springmodels.models.TattooType;
import com.example.springmodels.repos.TattooTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TattooTypeService {

    private final TattooTypeRepository tattooTypeRepository;

    @Autowired
    public TattooTypeService(TattooTypeRepository tattooTypeRepository) {
        this.tattooTypeRepository = tattooTypeRepository;
    }

    public List<TattooType> getAllTattooTypes() {
        return tattooTypeRepository.findAll();
    }

    public Optional<TattooType> getTattooTypeById(Long id) {
        return tattooTypeRepository.findById(id);
    }

    public TattooType saveTattooType(TattooType tattooType) {
        return tattooTypeRepository.save(tattooType);
    }

    public void deleteTattooType(Long id) {
        tattooTypeRepository.deleteById(id);
    }
}
