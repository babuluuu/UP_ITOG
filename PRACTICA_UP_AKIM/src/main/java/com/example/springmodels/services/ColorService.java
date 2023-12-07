package com.example.springmodels.services;

import com.example.springmodels.models.Color;
import com.example.springmodels.repos.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    private final ColorRepository colorRepository;

    @Autowired
    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Optional<Color> getColorById(Long id) {
        return colorRepository.findById(id);
    }

    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}
