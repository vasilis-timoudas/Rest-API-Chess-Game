package com.RestChessGame;

import com.RestChessGame.model.game.Board;
import com.RestChessGame.model.game.Pawn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class PawnTests {

    // Check if is valid Forward Move 2 positions
    @Test
    public void testForwardMoveTwoPositions() {
        Board board = new Board();
        Pawn pawnWhite = new Pawn("White");
        Pawn pawnBlack = new Pawn("Black");

        assertTrue(pawnWhite.checkMove(board, 6, 0, 4, 0));
        board.movePiece(6, 0, 4, 0);
        assertFalse(pawnWhite.isHasFirstMove());
        assertFalse(pawnWhite.checkMove(board, 4, 0, 2, 0));

        assertTrue(pawnBlack.checkMove(board, 1, 0, 3, 0));
        board.movePiece(1, 0, 3, 0);
        assertFalse(pawnBlack.isHasFirstMove());
        assertFalse(pawnBlack.checkMove(board, 1, 0, 3, 0));
    }

    // Check if is valid Forward Move 1 position
    @Test
    public void testForwardMoveOnePosition(){
        Board board = new Board();
        Pawn pawnWhite = new Pawn("White");
        Pawn pawnBlack = new Pawn("Black");

        assertTrue(pawnWhite.checkMove(board, 6, 7, 5, 7));
        board.movePiece(6, 7, 5, 7);
        assertFalse(pawnWhite.isHasFirstMove());
        assertFalse(pawnWhite.checkMove(board, 5, 7, 3, 7));

        assertTrue(pawnBlack.checkMove(board, 1, 7, 2, 7));
        board.movePiece(1, 7, 2, 7);
        assertFalse(pawnWhite.isHasFirstMove());
        assertFalse(pawnWhite.checkMove(board, 2, 7, 4, 7));

        assertTrue(pawnWhite.checkMove(board, 5, 7, 4, 7));
        board.movePiece(5, 7, 4, 7);

        assertTrue(pawnBlack.checkMove(board, 2, 7, 3, 7));
        board.movePiece(2, 7, 3, 7);

        assertFalse(pawnWhite.checkMove(board, 4, 7, 3, 7));

        assertFalse(pawnBlack.checkMove(board, 3, 7, 4, 7));
    }

    // Forward Right Move 1 position (attack only)
    @Test
    public void testForwardRightMoveOnePosition(){
        Board board = new Board();
        Pawn pawnWhite = new Pawn("White");
        Pawn pawnBlack = new Pawn("Black");

        assertTrue(pawnWhite.checkMove(board, 6, 0, 4, 0));
        board.movePiece(6, 0, 4, 0);

        assertTrue(pawnBlack.checkMove(board, 1, 1, 3, 1));
        board.movePiece(1, 1, 3, 1);

        assertTrue(pawnWhite.checkMove(board, 4, 0, 3, 1));
        board.movePiece(4, 0, 3, 1);
    }

    // Forward Left Move 1 position (attack only)
    @Test
    public void testForwardLeftMoveOnePosition(){
        Board board = new Board();
        Pawn pawnWhite = new Pawn("White");
        Pawn pawnBlack = new Pawn("Black");

        assertTrue(pawnWhite.checkMove(board, 6, 1, 4, 1));
        board.movePiece(6, 1, 4, 1);

        assertTrue(pawnBlack.checkMove(board, 1, 0, 3, 0));
        board.movePiece(1, 0, 3, 0);

        assertTrue(pawnWhite.checkMove(board, 4, 1, 3, 0));
        board.movePiece(4, 1, 3, 0);
    }
}
