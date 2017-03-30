package fr.isima.controller;

import fr.isima.model.GameFranchise;
import fr.isima.service.GameFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class GameFranchiseController {
    @Autowired
    private GameFranchiseService gameFranchiseService;

    @RequestMapping(value="/gameFranchises")
    public Set<GameFranchise> getAll() {
        return gameFranchiseService.findAll();
    }

    @RequestMapping(value="/gameFranchises/{id}")
    public GameFranchise getById(@PathVariable long id) {
        return gameFranchiseService.findById(id);
    }

    @RequestMapping(value="/gameFranchises", method = RequestMethod.POST)
    public GameFranchise save(@RequestBody GameFranchise GameFranchise) {
        return gameFranchiseService.save(GameFranchise);
    }

    @RequestMapping(value="/gameFranchises/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        gameFranchiseService.deleteById(id);
    }
}
