package fr.isima.repository;

import fr.isima.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Set;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>, QueryDslPredicateExecutor<Game> {
    Page<Game> findAll(Pageable pageable);
    Game findById(Long id);
    Game save(Game game);
    void deleteById(Long id);
}
