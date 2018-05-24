package edu.odu.cs.cs350;


/*
 * imports shared between identifyDocumentType and parseDocument
 */

import org.apache.tika.Tika;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

/*
 * imports for the parser function
 */

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class Document
{
	
	public String identifyDocumentType(File file) throws IOException, TikaException
	{
		Tika tika = new Tika();
		String mediaType = tika.detect(file);
		if (mediaType.toLowerCase().contains("pdf"))
		{
			return "PDF";
		}
		else if (mediaType.toLowerCase().contains("xml"))
		{
			return "XML";
		}
		else if (mediaType.toLowerCase().contains("html"))
		{
			return "HTML";
		}
		else if (mediaType.toLowerCase().contains("text/plain"))
		{
			return "ASCII";
		}
		else 
		{
			return mediaType;
		}
	}
	
	public String parseDocument(File file)throws IOException, SAXException, TikaException
	{

		Parser autoParser = new AutoDetectParser();
		
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		ParseContext context = new ParseContext();
		
		FileInputStream stream = new FileInputStream(file);
		autoParser.parse(stream, handler, metadata, context);

		
		return handler.toString();

	}
	
public Vector<String> WordList (String Paper){
		
		
		Vector<String> List = new Vector<>();
		
		Scanner scan = new Scanner(Paper);
		
		scan.useDelimiter("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
		
		while(scan.hasNext()){
			
			List.addElement(scan.next());		
		
		}
		
		scan.close();
		return (List);
		
	}
		
	  public Vector<String> CommonWordCut(Vector<String> temp){
		  
		  Vector<String> Holder = new Vector<String>();
  		  
		  try {
			  
			  FileReader inputStream = new FileReader("CommonWords.txt");
			  
			  BufferedReader bufferedReader = new BufferedReader (inputStream);
			  
			  Vector<String> CommonWords = new Vector<String>();
				  
				  Scanner LoadWords = new Scanner(bufferedReader);
				  
				  while(LoadWords.hasNext()){
					  
					  CommonWords.addElement(LoadWords.nextLine());
					  
				  }
				
				  for(int i = 0; i < temp.size(); i++){
					  
				  Holder.add(i, temp.elementAt(i).toLowerCase());
				  
				  };
				  
				 Holder.removeAll(CommonWords);
					  
				  LoadWords.close();
				 
			    
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getClass());
			
			e.printStackTrace();
		}
		  return Holder;
	  }	
}