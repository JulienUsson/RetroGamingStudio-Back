package fr.isima.service;

import fr.isima.model.Console;
import fr.isima.model.Game;
import fr.isima.repository.ConsoleRepository;
import fr.isima.repository.GameRepository;
import fr.isima.request.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
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

    public Game gameRequestToGame(GameRequest gameRequest) {
        Game game = new Game();
        game.setName(gameRequest.getName());
        game.setDescription(gameRequest.getDescription());
        game.setImage(gameRequest.getImage());
        if(game.getConsoles() == null) {
            game.setConsoles(new HashSet<>());
        }
        for(int consoleId : gameRequest.getConsoles()) {
            Console console = consoleRepository.findById((long) consoleId);
            game.getConsoles().add(console);
        }
        return game;
    }
}
