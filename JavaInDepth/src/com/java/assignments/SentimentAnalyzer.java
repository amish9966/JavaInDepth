package com.java.assignments;
import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
			String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output
 
        // your code ~ you will be invoking getOpinionOnFeature	
		review=review.toLowerCase();
		int op=0;
		outerloop: for (int i = 0; i < featureSet.length; i++) {
						for(int j=0;j<featureSet[i].length;j++) {
							op=getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);
							if(op>0 || op<0) {
								featureOpinions[i]=op;
								continue outerloop;
							}
						}
		}
 
		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and 
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		
		// your code
		int op=checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
		if(op==0) {
			op=checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
		}
		return op;
		
	}	

	// Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;
		String pattern = feature + " was ";

		// your code
		for (int i = 0; i < posOpinionWords.length; i++) {
			if (review.contains(pattern + posOpinionWords[i])) {
				return 1;
			}
		}
		for (int j = 0; j < negOpinionWords.length; j++) {
			if (review.contains(pattern + negOpinionWords[j])) {
				return -1;
			}
		}
		return opinion; 	
	}
	
	// You can first look for positive opinion. If not found, only then you can look for negative opinion
	private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
			String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times. 
		// split() takes a regular expression and "." is a special character 
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;
		
		// your code for processing each sentence. You can return if opinion is found in a sentence (no need to process subsequent ones)	
		for (int p = 0; p < sentences.length; p++) {
			for (int i = 0; i < posOpinionWords.length; i++) {
				if (sentences[p].contains(posOpinionWords[i]+" "+feature)) {
					return 1;
				}
			}
		}
		for (int p = 0; p < sentences.length; p++) {
			for (int j = 0; j < negOpinionWords.length; j++) {
				if (sentences[p].contains(negOpinionWords[j]+" "+feature)) {
					return -1;
				}
			}
		}
		return opinion;
	}

	public static void main(String[] args) {
		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
		
		//String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";
		
		String[][] featureSet = { 
		        { "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" }, 
				{ "food" }, 
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
				"delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
	}
}
