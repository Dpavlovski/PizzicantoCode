package mk.ukim.finki.dians.pizzicantowebapp.service.impl;

import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import mk.ukim.finki.dians.pizzicantowebapp.repository.PizzeriaRepository;
import mk.ukim.finki.dians.pizzicantowebapp.service.PizzeriaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {
    private final PizzeriaRepository pizzeriaRepository;

    public PizzeriaServiceImpl(PizzeriaRepository pizzeriaRepository){
        this.pizzeriaRepository = pizzeriaRepository;
    }

    @Override
    public List<Pizzeria> getPizzeriasInCity(String state, String city){
        return pizzeriaRepository.getPizzeriasInCity(state, city);
    }

    @Override
    public List<Pizzeria> getPizzerias(){
        return pizzeriaRepository.getPizzerias();
    }

    @Override
    public List<String> getStates() {
        return pizzeriaRepository.getStates();
    }

    @Override
    public List<String> getCitiesInState(String state) {
        return pizzeriaRepository.getCitiesInState(state);
    }
}