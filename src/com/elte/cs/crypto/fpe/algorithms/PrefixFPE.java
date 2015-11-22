package com.elte.cs.crypto.fpe.algorithms;

import com.elte.cs.crypto.fpe.FPE;
import com.elte.cs.crypto.fpe.algorithms.exception.DictionaryEmptyException;
import com.elte.cs.crypto.fpe.algorithms.exception.DictionaryException;
import com.elte.cs.crypto.fpe.algorithms.exception.DictionaryNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Sandip Pandey
 */
public class PrefixFPE implements FPE {

    private String encryptionKey;
    private List<String> dictionary;
    private List<String> cipherDictionary;
    
    public PrefixFPE(String key,List<String> dict) throws Exception {
        this.dictionary = dict;
        this.encryptionKey = key;
        this.loadDictionary(key, dictionary);
    }

    public void buildDictionaryIndex() throws DictionaryException {
        if (dictionary == null) {
            throw new DictionaryNotFoundException();
        }
        if (dictionary.isEmpty()) {
            throw new DictionaryEmptyException();
        }

    }

    public void setKey(String key) {
        this.encryptionKey = key;
    }

    public void loadDictionary(String key, List<String> inputDictionary) throws Exception {
        this.encryptionKey = key;
        this.dictionary = inputDictionary;
        createTable(key);
    }

    private void createTable(String key) throws Exception {

        if (dictionary != null && !dictionary.isEmpty()) {

            cipherDictionary = new ArrayList<>();
            List<String> encryptedDictionary = new ArrayList<>();
            Map<String, String> encryptLookupMap = new TreeMap<>();

            for (String word : dictionary) {
                String encryptedWord = AES.encrypt(word, key);
                encryptedDictionary.add(encryptedWord);
                encryptLookupMap.put(encryptedWord, word);
            }

            Collections.sort(encryptedDictionary);
            
            for (int i = 0; i < dictionary.size(); i++) {
                String indexedEncryptedWord = encryptedDictionary.get(i);
                String cipherWord = encryptLookupMap.get(indexedEncryptedWord);
                cipherDictionary.add(i, cipherWord);
            }

        }

    }
    
    public String encrypt(String plainText) throws DictionaryException {
        if (cipherDictionary == null) {
            throw new DictionaryNotFoundException();
        }
        if (cipherDictionary.isEmpty()) {
            throw new DictionaryEmptyException();
        }

        if (dictionary.contains(plainText)) {
            return cipherDictionary.get(dictionary.indexOf(plainText));
        }
        return null;
    }

    @Override
    public String encrypt(String plainText, String key) throws DictionaryException {
        if (cipherDictionary == null) {
            throw new DictionaryNotFoundException();
        }
        if (cipherDictionary.isEmpty()) {
            throw new DictionaryEmptyException();
        }

        if (dictionary.contains(key)) {
            return cipherDictionary.get(dictionary.indexOf(key));
        }
        return null;
    }

    @Override
    public String encrypt(String plainText, String key, List<String> dictionary) throws DictionaryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String decrypt(String encryptedText) throws DictionaryException {
        if (cipherDictionary == null) {
            throw new DictionaryNotFoundException();
        }
        if (cipherDictionary.isEmpty()) {
            throw new DictionaryEmptyException();
        }

        if (cipherDictionary.contains(encryptedText)) {
            return dictionary.get(cipherDictionary.indexOf(encryptedText));
        }
        return null;
    }
    
    @Override
    public String decrypt(String encryptedText, String key) throws DictionaryException {
        if (cipherDictionary == null) {
            throw new DictionaryNotFoundException();
        }
        if (cipherDictionary.isEmpty()) {
            throw new DictionaryEmptyException();
        }

        if (cipherDictionary.contains(key)) {
            return dictionary.get(cipherDictionary.indexOf(key));
        }
        return null;
    }

    @Override
    public String decrypt(String encryptedText, String key, List<String> dictionary) throws DictionaryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printDictionary(){
        System.out.println(dictionary);
    }
    
    public void printCipherDictionary(){
        System.out.println(cipherDictionary);
    }

}
