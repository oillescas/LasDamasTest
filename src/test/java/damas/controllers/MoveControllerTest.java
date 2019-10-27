package damas.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import damas.controllers.MoveController;
import damas.models.Color;
import damas.models.Coordinate;
import damas.models.Error;
import damas.models.Game;
import damas.models.Piece;
import damas.models.State;
import damas.models.StateValue;

public class MoveControllerTest {

    public MoveControllerTest() {

    }

    @Test
    public void givenMoveControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        MoveController moveController = new MoveController(game, state);
        assertNull(moveController.move(origin, target));
        assertNull(moveController.getPiece(origin));
        Piece pieceTarget = moveController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    /**
     * TODO
     * Tests de los posibles movimientos validos
     *
     * como con un peon
     * muevo un peon y se convierte una dama
     *
     * muevo una dama adelante
     * muevo una dama atras
     * como con una dama
     */



    @Test
    public void givenMoveControllerWhenMovementRequiereDestinationNotEmptyThenError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(7, 0);
        Coordinate target = new Coordinate(6, 1);
        MoveController moveController = new MoveController(game, state);
        assertEquals(moveController.move(origin, target), Error.DEST_NOT_EMPTY);
    }

    @Test
    public void givenMoveControllerWhenMovementRequiereDestinationOutBoardThenError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(6, 7);
        Coordinate target = new Coordinate(5, 8);
        MoveController moveController = new MoveController(game, state);
        assertEquals(moveController.move(origin, target), Error.OUT_BOARD);
    }

    @Test
    public void givenMoveControllerWhenMovementRequiereDestinationOtherPlayerPiezeThenError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(1, 2);
        Coordinate target = new Coordinate(0, 3);
        MoveController moveController = new MoveController(game, state);
        assertEquals(moveController.move(origin, target), Error.OTHER_PLAYER_PIECE);
    }

    /**
     * TODO
     * Resto de test de los errores aquí
     *
     * No hay movimientos validos
     * No es un movimiendo diagonal
     * El movimiento no come fichas pudiendo comer
     * No se puede comer mas de 1 en un salto
     * Peon retrocede
     */



    @Test
    public void givenMoveControllerWhenMoveNotWinnerPlayerThenNotNextState(){
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        MoveController moveController = new MoveController(game, state);
        moveController.move(origin, target);
        assertNull(moveController.getWinner());
        assertEquals(state.getValueState(), StateValue.OPENED_GAME);
    }

    @Test
    public void givenMoveControllerWhenMoveWinnerPlayerThenNextState(){
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        MoveController moveController = new MoveController(game, state);
        moveController.move(origin, target);
        /**
         * Movimientos necesarios para que un jugador gane
         *  moveController.move(origin, target);
         *  moveController.move(origin, target);
         *  moveController.move(origin, target);
         *  moveController.move(origin, target);
         */

        assertNotNull(moveController.getWinner());
        assertEquals(state.getValueState(), StateValue.FINAL);
    }

    @Test
    public void givenMoveControllerWhenViewShowPlayerThenGetPlayerColorWhite(){
        Game game = new Game();
        State state = new State();
        MoveController moveController = new MoveController(game, state);
        assertEquals(moveController.getTurn(), Color.WHITE);
    }

    @Test
    public void givenMoveControllerWhenViewShowPlayerThenGetPlayerColorBlack(){
        Game game = new Game();
        State state = new State();
        MoveController moveController = new MoveController(game, state);
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        moveController.move(origin, target);
        assertEquals(moveController.getTurn(), Color.BLACK);
    }
}

