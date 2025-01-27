package com.cbm.dslist.controller;

import com.cbm.dslist.dto.GameListDTO;
import com.cbm.dslist.dto.GameMinDTO;
import com.cbm.dslist.dto.ReplacementDTO;
import com.cbm.dslist.service.GameListService;
import com.cbm.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId) {
        return gameService.findByGameList(listId);
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
