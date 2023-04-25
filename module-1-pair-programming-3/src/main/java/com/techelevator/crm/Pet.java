package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;

public class Pet {


    private String name;
    private String species;
    private List<String> vaccinations = new ArrayList<>();

    private void setName(String name) {
        this.name = name;
    }



    private void setSpecies(String species) {
        this.name = species;
    }
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    private void setVaccinations(List<String> vaccinations) {
        this.vaccinations = vaccinations;
    }
    public List<String> getVaccinations() {
        return vaccinations;
    }
    public Pet(String name, String species) {
        this.name = name;
        this.species = species;

    }

    public String listVaccinations() {
        return vaccinations.toString();
    }



}
