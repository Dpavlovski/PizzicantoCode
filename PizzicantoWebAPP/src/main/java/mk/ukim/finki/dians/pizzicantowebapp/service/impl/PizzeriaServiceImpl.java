package mk.ukim.finki.dians.pizzicantowebapp.service.impl;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import mk.ukim.finki.dians.pizzicantowebapp.repository.PizzeriaRepository;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {
    private final PizzeriaRepository pizzeriaRepository;

    public PizzeriaServiceImpl(PizzeriaRepository pizzeriaRepository){
        this.pizzeriaRepository = pizzeriaRepository;
    }

    @Override
    public List<Pizzeria> getPizzeriasInCity(String state, String city){
        return pizzeriaRepository.findPizzeriasByStateAndCity(state, city);
    }

    @Override
    public List<Pizzeria> getPizzerias(){
        return pizzeriaRepository.findPizzerias();
    }

    @Override
    public List<String> getStates() {
        return pizzeriaRepository.findStates();
    }

    @Override
    public List<String> getCitiesInState(String state) {
        return pizzeriaRepository.findCitiesByState(state);
    }

    @Override
    public Optional<Pizzeria> getPizzeriaById(Long Id) {
        return pizzeriaRepository.findPizzeriaById(Id);
    }

    @Override
    public Pizzeria getPizzeriaByStateAndCityAndName(String state, String city, String name) {
        return pizzeriaRepository.findPizzeriaByStateAndByCityAndByName(state,city,name);
    }
}