package io.github.jfuncy;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.junit.Assert.*;

public class MonadsTest {

    @Test
    public void once() throws Exception {
        Function<Integer, Optional<Integer>> onceInc = Monads.once(Funcs.inc);
        assertEquals(Integer.valueOf(6), onceInc.apply(5).get());
        assertFalse(onceInc.apply(1).isPresent());
    }

}