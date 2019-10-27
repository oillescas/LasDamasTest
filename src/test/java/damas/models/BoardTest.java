package damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import damas.models.Board;
import damas.models.Color;
import damas.models.Coordinate;
import damas.models.Men;

/**
 * BoardTest
 */
public class BoardTest {

    public BoardTest(){

    }

    @Test
    public void givenBoardWhenCheckStatusEmptySquareThemGetNull(){
        Board board = new Board();
        Coordinate square = new Coordinate(0,0);
        assertNull(board.getSquareStatus(square));
    }

    @Test
    public void givenBoardWhenCheckStatusSquareThemGetPiece(){
        Board board = new Board();
        Coordinate square = new Coordinate(2,1);
        assertEquals(board.getSquareStatus(square), new Men(Color.BLACK));
    }

    @Test
    public void givenBoardWhenCheckTwoCoordinatesDiagonalAdjacentThenGetOne(){
        Coordinate square = new Coordinate(0,1);
        Coordinate square2 = new Coordinate(1,0);
        assertEquals(Board.distanceInDiagonal(square, square2).intValue(), 1);
        assertEquals(Board.distanceInDiagonal(square2, square).intValue(), -1);
    }


    @Test
    public void givenBoardWhenCheckTwoCoordinatesDiagonalNotAdjacentThenGetMoreThanOne(){
        Coordinate square = new Coordinate(0,1);
        Coordinate square2 = new Coordinate(2,3);
        assertEquals(Board.distanceInDiagonal(square, square2).intValue(), 2);
    }

    @Test
    public void givenBoardWhenCheckTwoCoordinatesNotDiagonalThenGetNull(){
        Coordinate square = new Coordinate(0,1);
        Coordinate square2 = new Coordinate(2,3);
        assertNull(Board.distanceInDiagonal(square, square2).intValue());
    }

    @Test
    public void givenBoardWhenPutPieceInSquareThenTheSquareGetPiece(){
        Men piece = new Men(Color.BLACK);
        Board board = new Board();
        Coordinate square = new Coordinate(0,1);
        board.put(square, piece);
        assertEquals(board.getSquareStatus(square), piece);
    }

    @Test
    public void givenBoardWhenCleanSquareThenTheSquareHaveNull(){
        Board board = new Board();
        Coordinate square = new Coordinate(0,1);
        board.clean(square);

        assertNull(board.getSquareStatus(square));
    }


}
