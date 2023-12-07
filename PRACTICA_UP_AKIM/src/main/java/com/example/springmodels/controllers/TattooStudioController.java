package com.example.springmodels.controllers;

import com.example.springmodels.models.TattooStudio;
import com.example.springmodels.services.TattooStudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tattoo-studios")
public class TattooStudioController {

    private final TattooStudioService tattooStudioService;

    @Autowired
    public TattooStudioController(TattooStudioService tattooStudioService) {
        this.tattooStudioService = tattooStudioService;
    }

    @GetMapping
    public String getAllTattooStudios(Model model) {
        List<TattooStudio> tattooStudios = tattooStudioService.getAllTattooStudios();
        model.addAttribute("tattooStudios", tattooStudios);
        return "list-tattoo-studios";
    }

    @GetMapping("/{id}")
    public String getTattooStudioById(@PathVariable Long id, Model model) {
        tattooStudioService.getTattooStudioById(id).ifPresent(tattooStudio -> model.addAttribute("tattooStudio", tattooStudio));
        return "tattoo-studio-details";
    }

    @GetMapping("/create")
    public String createTattooStudioForm(Model model) {
        model.addAttribute("tattooStudio", new TattooStudio());
        return "create-tattoo-studio"; // Имя представления для формы создания
    }

    @PostMapping
    public String saveTattooStudio(@ModelAttribute TattooStudio tattooStudio) {
        tattooStudioService.saveTattooStudio(tattooStudio);
        return "redirect:/tattoo-studios"; // Перенаправление на список после сохранения
    }

    @GetMapping("/{id}/edit")
    public String editTattooStudioForm(@PathVariable Long id, Model model) {
        tattooStudioService.getTattooStudioById(id).ifPresent(tattooStudio -> model.addAttribute("tattooStudio", tattooStudio));
        return "edit-tattoo-studio"; // Имя представления для формы редактирования
    }

    @GetMapping("/{id}/delete")
    public String deleteTattooStudio(@PathVariable Long id) {
        tattooStudioService.deleteTattooStudio(id);
        return "redirect:/tattoo-studios"; // Перенаправление на список после удаления
    }
}
