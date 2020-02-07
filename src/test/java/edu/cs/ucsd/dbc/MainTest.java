package edu.cs.ucsd.dbc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @Test
    void TestMain() {
        assertThrows(Contract.ViolationException.class, ()-> Main.main(new String[]{"ignored"}));
    }
}
