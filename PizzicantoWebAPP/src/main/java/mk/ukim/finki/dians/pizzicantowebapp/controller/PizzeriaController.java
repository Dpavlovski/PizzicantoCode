package mk.ukim.finki.dians.pizzicantowebapp.controller;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/Pizzicanto")
public class PizzeriaController {
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public String getPizzeriaPage(
            @RequestParam(required = false) String randomClicked,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city,
            Model model) {
        model.addAttribute("states",pizzeriaService.getStates());
        model.addAttribute("randomClicked",Boolean.parseBoolean(randomClicked));
        if(state!=null){
            model.addAttribute("cities",pizzeriaService.getCitiesInState(state));
            if(city!=null)
                model.addAttribute("pizzerias",pizzeriaService.getPizzeriasInCity(state,city));
        }
        return "homepage";
    }


    @PostMapping("/setCities")
    public String afterSelectingState(@RequestParam String state){
        return "redirect:/Pizzicanto?state="+state;
    }

    @PostMapping("/setPizzerias")
    public String afterSelectingCity(@RequestParam String city,Model model){
        String state=model.getAttribute("state").toString();
        return "redirect:/Pizzicanto?state="+state+"&city="+city;
    }

    @PostMapping("/Random")
    public String RandomMap(){
        return "redirect:/Pizzicanto?randomClicked=true";
    }
}