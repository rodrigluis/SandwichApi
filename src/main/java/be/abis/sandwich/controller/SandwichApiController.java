package be.abis.sandwich.controller;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.service.SandwichService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sandwich")
public class SandwichApiController {
    @Autowired
    private SandwichService sandwichService;

    @PostMapping(path = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @RolesAllowed("AbisAdmin")
    public void addSandwich(@Valid @RequestBody Sandwich sandwich) {
        sandwichService.addSandwich(sandwich);
    }

    @PatchMapping(path = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @RolesAllowed("AbisAdmin")
    public void updateSandwichPrice(Sandwich sandwich) {
        sandwichService.updatePrice(sandwich);
    }

    @DeleteMapping(path = "{id}")
    @RolesAllowed("AbisAdmin")
    public void deleteSandwich(@PathVariable("id") int id) {
        sandwichService.deleteSandwich(id);
    }

    @GetMapping
    public List<Sandwich> getAllSandwiches() {
        return sandwichService.findAllSandwiches();
    }

    @GetMapping(path = "{id}")
    public Sandwich getSandwichById(@PathVariable("id") int id) {
        return sandwichService.findSandwichById(id);
    }

    @GetMapping
    public Sandwich getSandwichByName(@RequestParam("name") String name) {
        return sandwichService.findSandwichByName(name);
    }

    @GetMapping
    public List<Sandwich> getAllSandwichesByCategory(@RequestParam("category") String category) {
        return sandwichService.findSandwichesByCategory(category);
    }
}
