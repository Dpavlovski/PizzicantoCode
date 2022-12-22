package mk.ukim.finki.dians.pizzicantowebapp.controller;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/Pizzicanto")
public class PizzeriaController {
    private final PizzeriaService pizzeriaService;

    public PizzeriaController(PizzeriaService pizzeriaService){
        this.pizzeriaService = pizzeriaService;
    }

    @GetMapping
    public String getPizzeriaPage(
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city,
            Model model,HttpServletRequest req) {
        Pizzeria rPizzeria=(Pizzeria) req.getSession().getAttribute("RPizzeria");
        if(rPizzeria!=null){
            model.addAttribute("random",true);
            model.addAttribute("latitude",rPizzeria.getLatitude());
            model.addAttribute("longitude",rPizzeria.getLongitude());
        }
        model.addAttribute("states",pizzeriaService.getStates());
        model.addAttribute("cities",pizzeriaService.getPizzerias().stream().map(Pizzeria::getCity).distinct().collect(Collectors.toList()));
        model.addAttribute("pizzerias",pizzeriaService.getPizzerias().stream().distinct().collect(Collectors.toList()));
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
    public String RandomMap(HttpServletRequest req){
        Random random=new Random();
        Optional<Pizzeria> pizzeria=pizzeriaService.getPizzeriaById(random.nextLong(0,pizzeriaService.getPizzerias().size()));
        pizzeria.ifPresent(value -> req.getSession().setAttribute("RPizzeria", value));
        return "redirect:/Pizzicanto";
    }
}