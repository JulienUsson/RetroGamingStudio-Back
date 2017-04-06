package fr.isima.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import fr.isima.model.*;
import fr.isima.repository.ConsoleRepository;
import fr.isima.repository.GameFranchiseRepository;
import fr.isima.repository.GameRepository;
import fr.isima.request.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;

@Service
@Transactional
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private GameFranchiseService gameFranchiseService;

    public Page<Game> findAll(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Page<Game> findAllWhere(String searchedValue, Pageable pageable) {
        QGame game = QGame.game;
        StringExpression searchExpression = Expressions.asString("%").concat(searchedValue).concat("%");
        Predicate query = game.name.likeIgnoreCase(searchExpression)
                .or(game.gameFranchise.name.likeIgnoreCase(searchExpression));
        return gameRepository.findAll(query, pageable);
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
        game.setInterestScores(new ArrayList<>());
        game.setGraphicsScores(new ArrayList<>());
        game.setPlayabilityScores(new ArrayList<>());
        if(gameRequest.getGameFranchise() != null) {
            GameFranchise gameFranchise = gameFranchiseService.findById((long) gameRequest.getGameFranchise());
            game.setGameFranchise(gameFranchise);
        }
        if(game.getConsoles() == null) {
            game.setConsoles(new HashSet<>());
        }
        for(int consoleId : gameRequest.getConsoles()) {
            Console console = consoleService.findById((long) consoleId);
            game.getConsoles().add(console);
        }
        return game;
    }
}
