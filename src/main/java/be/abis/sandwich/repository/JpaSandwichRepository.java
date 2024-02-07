package be.abis.sandwich.repository;

import be.abis.sandwich.model.Sandwich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSandwichRepository extends CrudRepository<Sandwich, Integer> {
    Sandwich findSandwichByName(String name);
    List<Sandwich> findSandwichesByCategory(String category);

}
