package edu.cs.ucsd.dbc;

import java.util.HashMap;

import static  edu.cs.ucsd.dbc.Contract.ensure;
import static edu.cs.ucsd.dbc.Contract.require;

/*
 * Adapted from: https://www.leadingagile.com/2018/05/design-by-contract-part-three/
 *
 * We have adopted a methodology in which we check method postconditions (ensures) in test case methods
 * and check method preconditions in the preamble of the method.  Although we no longer have the pure
 * "documentation" property of the contracts, the contracts themselves are highly proximal to the method.
 *
 * No class invariants are checked here, but can be checked by having an invariant assertion in every ensure
 * and require block.
 *
 * Invariant: this.capacity() >= this.count() >= 0
 *    I believe this is implied by induction of the pre/post's and don't need to be checked
 */
public class Dictionary {
    private int capacity;
    private HashMap<String,Object> contents;

    public Dictionary(int capacity) {
        require(capacity > 0, "capacity > zero");
        this.capacity = capacity;
        contents = new HashMap<String,Object>();
        ensure(capacity() == capacity, "capacity() == capacity");
        ensure(count() == 0, "count() == 0");
    }

    // Could this contract be improved?
    public void put(String key, Object value) {
        require(key != null && key.length() > 0, "key not null or empty");
        require(count() < capacity(), "count() < capacity()");
        int oldCount = count();  // wish I didn't have to do this
        contents.put(key, value);
        ensure(get(key) == value, "get(key) == value");
        ensure(count() == oldCount + 1, "count() == old(count()) + 1");
    }

    public Object get(String key) { return contents.get(key); }
    public int capacity() { return capacity; }
    public int count() { return contents.size(); }
}

//    void ensureConstructor(int capacity) {
//        ensure(capacity() == capacity, "capacity() == capacity"); // Bad DbC - ref local
//        ensure(count() == 0, "count() == 0");
//    }
//    @Override
//    public void ensurePut(String key, Object value, int oldCount) {
//        ensure(get(key) == value, "get(key) == value");
//        ensure(count() == oldCount + 1, "count() == old(count()) + 1");
//    }
