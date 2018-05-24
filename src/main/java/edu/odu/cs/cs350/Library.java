package edu.odu.cs.cs350;
/**
 * 
 */


import java.io.File;
import java.io.IOException;
import java.util.Vector;

//Tika imports
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 * @author RC
 * Main Class
 */
public class Library 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, SAXException, TikaException
	{
		/// Demo argument, directory/path processing
		// Echo arguments passed in from running build/libs/Blue4.jar
		// PASSING ARGUMENTS DOES NOT WORK RUNNING WITH GRADLE (needs task manipulation, should not be necessary for deliverable)
		LError.readArguments(args);
		
		// Convert string arguments to object Paths
		// Path[] testData = LError.stringToPath(args);
		
		// Echo working directory
		LError.getCurrentDir();
		
		/// Demo Document identification
		Document doc = new Document();
		File ascii = new File("./src/test/data/asciitest.txt");
		File pdf = new File("./src/test/data/pdftest.pdf");
		File xml = new File("./src/test/data/xmltest.xml");
		File html = new File("./src/test/data/htmltest.html");
/*		try {
			
			System.out.println(doc.identifyDocumentType(ascii));
			System.out.println(doc.identifyDocumentType(pdf));
			System.out.println(doc.identifyDocumentType(xml));
			System.out.println(doc.identifyDocumentType(html));
			
			System.out.println(doc.parseDocument(ascii));
			System.out.println(doc.parseDocument(pdf));
			System.out.println(doc.parseDocument(xml));
			System.out.println(doc.parseDocument(html));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		Vector<String> fullVocab = new Vector<String>();
		Signature pdfsig = new Signature();
		Signature asciisig = new Signature();
		
		//get pdf signature
		String fileContents = doc.parseDocument(pdf);
		Vector<String> fileVector = (doc.WordList(fileContents));
		pdfsig.countWords(fileVector);

		fullVocab = pdfsig.getVocab();
		pdfsig.printSig();
		
		//get ascii signature
		asciisig.setVocab(fullVocab);
		fileContents = doc.parseDocument(ascii);
		fileVector = (doc.WordList(fileContents));
		asciisig.countWords(fileVector);

		fullVocab = asciisig.getVocab();
		asciisig.printSig();
		
		
		
	}
}


