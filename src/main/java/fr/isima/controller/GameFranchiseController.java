package fr.isima.controller;

import fr.isima.model.Game;
import fr.isima.model.GameFranchise;
import fr.isima.service.GameFranchiseService;
import fr.isima.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GameFranchiseController {
    private static final int ITEMS_PER_PAGE = 12;
    @Autowired
    private GameFranchiseService gameFranchiseService;

    @Autowired
    private GameService gameService;

    @RequestMapping(value="/gameFranchises", method = RequestMethod.GET)
    public Page<GameFranchise> getAll(@RequestParam(required = false, defaultValue = "1") int page) {
        return gameFranchiseService.findAll(new PageRequest(page - 1, ITEMS_PER_PAGE));
    }

    @RequestMapping(value="/gameFranchises/{id}")
    public GameFranchise getById(@PathVariable long id) {
        return gameFranchiseService.findById(id);
    }

    @RequestMapping(value="/gameFranchises", method = RequestMethod.POST)
    public GameFranchise save(@RequestBody GameFranchise gameFranchise) {
        return gameFranchiseService.save(gameFranchise);
    }

    @RequestMapping(value="/gameFranchises/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        gameFranchiseService.deleteById(id);
    }

    @RequestMapping(value="/gameFranchises/{id}/games", method = RequestMethod.POST)
    public GameFranchise addGame(@PathVariable long id, @RequestBody Map<String, Long> json) {
        GameFranchise gameFranchise =  gameFranchiseService.findById(id);
        Game game = gameService.findById(json.get("id"));
        gameFranchise.getGames().add(game);
        game.setGameFranchise(gameFranchise);
        gameService.save(game);
        return gameFranchise;
    }
}
