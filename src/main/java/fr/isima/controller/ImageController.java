package fr.isima.controller;

import fr.isima.service.GameService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value="/images/{id}")
    public String findByGameId(@PathVariable long id) {
        return new String(Base64.encodeBase64(gameService.findById(id).getImage()));
    }
}
