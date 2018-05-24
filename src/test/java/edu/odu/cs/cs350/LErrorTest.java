package edu.odu.cs.cs350;
/**
 * 
 */


import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import edu.odu.cs.cs350.LError;



/**
 * @author RC
 *
 */
public class LErrorTest {

	// Echos that arguments have been properly read in
	@Test
	public void testReadArguments(){
		// simulate arguments being passed in
		String[] args = new String[3];
		String[] emptyArgs = new String[0];
		
		// test function
		LError.readArguments(args);
		LError.readArguments(emptyArgs);
	}
	// Convert list of string arguments to paths
	@Test
	public void testStringToPath(){
        // initialize strings/paths for comparison
		String[] args = new String[2];
		args[0] = "src/main/";
		args[1] = "src/";
		Path[] pth;
        
		// test function
		pth = LError.stringToPath(args);

		// assert results
		assertTrue(pth.length == 2);
		assertTrue(pth[1] instanceof Path);
		assertTrue(pth[1].toString() == args[1]);
	}
	// Echo and return working directory
	@Test
	public void testGetCurrentDir(){
		// initialize comparison
		String workDir = System.getProperty("user.dir");
		
		// test function
		String test = LError.getCurrentDir();
		
		// assert results
		assertTrue(test == workDir);
	}
}
