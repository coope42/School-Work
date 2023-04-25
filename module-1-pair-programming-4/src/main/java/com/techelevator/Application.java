package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//

			TELog.log("Search application started.");



			
			
			// Step Four: Instantiate a Search Domain
			//

			SearchDomain searching = new SearchDomain("C:\\Users\\koope\\Desktop\\meritamerica\\repos\\module-1-pair-programming-4\\data");
			TELog.log(searching.getFiles().toString().replaceAll(", ", "\n"));
			
			// Step Six: Single word search
			SearchEngine newEngine = new SearchEngine(searching);
			newEngine.indexFiles();
//			List<String> foundWords = newEngine.search("larry");
//			if (foundWords == null || foundWords.size() == 0) {
//				System.out.println("No matches were found.");
//			}
//			else {
//				for (String word : foundWords) {
//					System.out.println(word);
//				}
//			}
//
			
			// Step Seven: Multiple word search
			//
			List<String> listFoundWords = newEngine.search("Telephone line");
			if (listFoundWords == null || listFoundWords.size() == 0) {
				System.out.println("No matches found.");
			}
			else {
				for (String multipleWords : listFoundWords) {
					System.out.println(multipleWords);
				}
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
