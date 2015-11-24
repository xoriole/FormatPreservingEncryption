/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elte.cs.crypto.fpe.algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phoenix
 */
public class PrefixFPETests {

    public static String dictionaryFile = "dict/list";

    List<String> dictionary;

    public PrefixFPETests() {
    }

    @Before
    public void setUp() {
        BufferedReader reader = null;
        try {
            dictionary = new ArrayList<>();
            reader = new BufferedReader(new FileReader(dictionaryFile));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    dictionary.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PrefixFPETests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PrefixFPETests.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(PrefixFPETests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @After
    public void tearDown() {
    }

     @Test
     public void hello() {}
}
