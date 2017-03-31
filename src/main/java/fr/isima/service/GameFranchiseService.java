package fr.isima.service;

import fr.isima.model.GameFranchise;
import fr.isima.repository.GameFranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GameFranchiseService {
    @Autowired
    private GameFranchiseRepository gameFranchiseRepository;

    public Page<GameFranchise> findAll(Pageable pageable) {
        return gameFranchiseRepository.findAll(pageable);
    }

    public GameFranchise findById(Long id) {
        return gameFranchiseRepository.findById(id);
    }

    public GameFranchise save(GameFranchise gameFranchise) {
        return gameFranchiseRepository.save(gameFranchise);
    }

    public void deleteById(Long id) {
        gameFranchiseRepository.deleteById(id);
    }
}
