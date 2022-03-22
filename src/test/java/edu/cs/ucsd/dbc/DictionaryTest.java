package edu.cs.ucsd.dbc;

import org.junit.jupiter.api.Test;

/*
 * Substantially adapted from: https://www.leadingagile.com/2018/05/design-by-contract-part-three/
 *
 * In DbC, the value of a test suite is to cause the contracts to be executed.
 *
 * Below are tests that check the supplier's "ensures" - postconditions.
 *
 * The client contracts - preconditions - will be checked when the clients are tested, because when the clients run
 * in the tests, their use of the suppliers will result in the require clauses to be executed.
 */
class DictionaryTest {

//    @Test
//    void checkDictionaryConstructorContracts() {
//        new Dictionary(5).ensureConstructor(5);
//        new Dictionary(1000).ensureConstructor(1000);
//    }

    @Test
    void  checkDictionaryPutContracts() {
        Dictionary dict = new Dictionary(1);
        int oldCount = dict.count(); // could just say "0" since we know it's new
        dict.put("key1", "value1");
//        dict.ensurePut("key1", "value1", oldCount);
    }
}
