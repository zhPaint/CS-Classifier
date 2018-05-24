package edu.odu.cs.cs350;
import java.util.Vector;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.odu.cs.cs350.Signature;


public class SignatureTest {
	
	Vector<String> testVocab = new Vector<String>();
	Signature testSig = new Signature();
	
	@Before
	public void Initialize()
	{
		String letter = "";
		Random r = new Random();
		for(int i = 0; i < 26; i++){
			char c = (char) (i + 'a');
			letter = Character.toString(c);
			testVocab.add(letter);
		}
	}
	
	@Test
	public final void testWeightWord()
	{
		int documentFrequency = 5;
		int totalNumDocuments = 10;
		assertEquals(1,(int)testSig.WeightWord(documentFrequency,totalNumDocuments));
	}
	
	@Test
	public final void testcountWords()
	{
		//Prep test Vector
		Vector<String> testdoc = new Vector<String>();
		Vector<Integer> testoutput = new Vector<Integer>();
		
		String letter = "";
		int aTest = 0;
		int bTest = 0;
		Random r = new Random();
		
		for(int i = 0; i < 100; i++){
			char c = (char) (r.nextInt(26) + 'a');
			if(c == 'a')aTest++;
			if(c == 'b')bTest++;
			letter = Character.toString(c);
			testdoc.add(letter);
		}
		
		//test function
		testSig.countWords(testdoc);
		
		testoutput = testSig.getSignature();
		assertTrue(testoutput.size() == 100);
		assertTrue(testoutput.get(0) == aTest);
		assertTrue(testoutput.get(1) == bTest);
		
	}
	public final void testNormalizeSig(){
		Random wc = new Random();
		for(int i =0; i <10; i++){
			testSig.sig.set(i, wc.nextInt(100));
		}
		
		Vector<Integer> testvec = new Vector<Integer>();
		
		testvec = testSig.sig;
		
		testSig.NormalizeSig();
		
		for(int j =0; j < 10; j++){
			if(testvec.elementAt(j) >= 5)
				assertTrue(testSig.sig.elementAt(j) == 1);
			else
				assertTrue(testSig.sig.elementAt(j) == 0);
		}
		
		
	}

}
