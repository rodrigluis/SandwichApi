package be.abis.sandwich;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.SandwichRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SandwichRepositoryTests {
    @Autowired
    SandwichRepository sandwichRepository;

    @Test
    void contextLoads() {
    }
    @Test
    @Order(1)
    void testFindAllSandwiches() {
        List<Sandwich> sandwiches = sandwichRepository.findAllSandwiches();
        assertEquals(2,sandwiches.size());
    }

    @Test
    @Order(2)
    void testFindSandwichById() {
        Sandwich sandwich = sandwichRepository.findSandwichById(1);
        assertEquals("Parmaham",sandwich.getName());
    }

    @Test
    @Order(3)
    void testFindSandwichByName() {
        Sandwich sandwich = sandwichRepository.findSandwichByName("Parmaham");
        assertEquals(1,sandwich.getId());
    }

    @Test
    @Order(4)
    void testFindSandwichesByCategory() {
        List<Sandwich> sandwiches = sandwichRepository.findSandwichesByCategory("Vlees");
        assertEquals(2,sandwiches.size());
    }

    @Test
    @Order(5)
    void testAddSandwich() {
        Sandwich sandwich = new Sandwich();
        sandwich.setName("Barbecue");
        sandwich.setCategory("Vlees");

        sandwichRepository.addSandwich(sandwich);

        Sandwich foundSandwich = sandwichRepository.findSandwichByName ("Barbecue");
        assertEquals("Vlees",foundSandwich.getCategory());
    }

    @Test
    @Order(6)
    void testUpdatePrice() {
        Sandwich sandwich = sandwichRepository.findSandwichById(1);
        sandwich.setBasePrice(4.5);
        sandwichRepository.updatePrice(sandwich);

        Sandwich foundSandwich = sandwichRepository.findSandwichById(1);
        assertEquals(4.5,foundSandwich.getBasePrice());
    }

    @Test
    @Order(7)
    void testDeleteSandwich() {
        Sandwich sandwich = sandwichRepository.findSandwichByName ("Barbecue");
        sandwichRepository.deleteSandwich(sandwich.getId());

        Sandwich foundSandwich = sandwichRepository.findSandwichByName ("Barbecue");
        assertNull(foundSandwich);
    }


}
