package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerTest {


    @Test
    public void testforCustomerGetBalance() {
        Customer customer = new Customer("Adam", "Cooper");
        Map<String, Double> servicesRendered = new HashMap<>();
        servicesRendered.put("Walking", 30.0);
        servicesRendered.put("Grooming", 100.0);
        Assert.assertEquals(130.0, customer.getBalanceDue(servicesRendered), 0.0);
    }
}
