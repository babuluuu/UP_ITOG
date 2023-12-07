package com.example.springmodels.services;

import com.example.springmodels.models.Color;
import com.example.springmodels.models.TattooStudio;
import com.example.springmodels.repos.TattooStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TattooStudioService {

    private final TattooStudioRepository tattooStudioRepository;

    @Autowired
    public TattooStudioService(TattooStudioRepository tattooStudioRepository) {
        this.tattooStudioRepository = tattooStudioRepository;
    }

    public List<TattooStudio> getAllTattooStudios() {
        return tattooStudioRepository.findAll();
    }

    public Optional<TattooStudio> getTattooStudioById(Long id) {
        return tattooStudioRepository.findById(id);
    }

    public void saveTattooStudio(TattooStudio tattooStudio) {
        tattooStudioRepository.save(tattooStudio);
    }

    public void deleteTattooStudio(Long id) {
        tattooStudioRepository.deleteById(id);
    }
}
