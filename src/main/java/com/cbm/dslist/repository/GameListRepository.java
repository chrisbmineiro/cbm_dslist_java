package com.cbm.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cbm.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
}
