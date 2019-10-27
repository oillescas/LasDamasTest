package damas.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import damas.models.State;
import damas.models.StateValue;

/**
 * StateTest
 */
public class StateTest {

    public StateTest(){

    }

    @Test
    public void givenStateWhenNextStateThenGetNexState(){
        State state = new State();
        state.next();
        assertEquals(state.getValueState(), StateValue.OPENED_GAME);
        state.next();
        assertEquals(state.getValueState(), StateValue.FINAL);
        state.next();
        assertEquals(state.getValueState(), StateValue.EXIT);
    }

    @Test
    public void givenStateWhenResetStateThenCurrenStateStart(){
        State state = new State();
        state.next();
        state.reset();

        assertEquals(state.getValueState(), StateValue.INITIAL);
    }
}
