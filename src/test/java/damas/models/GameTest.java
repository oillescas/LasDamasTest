package damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import damas.models.Color;
import damas.models.Coordinate;
import damas.models.Game;

/**
 * GameTest
 */
public class GameTest {

    public GameTest(){

    }


    @Test
    public void givenGameWhenGetCorrectWhitePieceThenGetWitePiece(){
        Game game = new Game();
        Coordinate origin = new Coordinate(5, 0);
        assertEquals(game.getPiece(origin).getColor(), Color.WHITE);
    }

    @Test
    public void givenGameWhenGetCorrectBlackPieceThenGetBlackPiece(){
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        assertEquals(game.getPiece(origin).getColor(), Color.BLACK);
    }

    @Test
    public void givenGameWhenGetEmptyPiceThenGetNull(){
        Game game = new Game();
        Coordinate origin = new Coordinate(4,3);
        assertNull(game.getPiece(origin));
    }

    @Test
    public void givenGameWhenCleanGameThenGetStartGame(){
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        Game game = new Game();
        game.move(origin, target);
        game.clean();
        assertEquals(game.getPiece(origin).getColor(), Color.WHITE);
    }


}
