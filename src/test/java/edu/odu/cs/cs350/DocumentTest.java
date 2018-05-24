package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import edu.odu.cs.cs350.Document;


public class DocumentTest 
{
	@Test
	public final void testparseascii()throws IOException, SAXException, TikaException
	{
		Document testDoc = new Document();
		String exptxt = " ";
		String acttxt = " ";
		
		File testFile = new File("./src/test/data/asciitest.txt");
		acttxt = testDoc.parseDocument(testFile);
		assertTrue(exptxt.equals(acttxt));
		
	}
	
	@Test
	public final void testparsepdf()throws IOException, SAXException, TikaException
	{
		Document testDoc = new Document();
		String exptxt = " ";
		String acttxt = " ";
		
		File testFile = new File("./src/test/data/pdftest.pdf");
		acttxt = testDoc.parseDocument(testFile);
		assertTrue(exptxt.equals(acttxt));
		
	}
	
	@Test
	public final void testparsexml()throws IOException, SAXException, TikaException
	{
		Document testDoc = new Document();
		String exptxt = " ";
		String acttxt = " ";
		
		File testFile = new File("./src/test/data/xmltest.xml");
		acttxt = testDoc.parseDocument(testFile);
		assertTrue(exptxt.equals(acttxt));
		
	}
	
	@Test
	public final void testparsehtml()throws IOException, SAXException, TikaException
	{
		Document testDoc = new Document();
		String exptxt = " ";
		String acttxt = " ";
		
		File testFile = new File("./src/test/data/htmltest.html");
		acttxt = testDoc.parseDocument(testFile);
		assertTrue(exptxt.equals(acttxt));

	}
	@Test
	public final void testIdentifyDocumentType()throws IOException, SAXException, TikaException
	{
		
		Document doc = new Document();
		File ascii = new File("./src/test/data/asciitest.txt");
		File pdf = new File("./src/test/data/pdftest.pdf");
		File xml = new File("./src/test/data/xmltest.xml");
		File html = new File("./src/test/data/htmltest.html");
		try {
			assertEquals("ASCII",doc.identifyDocumentType(ascii));
			assertEquals("PDF",doc.identifyDocumentType(pdf));
			assertEquals("XML",doc.identifyDocumentType(xml));
			assertEquals("HTML",doc.identifyDocumentType(html));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
Document Testr = new Document();
	
	String temp = "One great difference arises with experimental control. In a standard experiment this involves the selection, at random, "
			+ "of members for two different groups.  The members of one group receive "
			+ "the special, experimental treatment. Members of the other group, called "
			+ "the control group, do not receive that special treatment, although they are"
			+ " subjected to the same environment as the first group in every other respect.";
	
	Vector<String> Hope = new Vector<>(Testr.WordList(temp));
	
	
	@Test
	public void WordListTest(){
		
		//Testr.CommonWordCut(Hope);
		
		//for(int i = 0; i < Testr.WordList(temp).size(); i++){
			
				//System.out.println(Hope.elementAt(0));
		//};
		
		for(int i = 0; i < Testr.WordList(temp).size(); i++){
			
			assertEquals(Hope.elementAt(i), Testr.WordList(temp).elementAt(i));
			
		}
		
		//Uses the split function to separate words in the temp string
		String[] split = temp.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
		
		//Makes sure the split values are the same as the output passes to hope.
		for(int T = 0; T < Hope.size(); T++){
			
			assertEquals(Hope.elementAt(T), split[T]);
			
		}
		
		//Checks to see that each word in the WordList output is contained in the input string.
		for(int i =0; i< Hope.size(); i++){
			
			assertTrue(temp.contains(Hope.elementAt(i)));
		}
		
	}
	
	@Test
	public void CommonWordCutTest() throws IOException{
		 FileReader inputStream = new FileReader("CommonWords.txt");
		  
		  BufferedReader bufferedReader = new BufferedReader (inputStream);
		  
		  Vector<String> CommonWords = new Vector<String>();
			  
			  Scanner LoadWords = new Scanner(bufferedReader);
			  
			  while(LoadWords.hasNext()){
				  
				  CommonWords.addElement(LoadWords.nextLine());
				  
			  }
		
		Hope = Testr.CommonWordCut(Hope);
		
		for(int i = 0; i < Hope.size(); i++){
			assertFalse(Hope.contains(CommonWords));
		}
			
			System.out.println(Hope);
	//}
		
	}
	
	//@Test
	/*public void documentIntegrationTest(){
		File file = "";
		
		Document Doc = new Document();
		Doc.CommonWordCut(Doc.WordList(Doc.parseDocument(file)));
		
	}*/
}
