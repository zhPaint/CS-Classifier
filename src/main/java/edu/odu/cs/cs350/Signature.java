package edu.odu.cs.cs350;

import java.util.Vector;
import java.math.*;

public class Signature {

	private Vector<Integer> sig = new Vector<Integer>();
	private Vector<String> vocab = new Vector<String>();
	
	public void countWords(Vector<String> doc)
	{
		sig.clear();
		sig.setSize(vocab.size());
		
		for(int x = 0; x < sig.size(); x++)
		{
			sig.set(x, 0);
		}
		
		boolean wordFound = false;
		int vocabSize;
		int oldVocabSize = vocab.size();
		int wordIndex = -1;
		int wordCount = 0;
		
		System.out.println("System vocabulary before document: " + oldVocabSize);
		
		for(int x = 0; x < doc.size(); x++)
		{
			wordFound = vocab.contains(doc.get(x));
			if(wordFound)
			{
				wordIndex = vocab.indexOf(doc.get(x));
				wordCount = sig.get(wordIndex);
				sig.set(wordIndex, wordCount + 1);
			}
			else
			{
				vocab.add(doc.get(x));
				sig.add(1);
				System.out.println("Added " + doc.get(x) + " to System Vocabulary.");
				
			}
			wordFound = false;
		}
		
		vocabSize = sig.size();
		System.out.println("System vocabulary after document: " + vocabSize);
		System.out.println("Words added to system vocabulary: " + (vocabSize - oldVocabSize));
		
	}
	
	
	public Vector<Integer> getSignature()
	{
		return sig;
	}
	
	public void setSignature(Vector<Integer> newSig)
	{
		sig = newSig;
	}
	
	public Vector<String> getVocab()
	{
		return vocab;
	}
	
	public void setVocab(Vector<String> newVocab)
	{
		vocab = newVocab;
	}
	
	public void printSig()
	{
		for(int x = 0; x < sig.size(); x++)
		{
			System.out.print(" |" + vocab.get(x) + " - " + sig.get(x));
		}
	}
	
	public double WeightWord(int documentFrequency, int totalNumDocuments)
	{
		double weight = 0.0;
		double temp = (double)(totalNumDocuments/documentFrequency);
		weight = (Math.log10(temp)/Math.log10(2.0));
		return weight;
	}
	
	public void NormalizeSig()
	{
		for(int i = 0; i < sig.size(); i++){
			if (sig.elementAt(i) >= 5){
				sig.setElementAt(i, 1);
			}
			else{
				sig.set(i, 0);
			}
		}
	}
}
