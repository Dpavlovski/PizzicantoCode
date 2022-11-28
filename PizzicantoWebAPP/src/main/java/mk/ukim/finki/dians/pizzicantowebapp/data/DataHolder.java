package mk.ukim.finki.dians.pizzicantowebapp.data;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dians.pizzicantowebapp.model.Pizzeria;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Pizzeria> pizzerias;

    @PostConstruct
    public void readFromCsv(){
        BufferedReader reader;
        pizzerias = new ArrayList<>();
            try {
                reader = new BufferedReader(new FileReader("src/main/resources/static/data.csv"));
                pizzerias=reader.lines().map(Pizzeria::new).toList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}