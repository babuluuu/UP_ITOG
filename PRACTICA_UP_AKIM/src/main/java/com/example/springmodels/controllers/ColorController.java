package com.example.springmodels.controllers;

import com.example.springmodels.models.Color;
import com.example.springmodels.services.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public String getAllColors(Model model) {
        List<Color> colors = colorService.getAllColors();
        model.addAttribute("colors", colors);
        return "list-colors"; // Имя представления
    }

    @GetMapping("/{id}")
    public String getColorById(@PathVariable Long id, Model model) {
        colorService.getColorById(id).ifPresent(color -> model.addAttribute("color", color));
        return "color-details"; // Имя представления
    }

    @GetMapping("/create")
    public String createColorForm(Model model) {
        model.addAttribute("color", new Color());
        return "create-color"; // Имя представления
    }

    @PostMapping
    public String saveColor(@ModelAttribute Color color) {
        colorService.saveColor(color);
        return "redirect:/colors";
    }

    @GetMapping("/{id}/edit")
    public String editColorForm(@PathVariable Long id, Model model) {
        colorService.getColorById(id).ifPresent(color -> model.addAttribute("color", color));
        return "edit-color";
    }

    @GetMapping("/{id}/delete")
    public String deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return "redirect:/colors"; // Перенаправление на список цветов
    }
}
