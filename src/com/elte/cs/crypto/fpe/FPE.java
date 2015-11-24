package com.elte.cs.crypto.fpe;

import com.elte.cs.crypto.fpe.algorithms.exception.DictionaryException;
import java.util.List;

public interface FPE {

    public void setup(String key, List<String> dictionary);
//    public void loadDictionary(String key, List<String> dictionary);
//    public void setKey(String key);

    public String encrypt(String plainText) throws DictionaryException;
    public String encrypt(String plainText, String key) throws DictionaryException;
    public String encrypt(String plainText, String key, List<String> dictionary) throws DictionaryException;

    public String decrypt(String encryptedText) throws DictionaryException;
    public String decrypt(String encryptedText, String key) throws DictionaryException;
    public String decrypt(String encryptedText, String key, List<String> dictionary) throws DictionaryException;

}
