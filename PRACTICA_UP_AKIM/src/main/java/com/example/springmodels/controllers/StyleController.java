package com.example.springmodels.controllers;

import com.example.springmodels.models.Style;
import com.example.springmodels.services.StyleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/styles")
public class StyleController {

    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping
    public String getAllStyles(Model model) {
        List<Style> styles = styleService.getAllStyles();
        model.addAttribute("styles", styles);
        return "list-styles"; // Имя представления
    }

    @GetMapping("/{id}")
    public String getStyleById(@PathVariable Long id, Model model) {
        styleService.getStyleById(id).ifPresent(style -> model.addAttribute("style", style));
        return "style-details"; // Имя представления
    }

    @GetMapping("/create")
    public String createStyleForm(Model model) {
        model.addAttribute("style", new Style());
        return "create-style"; // Имя представления
    }

    @PostMapping
    public String saveStyle(@ModelAttribute Style style) {
        styleService.saveStyle(style);
        return "redirect:/styles"; // Перенаправление на список стилей
    }

    @GetMapping("/{id}/edit")
    public String editStyleForm(@PathVariable Long id, Model model) {
        styleService.getStyleById(id).ifPresent(style -> model.addAttribute("style", style));
        return "edit-style"; // Имя представления
    }

    @GetMapping("/{id}/delete")
    public String deleteStyle(@PathVariable Long id) {
        styleService.deleteStyle(id);
        return "redirect:/styles"; // Перенаправление на список стилей
    }
}
