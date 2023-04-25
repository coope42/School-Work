package com.techelevator.crm;

import com.techelevator.Billable;
import com.techelevator.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {

    private String phoneNumber;
    private List<String> pets = new ArrayList<>();



    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    private void setPets(List<String> pets) {
        this.pets = pets;

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<String> getPets() {
        return pets;
    }
    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }
    public Customer(String firstName, String lastName) {
        super(firstName, lastName);


        this.phoneNumber = "";
    }
    public double getBalanceDue(Map<String, Double> servicesRendered) {
        double x = 0.0;
        for (Map.Entry<String, Double> services : servicesRendered.entrySet()) {
            x += services.getValue();
        }
        return x;
    }


}
