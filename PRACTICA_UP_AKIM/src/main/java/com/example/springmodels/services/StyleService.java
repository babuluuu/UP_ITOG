package com.example.springmodels.services;

import com.example.springmodels.models.Style;
import com.example.springmodels.repos.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StyleService {

    private final StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public List<Style> getAllStyles() {
        return styleRepository.findAll();
    }

    public Optional<Style> getStyleById(Long id) {
        return styleRepository.findById(id);
    }

    public Style saveStyle(Style style) {
        return styleRepository.save(style);
    }

    public void deleteStyle(Long id) {
        styleRepository.deleteById(id);
    }
}
