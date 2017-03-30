package fr.isima.service;

import fr.isima.model.GameFranchise;
import fr.isima.repository.GameFranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class GameFranchiseService {
    @Autowired
    private GameFranchiseRepository gameFranchiseRepository;

    public Set<GameFranchise> findAll() {
        return gameFranchiseRepository.findAll();
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
