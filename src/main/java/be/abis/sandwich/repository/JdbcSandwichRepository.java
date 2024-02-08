package be.abis.sandwich.repository;

import be.abis.sandwich.exception.ApiException;
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
        Optional<Sandwich> sandwich = sandwichRepository.findById(id);
        return sandwich.isPresent() ? sandwich.get() : null;
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
        // Check to see whether the sandwich already exists
        if (findSandwichByName(sandwich.getName()) != null) {
            throw new ApiException(ApiException.Type.ALREADY_EXISTS);
        }
        sandwichRepository.save(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        // Check to see whether the sandwich already exists
        if (findSandwichByName(sandwich.getName()) == null) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        sandwichRepository.save(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        // Check to see whether the sandwich already exists
        if (findSandwichById(id) == null) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        sandwichRepository.deleteById(id);
    }
}
