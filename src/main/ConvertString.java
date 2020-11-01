package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Responsible class for converting strings and eliminating punctuation
 * @author Lucas Alkimim Chaves
 */
public class ConvertString {

	private String receiveTextOfTheTxtExtensionFile;
	private String textOfTheTxtExtensionFileInLowCase;
	private List<String> textSeparateByWords = new ArrayList<String>();
	private List<String> textSeparateByWordsInOrder = new ArrayList<String>();
	private List<String> nextWordsOfTheWords = new ArrayList<String>();
	private List<String> finalText = new ArrayList<String>();
/**
 * @author Lucas Alkimim Chaves
 * Catch the text from TXT
 * @param receiveTextOfTheTxt
 */
	public ConvertString(String receiveTextOfTheTxt) {

		this.receiveTextOfTheTxtExtensionFile = receiveTextOfTheTxt;
		
	}
/**
 * @author Lucas Alkimim Chaves
 */
	public void RemovePunctuationString() {

		textOfTheTxtExtensionFileInLowCase = receiveTextOfTheTxtExtensionFile.toLowerCase();

		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("%", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(">", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("<", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("¬", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(".", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(",", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("@", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("#", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("/", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("|", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("!", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("?", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("%", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("$", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("&", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("*", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("(", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(")", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("+", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("=", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("-", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("§", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("_", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(":", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("–", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace(";", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("]", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("[", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("}", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("{", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("ª", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("º", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("'", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("\\", "");
		textOfTheTxtExtensionFileInLowCase = textOfTheTxtExtensionFileInLowCase.replace("\"", "");
	}
/**
 * Catch normalized text and change it to string
 * @author Lucas Alkimim Chaves
 */
	public void SaveNewTextOftheTxtInTheList() {

		String[] textNormalized = textOfTheTxtExtensionFileInLowCase.split("\\s+");
		
		textSeparateByWords = Arrays.asList(textNormalized);

	}
/**
 * Generates separate ordered text and removes repeated words
 * @author Lucas Alkimim Chaves
 */
	public void OrderArraysWithWordsOfTheTextTxt() {

		textSeparateByWordsInOrder = new ArrayList<String>(textSeparateByWords);

		textSeparateByWordsInOrder = textSeparateByWordsInOrder.stream().distinct().collect(Collectors.toList());

		Collections.sort(textSeparateByWordsInOrder);

	}
/**
 * Generates final text
 * @author Lucas Alkimim Chaves
 * @return FormatFinalTextAndConvertToString
 */
	public String GenerateFinalText() {

		int saveIndexOfTheWord = -1;

		for (int indexMain = 0; indexMain < textSeparateByWordsInOrder.size(); indexMain++) {
			
			for (int i = 0; i < textSeparateByWords.size(); i++) {
				
				int indexNextWord = 0;

				if (textSeparateByWordsInOrder.get(indexMain).equals(textSeparateByWords.get(i))) {

					indexNextWord = i;
					indexNextWord = indexNextWord + 1;

					if (textSeparateByWords.size() > indexNextWord && !textSeparateByWords.get(indexNextWord).equals(textSeparateByWordsInOrder.get(indexMain))) {

						saveIndexOfTheWord = indexMain;

						nextWordsOfTheWords.add(textSeparateByWords.get(indexNextWord));

					}
				}
			}

			if (saveIndexOfTheWord != -1 && nextWordsOfTheWords.size() != 0 && !nextWordsOfTheWords.isEmpty() && nextWordsOfTheWords != null) {

				finalText.add(textSeparateByWordsInOrder.get(saveIndexOfTheWord));
				nextWordsOfTheWords = nextWordsOfTheWords.stream().distinct().collect(Collectors.toList());

				// Collections.sort(nextWordsOfTheWords);

				finalText.addAll(nextWordsOfTheWords);
				finalText.add("\n");

			}
			
			nextWordsOfTheWords.clear();
			
		}

		return FormatFinalTextAndConvertToString();
		
	}
/**
 * Take the final text, format it and convert it to a string
 * @author Lucas Alkimim Chaves
 * @return finalTextFormattedForOutput
 */
	public String FormatFinalTextAndConvertToString() {

		StringBuffer finalTextFormattedForOutput = new StringBuffer();
		int nextWordIndex;

		for (int i = 0; i < finalText.size(); i++) {
			
			finalTextFormattedForOutput.append(finalText.get(i));

			nextWordIndex = i + 1;

			if (nextWordIndex < finalText.size()) {

				if (!(finalText.get(nextWordIndex).equals("\n") || (finalText.get(i).equals("\n")))) {
					finalTextFormattedForOutput.append(", ");

				}
			}

		}

		return finalTextFormattedForOutput.toString();
	}
}
