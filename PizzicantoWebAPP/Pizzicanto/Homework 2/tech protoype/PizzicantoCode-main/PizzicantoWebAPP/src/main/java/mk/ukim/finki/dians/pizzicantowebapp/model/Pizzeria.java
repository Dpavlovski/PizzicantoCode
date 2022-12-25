package mk.ukim.finki.dians.pizzicantowebapp.model;

import lombok.Data;

@Data
public class Pizzeria {
    private static Long counter=0L;
    private  Long  Id;
    private String address;
    private String city;
    private String postCode;
    private String state;
    private String name;

    private String longitude;
    private String latitude;

    private final String country="United States";

    public Pizzeria(String line) {
        Id=counter++;
        name = line.split(",")[4];
        address = line.split(",")[0];
        city = line.split(",")[1];
        postCode = line.split(",")[2];
        state = line.split(",")[3];
        latitude=line.split(",")[6];
        longitude=line.split(",")[7];
    }
}