package fr.isima.service;

import fr.isima.model.Game;
import fr.isima.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Set<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id);
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }
}
