package com.techelevator.crm;
import org.junit.Test;
import org.junit.Assert;

public class PetTests {
    @Test
    public void testForListVaccinations() {
        Pet pet = new Pet("name", "staffie");




        Assert.assertEquals("The vaccinations returned did not match.", "[]", pet.listVaccinations());
    }
}
