package fr.isima.repository;

import fr.isima.model.GameFranchise;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface GameFranchiseRepository extends CrudRepository<GameFranchise, Long> {
    Set<GameFranchise> findAll();
    GameFranchise findById(Long id);
    GameFranchise save(GameFranchise console);
    void deleteById(Long id);
}
