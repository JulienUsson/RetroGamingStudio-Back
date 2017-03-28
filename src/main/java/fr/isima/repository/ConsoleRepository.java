package fr.isima.repository;

import fr.isima.model.Console;
import org.springframework.data.repository.CrudRepository;
import java.util.Set;

public interface ConsoleRepository extends CrudRepository<Console, Long> {
    Set<Console> findAll();
    Console findById(Long id);
    Console save(Console console);
    void deleteById(Long id);
}