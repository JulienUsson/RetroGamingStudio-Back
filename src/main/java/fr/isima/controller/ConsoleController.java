package fr.isima.controller;

import fr.isima.model.Console;
import fr.isima.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ConsoleController {
    @Autowired
    private ConsoleService consoleService;

    @RequestMapping(value="/consoles")
    public Set<Console> getAll() {
        return consoleService.findAll();
    }

    @RequestMapping(value="/consoles/{id}")
    public Console getById(@PathVariable long id) {
        return consoleService.findById(id);
    }

    @RequestMapping(value="/consoles", method = RequestMethod.POST)
    public Console save(@RequestBody Console console) {
        return consoleService.save(console);
    }

    @RequestMapping(value="/consoles/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        consoleService.deleteById(id);
    }
}
