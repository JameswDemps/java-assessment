package com.qa.javaAssessment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import com.sun.tools.javac.util.List;

public class Assessment{
	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""
	public boolean isBert(String input, int startingPoint) {
		if (input.substring(startingPoint, startingPoint+4).toLowerCase().equals("bert")) {
			return true;
		}
		else {
			return false;
		}
	}; 
	
	public String reverseWord(String input) {
		String word = "";
		for (int i = input.length(); i > 0; i--) {
			word += input.substring(i-1, i);
		}
		return word;
	}

	public String getBert(String input) {
		String word = "";
		boolean firstBert = false;
		boolean secondBert = false;
		//boolean firstBertReached = false;
		for (int i = 0; i < input.length()-3; i++){
    		char c = input.charAt(i);
    		if (firstBert == false) {
    			if (isBert(input, i)) {
    				firstBert = true;
    				i += 4;
    			}
    		}
    		else if(secondBert == false) {
    			if (isBert(input, i)) {
    				secondBert = true;
    				i += 3;
    			}
    		}

    		if (firstBert && !secondBert) {
    			word += input.substring(i, i+1);
    		}
		}

		if (!secondBert) {
			return "";
		}
		else {
			return reverseWord(word);
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		List<Integer> numbers = new ArrayList<Integer>(3);
		numbers.add(a);
		numbers.add(b);
		numbers.add(c);
		Collections.sort(numbers);
		if (numbers.get(2) - numbers.get(1) == numbers.get(1) - numbers.get(0)) {
			return true;
		}
		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		String word = "";
		int startRemoving = (input.length() - a)/2;
		for (int i = 0; i < input.length(); i++) {
			if (i < startRemoving || i >= input.length() - startRemoving) {
				word += input.substring(i, i+1);
			}
		}
		return word;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int maxBlock = 0;
		int currentBlock = 1;
		int length = input.length();
		//System.out.println(input);
		if (length > 0) {
			for (int i = 1; i < length; i++) {
				if (input.substring(i, i+1).equals(input.substring(i-1, i))) {
					currentBlock++;
				}
				else {
					maxBlock = currentBlock;
					currentBlock = 1;
				}
			}
		}
		else {
			currentBlock = 0;
		}
		
		if (currentBlock > maxBlock) {
			maxBlock = currentBlock;
		}
		//System.out.println(maxBlock);
		return maxBlock;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int amCount = 0;
		String[] wordList = arg1.split(" ");
		List<String> wordArray = Arrays.asList(wordList);
		for (String item : wordArray) {
			if (item.toLowerCase().equals("am")) {
				amCount++;
			}
		}
		return amCount;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String word = "";
		if (arg1 % 3 == 0 ) {
			word += "fizz";
		}
		if (arg1 % 5 == 0) {
			word += "buzz";
		}
		return word;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		String[] wordList = arg1.split(" ");
		List<String> wordArray = Arrays.asList(wordList);
		List<Integer> intArray = new ArrayList<Integer>(wordArray.size());
		int currentSum;
		
		for (String item : wordArray) {
			currentSum = 0;
			for (int i = 0; i < item.length(); i++) {
				currentSum += Integer.parseInt(item.substring(i, i+1));
			}
			intArray.add(currentSum);
		}
		System.out.println(intArray);
		return Collections.max(intArray);
	}
}
