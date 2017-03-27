package fr.isima.repository;

import fr.isima.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface GameRepository extends CrudRepository<Game, Long> {
    Set<Game> findAll();
    Game findById(Long id);
    Game save(Game game);
    void deleteById(Long id);
}
