package mk.ukim.finki.dians.pizzicantowebapp.controller;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/Pizzicanto")
public class PizzeriaController {
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public String getPizzeriaPage(
            @PathVariable(required = false) String state,
            @PathVariable(required = false) String city,
            Model model) {
        List<Pizzeria> pizzerias = pizzeriaService.getPizzerias();
        model.addAttribute("states",pizzeriaService.getStates());
        return "homepage";
    }

    @PostMapping("/setCities/{state}")
    public String afterSelectingState(@PathVariable String state,Model model){
        model.addAttribute("cities",pizzeriaService.getCitiesInState(state));
        return "redirect:/Pizzicanto/"+state;
    }

    @PostMapping("/setPizzerias/")
    public String afterSelectingCity(@RequestParam String state,@RequestParam String city,Model model){
        model.addAttribute("pizzerias",pizzeriaService.getPizzeriasInCity(state,city));
        return "redirect:/Pizzicanto/"+state+'/'+city;
    }
}