package be.abis.sandwich.controller;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.service.SandwichService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichApiController {
    @Autowired
    private SandwichService sandwichService;

    @PostMapping(path = "/mgmt/sandwich", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @RolesAllowed("AbisAdmin")
    public void addSandwich(@Valid @RequestBody Sandwich sandwich) {
        System.out.println("[API][Controller] ADDSANDWICH");
        sandwichService.addSandwich(sandwich);
    }

    @PatchMapping(path = "/mgmt/sandwich", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @RolesAllowed("AbisAdmin")
    public void updateSandwichPrice(Sandwich sandwich) {
        System.out.println("[API][Controller] UPDATESANDWICHPRICE");
        sandwichService.updatePrice(sandwich);
    }

    @DeleteMapping(path = "/mgmt/sandwich/{id}")
    @RolesAllowed("AbisAdmin")
    public void deleteSandwich(@PathVariable("id") int id) {
        System.out.println("[API][Controller] DELETESANDWICH");
        sandwichService.deleteSandwich(id);
    }

    @GetMapping(path = "/sandwiches/all")
    public ResponseEntity<List<Sandwich>> getAllSandwiches() {
        System.out.println("[API][Controller] GETALLSANDWICHES");
        HttpHeaders rspHeaders = new HttpHeaders();
//        rspHeaders.add("api-key", apiKey);
        return new ResponseEntity<List<Sandwich>>(sandwichService.findAllSandwiches(), rspHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/sandwich/{id}")
    public ResponseEntity<Sandwich> getSandwichById(@PathVariable("id") int id) {
        System.out.println("[API][Controller] GETSANDWICHBYID");
        HttpHeaders rspHeaders = new HttpHeaders();
//        rspHeaders.add("api-key", apiKey);
        return new ResponseEntity<Sandwich>(sandwichService.findSandwichById(id), rspHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/sandwich")
    public ResponseEntity<Sandwich> getSandwichByName(@RequestParam("name") String name) {
        System.out.println("[API][Controller] GETSANDWICHBYNAME [" + name + "]");
        HttpHeaders rspHeaders = new HttpHeaders();
//        rspHeaders.add("api-key", apiKey);
        return new ResponseEntity<Sandwich>(sandwichService.findSandwichByName(name), rspHeaders, HttpStatus.OK);
    }

    @GetMapping(path = "/sandwiches")
    public ResponseEntity<List<Sandwich>> getAllSandwichesByCategory(@RequestParam("category") String category) {
        System.out.println("[API][Controller] GETSANDWICHESBYCATEGORY");
        HttpHeaders rspHeaders = new HttpHeaders();
//        rspHeaders.add("api-key", apiKey);
        return new ResponseEntity<List<Sandwich>>(sandwichService.findSandwichesByCategory(category), rspHeaders, HttpStatus.OK);
    }
}
