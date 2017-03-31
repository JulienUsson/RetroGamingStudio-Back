package fr.isima.repository;

import fr.isima.model.GameFranchise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameFranchiseRepository extends PagingAndSortingRepository<GameFranchise, Long> {
    Page<GameFranchise> findAll(Pageable pageable);
    GameFranchise findById(Long id);
    GameFranchise save(GameFranchise console);
    void deleteById(Long id);
}
