package damas.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import damas.controllers.StartController;
import damas.models.Game;
import damas.models.State;
import damas.models.StateValue;

/**
 * StartControllerTest
 */
public class StartControllerTest {

    public StartControllerTest(){

    }

    @Test
    public void givenStartControllerWhenStartThenStateInGame(){
        Game game = new Game();
        State state = new State();
        new StartController(game, state).start();
        assertEquals(state.getValueState(), StateValue.OPENED_GAME);
    }
}
