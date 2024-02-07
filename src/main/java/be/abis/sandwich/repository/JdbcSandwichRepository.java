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
        if (sandwiches.size() <= 0) {
            throw new ApiException(ApiException.Type.NO_SANDWICH);
        }
        return sandwiches;
    }

    @Override
    public Sandwich findSandwichById(int id) {
        Optional<Sandwich> sandwich = sandwichRepository.findById(Integer.valueOf(id));
        if (! sandwich.isPresent()) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwich.get();
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        Sandwich sandwich = sandwichRepository.findSandwichByName(name);
        if (sandwich == null) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwich;
    }

    @Override
    public List<Sandwich> findSandwichesByCategory(String category) {
        List<Sandwich> sandwiches = sandwichRepository.findSandwichesByCategory(category);
        if (sandwiches.size() <= 0) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwiches;
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        // Check to see whether thesandwich already exists
        sandwichRepository.save(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        // Check to see whether thesandwich already exists
        sandwichRepository.save(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        // Check to see whether thesandwich already exists
        sandwichRepository.deleteById(Integer.valueOf(id));
    }
}
