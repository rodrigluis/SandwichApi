package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcSandwichRepository implements SandwichRepository {
    @Resource
    JpaSandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> findAllSandwiches() {
        List<Sandwich> sandwiches = new ArrayList<>();
        sandwichRepository.findAll().forEach(sandwiches::add);
        return sandwiches;
    }

    @Override
    public Sandwich findSandwichById(int id) {
        Optional<Sandwich> sandwich = sandwichRepository.findById(Integer.valueOf(id));
        return (sandwich.isPresent()?sandwich.get():null);
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
        sandwichRepository.save(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        sandwichRepository.save(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        sandwichRepository.deleteById(Integer.valueOf(id));
    }
}
