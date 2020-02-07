package edu.cs.ucsd.dbc;

/*
 * Example client code.  Everything should work until the last line, which should throw an precondition exception.
 */
public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary(2);
        dict.put("first", "value1");
        dict.put("second", "value2");
        System.out.println("First element: " + dict.get("first"));
        dict.put("third", "value3");
    }
}
