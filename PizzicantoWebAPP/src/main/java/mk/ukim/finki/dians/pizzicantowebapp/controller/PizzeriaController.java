package mk.ukim.finki.dians.pizzicantowebapp.controller;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/Pizzicanto")
public class PizzeriaController {
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public String getPizzeriaPage(Model model) {
        List<Pizzeria> pizzerias = pizzeriaService.getPizzerias();
        model.addAttribute("pizzerias", pizzerias);
        return "homepage";
    }

    @PostMapping
    public String showMap(@RequestParam String state,@RequestParam String city,@RequestParam String pizzeria ){
        return "homepage";
    }
}