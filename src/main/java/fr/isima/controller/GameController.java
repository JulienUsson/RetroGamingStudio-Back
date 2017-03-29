package fr.isima.controller;

import fr.isima.model.Game;
import fr.isima.request.GameRequest;
import fr.isima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value="/games")
    public Set<Game> getAll() {
        return gameService.findAll();
    }

    @RequestMapping(value="/games/{id}")
    public Game getById(@PathVariable long id) {
        return gameService.findById(id);
    }

    @RequestMapping(value="/games", method = RequestMethod.POST)
    public Game save(@RequestBody GameRequest gameRequest) {
        Game game = gameService.gameRequestToGame(gameRequest);
        return gameService.save(game);
    }

    @RequestMapping(value="/games/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        gameService.deleteById(id);
    }
}
