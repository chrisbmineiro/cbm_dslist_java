package com.cbm.dslist.service;

import com.cbm.dslist.dto.GameDTO;
import com.cbm.dslist.dto.GameMinDTO;
import com.cbm.dslist.entities.Game;
import com.cbm.dslist.projection.GameMinProjection;
import com.cbm.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);

    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }
}
