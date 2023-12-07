package com.example.springmodels.controllers;

import com.example.springmodels.models.TattooType;
import com.example.springmodels.services.TattooTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tattoo-types")
public class TattooTypeController {

    private final TattooTypeService tattooTypeService;

    @Autowired
    public TattooTypeController(TattooTypeService tattooTypeService) {
        this.tattooTypeService = tattooTypeService;
    }

    @GetMapping
    public String getAllTattooTypes(Model model) {
        List<TattooType> tattooTypes = tattooTypeService.getAllTattooTypes();
        model.addAttribute("tattooTypes", tattooTypes);
        return "list-tattoo-types";
    }

    @GetMapping("/{id}")
    public String getTattooTypeById(@PathVariable Long id, Model model) {
        tattooTypeService.getTattooTypeById(id).ifPresent(tattooType -> model.addAttribute("tattooType", tattooType));
        return "tattoo-type-details"; // Имя представления для отображения деталей
    }

    @GetMapping("/create")
    public String createTattooTypeForm(Model model) {
        model.addAttribute("tattooType", new TattooType());
        return "create-tattoo-type"; // Имя представления для формы создания
    }

    @PostMapping
    public String saveTattooType(@ModelAttribute TattooType tattooType) {
        tattooTypeService.saveTattooType(tattooType);
        return "redirect:/tattoo-types"; // Перенаправление на список после сохранения
    }

    @GetMapping("/{id}/edit")
    public String editTattooTypeForm(@PathVariable Long id, Model model) {
        tattooTypeService.getTattooTypeById(id).ifPresent(tattooType -> model.addAttribute("tattooType", tattooType));
        return "edit-tattoo-type"; // Имя представления для формы редактирования
    }

    @GetMapping("/{id}/delete")
    public String deleteTattooType(@PathVariable Long id) {
        tattooTypeService.deleteTattooType(id);
        return "redirect:/tattoo-types"; // Перенаправление на список после удаления
    }
}
