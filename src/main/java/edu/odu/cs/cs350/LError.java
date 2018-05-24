package edu.odu.cs.cs350;


import java.nio.file.*;

/**
 * Rufor Chen
 * 
 * LError accepts any number of file path arguments from the main class Libary, then 
 * catches and returns error messages for inappropriate arguments for the "classify" function
 **/

public class LError {
	
	// Echos that arguments have been properly read in
	public static void readArguments(String[] args){
		System.out.println("Processing Arguments:");
		if(args.length < 1)
			System.out.println("No arguments detected.");
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
	}
	// Convert list of string arguments to paths
	public static Path[] stringToPath(String[] args){
        Path[] inputPaths = new Path[args.length];
        for(int i=0; i<args.length; i++)
        {
        	inputPaths[i] = Paths.get(args[0]);
        }
        return inputPaths;
        

	}
	// Echo and return working directory
	public static String getCurrentDir(){
		String workDir = System.getProperty("user.dir");
		System.out.println("Working directory is: " + workDir);
		return workDir;
	}

}