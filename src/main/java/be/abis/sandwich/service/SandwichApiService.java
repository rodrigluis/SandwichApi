package be.abis.sandwich.service;

import be.abis.sandwich.exception.ApiException;
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
        System.out.println("[API][Service] FINDALLSANDWICHES");
        List<Sandwich> sandwiches = sandwichRepository.findAllSandwiches();
        if (sandwiches.size() <= 0) {
            throw new ApiException(ApiException.Type.NO_SANDWICH);
        }
        return sandwiches;
    }

    @Override
    public Sandwich findSandwichById(int id) {
        System.out.println("[API][Service] FINDSANDWICHBYID [" + id + "]");
        Sandwich sandwich = sandwichRepository.findSandwichById(id);
        if (sandwich == null) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwich;
    }

    @Override
    public Sandwich findSandwichByName(String name) {
        System.out.println("[API][Service] FINDSANDWICHBYNAME [" + name + "]");
        Sandwich sandwich = sandwichRepository.findSandwichByName(name);
        if (sandwich == null) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwich;
    }

    @Override
    public List<Sandwich> findSandwichesByCategory(String category) {
        System.out.println("[API][Service] FINDSANDWICHESBYCATEGORY [" + category + "]");
        List<Sandwich> sandwiches = sandwichRepository.findSandwichesByCategory(category);
        if (sandwiches.size() <= 0) {
            throw new ApiException(ApiException.Type.DOES_NOT_EXIST);
        }
        return sandwiches;
    }

    @Override
    public void addSandwich(Sandwich sandwich) {
        System.out.println("[API][Service] ADDSANDWICH");
        sandwichRepository.addSandwich(sandwich);
    }

    @Override
    public void updatePrice(Sandwich sandwich) {
        System.out.println("[API][Service] UPDATEPRICE [" + sandwich.toString() + "]");
        sandwichRepository.updatePrice(sandwich);
    }

    @Override
    public void deleteSandwich(int id) {
        System.out.println("[API][Service] DELETESANDWICH");
        sandwichRepository.deleteSandwich(id);
    }
}
