package fr.isima.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import fr.isima.model.Console;
import fr.isima.model.Game;
import fr.isima.model.QGame;
import fr.isima.model.QGameFranchise;
import fr.isima.repository.ConsoleRepository;
import fr.isima.repository.GameRepository;
import fr.isima.request.GameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;

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

    public Page<Game> findAllWhere(String searchedValue, Pageable pageable) {
        QGame game = QGame.game;
        QGameFranchise gameFranchise = QGameFranchise.gameFranchise;
        StringExpression searchExpression = Expressions.asString("%").concat(searchedValue).concat("%");
        Predicate query = game.name.likeIgnoreCase(searchExpression);
//                .or(gameFranchise.name.likeIgnoreCase(Expressions.asString("%").concat(searchedValue).concat("%")));
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
