package com.elte.cs.crypto.fpe;

import com.elte.cs.crypto.fpe.algorithms.PrefixFPE;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sandip Pandey
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception {
        String dictFile = "dict/list";
        List<String> dictionary = loadDictionary(dictFile);
        String encryptionKey = "0123456789abcdef";
        
        PrefixFPE fpe = new PrefixFPE(encryptionKey,dictionary);
        
        String plainName = "Abram";
        String cipherName = fpe.encrypt(plainName);
        String decryptedName = fpe.decrypt(cipherName);
        System.out.println("plain:"+plainName);
        System.out.println("encrypted:"+cipherName);
        System.out.println("decrypted:"+decryptedName);
        
    }
    
    public static List<String> loadDictionary(String dictFile) throws FileNotFoundException, IOException{
        List<String> dictionary = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(dictFile));
        String line;
        while((line=reader.readLine())!=null){
            if(!line.isEmpty()){
                dictionary.add(line);
            }
        }
        
        return dictionary;
    }
}
