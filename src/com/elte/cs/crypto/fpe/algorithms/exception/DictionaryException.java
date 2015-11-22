package com.elte.cs.crypto.fpe.algorithms.exception;

/**
 *
 * @author Sandip Pandey
 */
public class DictionaryException extends Exception {

    public DictionaryException() {
        super("Dictionary Exception.");
    }

    public DictionaryException(String message) {
        super("Dictionary Exception:" + message);
    }
}
