package com.RestChessGame.repository;

import com.RestChessGame.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Game g SET g.winner = :winner WHERE g.gameId = :gameId")
    void updateWinnerById(@Param("gameId") Long gameId, @Param("winner") String winner);

    @Transactional
    @Modifying
    @Query("UPDATE Game g SET g.currentTurn = :currentTurn WHERE g.gameId = :gameId")
    void updateCurrentTurnById(@Param("gameId") Long gameId, @Param("currentTurn") String currentTurn);

    @Transactional
    @Modifying
    @Query("UPDATE Game g SET g.gameId = :updatedGameId WHERE g.gameId = :gameId")
    void updateGameIdById(@Param("gameId") Long gameId, @Param("updatedGameId") Long updatedGameId);

}
