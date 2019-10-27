package damas.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import damas.controllers.CancelController;
import damas.models.Game;
import damas.models.State;
import damas.models.StateValue;

/**
 * CancelControllerTest
 */
public class CancelControllerTest {

    public CancelControllerTest(){

    }


    @Test
    public void givenCancelControllerWhenUserCancelThenStateFinal(){
        Game game = new Game();
        State state = new State();
        CancelController cancelController = new CancelController(game, state);
        cancelController.cancel();
        assertEquals(state.getValueState(), StateValue.FINAL);
    }
}
