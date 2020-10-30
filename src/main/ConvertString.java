package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ConvertString {

private String receiveTextOfTheTxtExtensionFile;
private String textOfTheTxtExtensionFileInLowCase;
private List<String> textSeparate = new ArrayList<String>();
private List<String> textSeparateInOrder = new ArrayList<String>();
private List<String> nextWordsOfTheWords = new ArrayList<String>();
private List<String> finalText = new ArrayList<String>();
 
	public ConvertString(String recebeTextoDoTxt){  
			
		this.receiveTextOfTheTxtExtensionFile = recebeTextoDoTxt;
	}

	public void RemovePontuationsString(){	
		
		textOfTheTxtExtensionFileInLowCase = receiveTextOfTheTxtExtensionFile.toLowerCase();
		
		//textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replaceAll("�.,@#/|!?%$&*()+=-�_�;][}{��'\\" , "");
		
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ">" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "<" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "�" , "");
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
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "�" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "_" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "�" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( ";" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "]" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "[" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "}" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "{" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "�" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "�" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "'" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "\\" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "\"" , "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace( "\\n" , "");

	}
	
	public void saveNewTextOftheTxtInTheList(){
		
		String[] textNormalized = textOfTheTxtExtensionFileInLowCase.split("\\s");
		
		textSeparate = Arrays.asList(textNormalized);
		
	}
	
	public void OrderArraysWithWordsOfTheTextTxt(){
		
		textSeparateInOrder = new ArrayList<String>(textSeparate);
		
		textSeparateInOrder = textSeparateInOrder.stream().distinct().collect(Collectors.toList());
		
		Collections.sort(textSeparateInOrder);
		
	}
	
	public void GeneratorFinalText() {
	
		int saveIndexOfTheWord = -1;
		
		for(int indexMain = 0; indexMain < textSeparateInOrder.size(); indexMain++) {
		
			for(int i = 0; i < textSeparate.size(); i++){
					
				int index = 0;
					
				if (textSeparateInOrder.get(indexMain).equals(textSeparate.get(i))){
						
				    index = i;
				    	
				    index = index + 1;
				    	
				    if (textSeparate.size() > index && !textSeparate.get(index).equals(textSeparateInOrder.get(indexMain))) {
						
				    	saveIndexOfTheWord = indexMain;
				    	
				    	nextWordsOfTheWords.add(textSeparate.get(index));
				 							
					}
				}				
					
			}
			
			if(saveIndexOfTheWord != -1 && nextWordsOfTheWords.size() != 0 && !nextWordsOfTheWords.isEmpty() && nextWordsOfTheWords != null) {
			
			finalText.add(textSeparateInOrder.get(saveIndexOfTheWord));
			
			nextWordsOfTheWords = nextWordsOfTheWords.stream().distinct().collect(Collectors.toList());
			
			Collections.sort(nextWordsOfTheWords);
			
			finalText.addAll(nextWordsOfTheWords);
			
			finalText.add("\n"); 
			
			
			}
				
			nextWordsOfTheWords.clear();
			
		}
			
		int i;
		
		for (i = 0; i < finalText.size(); i++) {
			
			System.out.printf(finalText.get(i));
			
			int indexOfTheNextWord = i+1;
			
			if(indexOfTheNextWord < finalText.size()) {
				
				if(finalText.get(indexOfTheNextWord).equals("\n") || (finalText.get(i).equals("\n"))) {
					
					continue;
					
				}else {
					
					System.out.printf(", ");
					
				}
			}
		}
	}
}



