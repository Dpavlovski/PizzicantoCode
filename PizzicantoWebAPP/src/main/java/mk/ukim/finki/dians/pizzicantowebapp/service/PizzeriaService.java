package mk.ukim.finki.dians.pizzicantowebapp.service;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import java.util.List;
import java.util.Optional;

public interface PizzeriaService {
    List<Pizzeria> getPizzeriasInCity(String state, String city);
    List<Pizzeria> getPizzerias();
    List<String> getStates();
    List<String> getCitiesInState(String state);
    Optional<Pizzeria> getPizzeriaById(Long Id);
    Pizzeria getPizzeriaByStateAndCityAndName(String state, String city,String name);
}