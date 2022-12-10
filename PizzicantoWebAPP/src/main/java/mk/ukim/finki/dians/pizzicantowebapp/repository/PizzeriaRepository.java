package mk.ukim.finki.dians.pizzicantowebapp.repository;

import mk.ukim.finki.dians.pizzicantowebapp.data.DataHolder;
import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzeriaRepository {
    public List<Pizzeria> getPizzeriasInCity(String state, String city) {
        return DataHolder.pizzerias.stream().filter(p->p.getCity().equals(city) && p.getState().equals(state))
                .collect(Collectors.toList());
    }

    public List<String> getStates(){
        List<String> states= new ArrayList<>(DataHolder.pizzerias.stream().map(Pizzeria::getState).distinct().toList());
        states.add(0,"");
        return states;
    }
    public List<String> getCitiesInState(String state){
        List<String> cities= new ArrayList<>(DataHolder.pizzerias.stream().filter(p->p.getState().equals(state)).map(Pizzeria::getCity).distinct().toList());
        cities.add(0,"");
        return cities;
    }

    public List<Pizzeria> getPizzerias() {
        return DataHolder.pizzerias;
    }
}