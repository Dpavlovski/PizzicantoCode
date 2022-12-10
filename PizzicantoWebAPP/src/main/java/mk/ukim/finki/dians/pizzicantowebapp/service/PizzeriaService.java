package mk.ukim.finki.dians.pizzicantowebapp.service;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import java.util.List;

public interface PizzeriaService {
    List<Pizzeria> getPizzeriasInCity(String state, String city);
    List<Pizzeria> getPizzerias();
    List<String> getStates();
    List<String> getCitiesInState(String state);
}