package damas.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import damas.models.Game;
import damas.models.State;
import damas.models.StateValue;

/**
 * ResumeControllerTest
 */
public class ResumeControllerTest {

    public ResumeControllerTest(){

    }

    @Test
    public void givenResumeControllerWhenResumeGameThenStateChangeToInitial(){
        Game game = new Game();
        State state = new State();
        state.next();
        new ResumeController(game, state).resume(true);
        assertEquals(state.getValueState(), StateValue.INITIAL);
        assertEquals(game, new Game());
    }

    @Test
    public void givenResumeControllerWhenNoResumeGameThenStateChangeToExit(){
        Game game = new Game();
        State state = new State();
        new ResumeController(game, state).resume(false);
        assertEquals(state.getValueState(), StateValue.EXIT);
    }
}
