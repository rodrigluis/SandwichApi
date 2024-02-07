package be.abis.sandwich.service;

import be.abis.sandwich.model.Sandwich;
import be.abis.sandwich.repository.SandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SandwichApiService implements SandwichService {
    @Autowired
    private SandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> findAllSandwiches() {
        return sandwichRepository.findAllSandwiches();
    }

    @Override
    public Sandwich findSandwichById(int id) {
        return sandwichRepository.findSandwichById(id);
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        return sandwichRepository.findSandwichByName(name);
    }

    @Override
    public List<Sandwich> findSandwichesByCategory(String category) {
        return sandwichRepository.findSandwichesByCategory(category);
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        sandwichRepository.addSandwich(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        sandwichRepository.updatePrice(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        sandwichRepository.deleteSandwich(id);
    }
}
