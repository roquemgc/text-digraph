package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ConvertString {

private String receiveTextOfTheTxtExtensionFile;
private String textOfTheTxtExtensionFileInLowCase;
private List<String> textSeparateByWords = new ArrayList<String>();
private List<String> textSeparateByWordsInOrder = new ArrayList<String>();
private List<String> nextWordsOfTheWords = new ArrayList<String>();
private List<String> finalText = new ArrayList<String>();
private List<String> finalOutputTextFormat = new ArrayList<String>();
 
	public ConvertString(String receiveTextOfTheTxt){  
			
		this.receiveTextOfTheTxtExtensionFile = receiveTextOfTheTxt;
	}

	public void RemovePunctuationString(){	
		
		textOfTheTxtExtensionFileInLowCase = receiveTextOfTheTxtExtensionFile.toLowerCase();
		
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "%" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ">" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "<" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "¬" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "." , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "," , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "@" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "#" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "/" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "|" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "!" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "?" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "%" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "$" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "&" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "*" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "(" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ")" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "+" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "=" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "-" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "§" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "_" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ":" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "–" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ";" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "]" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "[" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "}" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "{" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "ª" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "º" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "'" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "\\" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "\"" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "⁃" , "");
		

	}
	
	public void SaveNewTextOftheTxtInTheList(){
		
		String[] textNormalized = textOfTheTxtExtensionFileInLowCase.split("\\s+");
		
		textSeparateByWords = Arrays.asList(textNormalized);
		
	}
	
	public void OrderArraysWithWordsOfTheTextTxt(){
		
		textSeparateByWordsInOrder = new ArrayList<String>(textSeparateByWords);
		
		textSeparateByWordsInOrder = textSeparateByWordsInOrder.stream().distinct().collect(Collectors.toList());
		
		Collections.sort(textSeparateByWordsInOrder);
		
	}
	
	public List<String> GeneratorFinalText() {
	
		int saveIndexOfTheWord = -1;
		
		for(int indexMain = 0; indexMain < textSeparateByWordsInOrder.size(); indexMain++) {
		
			for(int i = 0; i < textSeparateByWords.size(); i++){
					
				int index = 0;
					
				if (textSeparateByWordsInOrder.get(indexMain).equals(textSeparateByWords.get(i))){
						
				    index = i;
				    	
				    index = index + 1;
				    	
				    if (textSeparateByWords.size() > index && !textSeparateByWords.get(index).equals(textSeparateByWordsInOrder.get(indexMain))) {
						
				    	saveIndexOfTheWord = indexMain;
				    	
				    	nextWordsOfTheWords.add(textSeparateByWords.get(index));
				 							
					}
				}				
					
			}
			
			if(saveIndexOfTheWord != -1 && nextWordsOfTheWords.size() != 0 && !nextWordsOfTheWords.isEmpty() && nextWordsOfTheWords != null) {
			
			finalText.add(textSeparateByWordsInOrder.get(saveIndexOfTheWord));
			
			nextWordsOfTheWords = nextWordsOfTheWords.stream().distinct().collect(Collectors.toList());
			
			//Collections.sort(nextWordsOfTheWords);
			
			finalText.addAll(nextWordsOfTheWords);
			
			finalText.add("\n"); 
			
			
			}
				
			nextWordsOfTheWords.clear();
			
		}
			
		int i;
		
		for (i = 0; i < finalText.size(); i++) {
			
			//System.out.printf(finalText.get(i));
			
			finalOutputTextFormat.add(finalText.get(i));
			
			int indexOfTheNextWord = i+1;
			
			if(indexOfTheNextWord < finalText.size()) {
				
				if(finalText.get(indexOfTheNextWord).equals("\n") || (finalText.get(i).equals("\n"))) {
					
					continue;
					
				}else {
					
					//System.out.printf(", ");
					finalOutputTextFormat.add(", ");
					
				}
			}
		}
		
		return finalOutputTextFormat;
		
	}
}



