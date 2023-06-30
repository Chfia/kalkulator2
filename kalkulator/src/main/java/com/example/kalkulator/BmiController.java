package com.example.kalkulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BmiController {
    @Autowired
    private BmiEntryRepository bmiEntryRepository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("bmiEntry", new BmiEntry());
        return "bmiForm";
    }

    @PostMapping("/calculate")
    public String calculateBmi(BmiEntry bmiEntry) {
        double weight = bmiEntry.getWeight();
        double height = bmiEntry.getHeight() / 100.0; // przeliczenie wzrostu na metry
        double bmi = weight / (height * height);
        bmiEntry.setBmi(bmi);
        bmiEntryRepository.save(bmiEntry);
        return "redirect:/";
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        Iterable<BmiEntry> bmiEntries = bmiEntryRepository.findAll();
        model.addAttribute("bmiEntries", bmiEntries);
        return "bmiHistory";
    }
}
