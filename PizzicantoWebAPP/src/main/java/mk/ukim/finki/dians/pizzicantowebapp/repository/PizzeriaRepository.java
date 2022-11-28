package mk.ukim.finki.dians.pizzicantowebapp.repository;

import mk.ukim.finki.dians.pizzicantowebapp.data.DataHolder;
import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PizzeriaRepository {
    public List<Pizzeria> getPizzeriasInCity(String state, String city) {
        return DataHolder.pizzerias.stream().filter(p->p.getCity().equals(city) && p.getState().equals(state))
                .collect(Collectors.toList());
    }

    public List<Pizzeria> getPizzerias() {
        return DataHolder.pizzerias;
    }
}