package fr.isima.controller;

import fr.isima.model.Game;
import fr.isima.request.GameRequest;
import fr.isima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @RequestMapping(value="/games/{id}/playabilityScores", method = RequestMethod.POST)
    public void addPlayabilityScore(@PathVariable long id, @RequestBody Map<String, String> json) {
        Game game = gameService.findById(id);
        game.getPlayabilityScores().add(Integer.parseInt(json.get("score")));
        gameService.save(game);
    }

    @RequestMapping(value="/games/{id}/graphicsScores", method = RequestMethod.POST)
    public void addGraphicsScore(@PathVariable long id, @RequestBody Map<String, String> json) {
        Game game = gameService.findById(id);
        game.getGraphicsScores().add(Integer.parseInt(json.get("score")));
        gameService.save(game);
    }

    @RequestMapping(value="/games/{id}/interestScores", method = RequestMethod.POST)
    public void addInterestScore(@PathVariable long id, @RequestBody Map<String, String> json) {
        Game game = gameService.findById(id);
        game.getInterestScores().add(Integer.parseInt(json.get("score")));
        gameService.save(game);
    }
}
