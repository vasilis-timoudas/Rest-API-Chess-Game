package com.RestChessGame.repository;

import com.RestChessGame.model.entity.Move;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoveRepository extends JpaRepository<Move, Long> {

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Move m WHERE m.gameId = :gameId")
    boolean existsByGameId(@Param("gameId") Long gameId);

    @Modifying
    @Query("DELETE FROM Move m WHERE m.gameId = :gameId")
    void deleteByGameId(@Param("gameId") Long gameId);

    List<Move> findByGameId(Long gameId);

    @Query("SELECT m FROM Move m WHERE m.gameId = :gameId AND m.moveId = :moveId")
    Optional<Move> findByGameIdAndId(Long gameId, Long moveId);

    List<Move> findByGameIdAndCurrentTurn(Long gameId, String currentTurn);
}
