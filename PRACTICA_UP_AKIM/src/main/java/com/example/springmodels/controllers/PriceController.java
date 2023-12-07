package com.example.springmodels.controllers;

import com.example.springmodels.models.Price;
import com.example.springmodels.services.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public String getAllPrices(Model model) {
        List<Price> prices = priceService.getAllPrices();
        model.addAttribute("prices", prices);
        return "list-prices"; // Имя представления
    }

    @GetMapping("/{id}")
    public String getPriceById(@PathVariable Long id, Model model) {
        priceService.getPriceById(id).ifPresent(price -> model.addAttribute("price", price));
        return "price-details"; // Имя представления
    }

    @GetMapping("/create")
    public String createPriceForm(Model model) {
        model.addAttribute("price", new Price());
        return "create-price"; // Имя представления
    }

    @PostMapping
    public String savePrice(@ModelAttribute Price price) {
        priceService.savePrice(price);
        return "redirect:/api/prices"; // Перенаправление на список цен
    }

    @GetMapping("/{id}/edit")
    public String editPriceForm(@PathVariable Long id, Model model) {
        priceService.getPriceById(id).ifPresent(price -> model.addAttribute("price", price));
        return "edit-price"; // Имя представления
    }

    @GetMapping("/{id}/delete")
    public String deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return "redirect:/prices"; // Перенаправление на список цен
    }
}
