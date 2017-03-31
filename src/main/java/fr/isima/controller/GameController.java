package fr.isima.controller;

import fr.isima.model.Game;
import fr.isima.request.GameRequest;
import fr.isima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class GameController {
    private static final int ITEMS_PER_PAGE = 12;
    @Autowired
    private GameService gameService;

    @RequestMapping(value="/games", method = RequestMethod.GET)
    public Page<Game> getAll(@RequestParam(required = false, defaultValue = "1") int page) {
        return gameService.findAll(new PageRequest(page - 1, ITEMS_PER_PAGE));
    }

    @RequestMapping(value="/games/{id}", method = RequestMethod.GET)
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
    public void addPlayabilityScore(@PathVariable long id, @RequestBody Map<String, Integer> json) {
        Game game = gameService.findById(id);
        game.getPlayabilityScores().add(json.get("score"));
        gameService.save(game);
    }

    @RequestMapping(value="/games/{id}/graphicsScores", method = RequestMethod.POST)
    public void addGraphicsScore(@PathVariable long id, @RequestBody Map<String, Integer> json) {
        Game game = gameService.findById(id);
        game.getGraphicsScores().add(json.get("score"));
        gameService.save(game);
    }

    @RequestMapping(value="/games/{id}/interestScores", method = RequestMethod.POST)
    public Game addInterestScore(@PathVariable long id, @RequestBody Map<String, Integer> json) {
        Game game = gameService.findById(id);
        game.getInterestScores().add(json.get("score"));
        gameService.save(game);
        return game;
    }
}
