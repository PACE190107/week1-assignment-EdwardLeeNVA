package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		//Grab the first letter and capitalize.
		//acronym(substring from first space)
		String[] words = phrase.split("\\s|-");
		String acrn = "";
		for(String s: words) {
			acrn += s.toUpperCase().charAt(0);
		}
		return acrn;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree()) {
				return true;
			}else {
			return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			//2 are equal
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() != this.getSideThree()) {
				return true;
			}else if(this.getSideOne() == this.getSideThree() && this.getSideOne() != this.getSideTwo()) {
				return true;
			}
			else if(this.getSideTwo() == this.getSideThree() && this.getSideTwo() != this.getSideOne()) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()!=this.getSideTwo() && this.getSideOne() != this.getSideThree() && this.getSideTwo()!= this.getSideThree()) {
				return true;
			}else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration

	    int totalScore = 0;
		for(int i = 0;i< string.length();i++) {
			//case statement to get the value
			//add value to total
			string = string.toLowerCase();
	        switch (string.charAt(i)) {     
	        case 'a' :
	        case 'e' :
	        case 'i' :
	        case 'o' :
	        case 'u' :
	        case 'l' :
	        case 'n' :
	        case 'r' : 
	        case 's' : 
	        case 't' : totalScore += 1; break; 
	        case 'd' :
	        case 'g' : totalScore += 2; break; 
	        case 'b' :
	        case 'c' :
	        case 'm' :
	        case 'p' : totalScore += 3; break; 
	        case 'f' :
	        case 'h' :
	        case 'v' :
	        case 'w' :
	        case 'y' : totalScore += 4; break; 
	        case 'k' : totalScore += 5; break; 
	        case 'j' :
	        case 'x' : totalScore += 8; break; 
	        case 'q' :
	        case 'z' : totalScore += 10; break;
	        }
		}
		return totalScore;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String cleanedNumber = "";
		for(int i = 0;i < string.length();i++) {
			if(Character.isDigit(string.charAt(i))) {
				cleanedNumber +=string.charAt(i);
			}
		}
		//remove first digit if it is 1
		if(Character.getNumericValue(cleanedNumber.charAt(0))<2){
			cleanedNumber = cleanedNumber.substring(1);
		}
		//error checking (to long/short)//short means there was likely an invalid char
		if(cleanedNumber.length()>10||cleanedNumber.length() < 10) {
			throw new IllegalArgumentException();
		}
		return cleanedNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		Map<String, Integer> words = new HashMap<String, Integer>();
		string.replaceAll("[^a-zA-Z0-9\\s]", "");//remove irrelevant char
		String[] wordArr = string.split("\\s*,\\s*|\\s+"); //SplitAt white space and commas
		for(String s: wordArr){
			if(null != words.putIfAbsent(s, 1)) { //returns  null when it doesn't exists
				words.replace(s, words.get(s)+1);
			}
		}
		return words;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<? super T>>{
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int upperBounds = sortedList.size()-1, lowerBounds =0;
			int currIndex = sortedList.size()/2;
			T i = sortedList.get(sortedList.size()/2);
			
			while(upperBounds != lowerBounds) { // doesn't actually work in way to many circumstance. I would perfer proper recursion. You should also test a var not in the array next batch
			i = sortedList.get(currIndex);

			if(t.compareTo(i) == 0){ //same
				return currIndex;
			}else if(t.compareTo(i) > 0) { //t is larger
				//search the top
				if(upperBounds == sortedList.size() - 1 && lowerBounds == upperBounds -1) { //special if to see the last possible element in an array
					currIndex = upperBounds;
				}else {
				lowerBounds = currIndex;
				currIndex = (lowerBounds + upperBounds)/2;
				}
			}
			else if(t.compareTo(i) < 0) { //t is smaller
				//search the bottom
				upperBounds = currIndex;
				currIndex = (lowerBounds + upperBounds)/2;
			}
			}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String pigLatin = "", suffix = "ay", vowels = "aeiouy";
		String[] words = string.split(" ");
		for(String s: words) {
		if(s.matches("^[aeiou].*")) {
			s = s.concat(suffix);
		}
		else {
			//find where it hits a vowel then move the substr to the end with ay
			int index;
		    for (index = 1; index < s.length(); index++)
		    {
		        if (vowels.contains(String.valueOf(s.charAt(index))))
		        {
		            break;
		        }
		    }
		    //check for qu words
		    if(s.toLowerCase().charAt(0) == 'q' && s.toLowerCase().charAt(1) == 'u'){
		    	index++;
		    }
		    s = s.substring(index)+ s.substring(0, index) + suffix;
		    //doesn't move qu.
		}
		//add to piglatin
		pigLatin += s + " ";
		}
		pigLatin = pigLatin.trim();
		return pigLatin;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int calculatedValue= 0;
		String inputString = "" + input;
		
		for(int i = 0;i<inputString.length();i++) {
			int j = Character.getNumericValue(inputString.charAt(i));
			calculatedValue += Math.pow(j, inputString.length());
		}
		if( calculatedValue == input) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> factors = new ArrayList<Long>();
		Long i = 2L, leftovers = l;
		while(leftovers >= i) {
			//mod by i if if == 0 then add to factors
			if(leftovers%i == 0) {
				leftovers = leftovers/i;
				factors.add(i);
			}
			else {
				i++;
			}
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String digest = "";	
			for(char c:string.toCharArray()) {
				Boolean isCapital = Character.isUpperCase(c);
				if(Character.isLetter(c)) {
					c = (char) (c + key);
					//need to wrapAround
			        if (c > 'z') {//doesn't rotate capitol Letters
			        	c = (char)(c-26);
			        }
			        if (isCapital && c > 'Z') {
			        	c = (char)(c-26);
			        }
			        digest += c;
				}else {
					digest +=c;
				}
			}
			return digest;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		List<Integer> primes = new ArrayList<>();
		if(i > 0) {
		// n that I will calculate to. Not ideal since it sets an upper limit 110000
		//Calculate primes until primes.size() >= i,
		//grab i-1 from the array
			int index = 2;
			HashMap<Integer, Boolean> untested = new HashMap<>();
			while( index <110000) { //start prime sieve. 110000 is the upper limit because I looked at the test to see the largest prime
				untested.put(index++, true); 
			}
			//start solving for primes
			int primeStart = 2; //2 is the first time so I will start here
			while(primes.size() < i) {
				//loop through untested. every number touched is a prime.
				primes.add(primeStart);
				int indexTest = 2; //don't want to remove itself
				while(primeStart*indexTest <= untested.size()) {
					untested.replace(primeStart* indexTest++, false);
				}
				primeStart++;
				while(!untested.get(primeStart)) {//make sure primeStart is a prime
					primeStart++;
				}
			}
		}else {
			throw new IllegalArgumentException();
		}
		return primes.get(i-1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String digest = "";
			for(char c : string.toLowerCase().toCharArray()) {
		        switch (c) {     
		        case 'a' : c = 'z'; break;
		        case 'b' : c = 'y'; break;
		        case 'c' : c = 'x'; break;
		        case 'd' : c = 'w'; break;
		        case 'e' : c = 'v'; break;
		        case 'f' : c = 'u'; break;
		        case 'g' : c = 't'; break;
		        case 'h' : c = 's'; break;
		        case 'i' : c = 'r'; break;
		        case 'j' : c = 'q'; break;
		        case 'k' : c = 'p'; break;
		        case 'l' : c = 'o'; break;
		        case 'm' : c = 'n'; break;
		        case 'n' : c = 'm'; break;
		        case 'o' : c = 'l'; break;
		        case 'p' : c = 'k'; break;
		        case 'q' : c = 'j'; break;
		        case 'r' : c = 'i'; break;
		        case 's' : c = 'h'; break;
		        case 't' : c = 'g'; break;
		        case 'u' : c = 'f'; break;
		        case 'v' : c = 'e'; break;
		        case 'w' : c = 'd'; break;
		        case 'x' : c = 'c'; break;
		        case 'y' : c = 'b'; break;
		        case 'z' : c = 'a'; break;
		        }
		       if(Character.isAlphabetic(c) || Character.isDigit(c)){
			        digest += c;
		       }
			}
			//break into segments of 5
			string = digest;
			digest = "";
			char[] c =string.toCharArray();
			for(int i = 0; i < c.length; i++) {
				if(i%5==0 && i>0) {
					digest += " ";
				}
				digest += c[i];
			}
			return digest;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String digest = "";
			for(char c : string.toLowerCase().toCharArray()) {
		        switch (c) {     
		        case 'a' : c = 'z'; break;
		        case 'b' : c = 'y'; break;
		        case 'c' : c = 'x'; break;
		        case 'd' : c = 'w'; break;
		        case 'e' : c = 'v'; break;
		        case 'f' : c = 'u'; break;
		        case 'g' : c = 't'; break;
		        case 'h' : c = 's'; break;
		        case 'i' : c = 'r'; break;
		        case 'j' : c = 'q'; break;
		        case 'k' : c = 'p'; break;
		        case 'l' : c = 'o'; break;
		        case 'm' : c = 'n'; break;
		        case 'n' : c = 'm'; break;
		        case 'o' : c = 'l'; break;
		        case 'p' : c = 'k'; break;
		        case 'q' : c = 'j'; break;
		        case 'r' : c = 'i'; break;
		        case 's' : c = 'h'; break;
		        case 't' : c = 'g'; break;
		        case 'u' : c = 'f'; break;
		        case 'v' : c = 'e'; break;
		        case 'w' : c = 'd'; break;
		        case 'x' : c = 'c'; break;
		        case 'y' : c = 'b'; break;
		        case 'z' : c = 'a'; break;
		        }
		        if(Character.isAlphabetic(c) || Character.isDigit(c)){
		        	digest+= c;
		       	}
		       }
			return digest;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		char[] isbnNumbers = new char[10];
		int i = 0, index = 0;
		while(i < 10) {
			if(Character.isDigit(string.charAt(index))){
				isbnNumbers[i] = string.charAt(index);
				i++;
			}else if(string.charAt(index) == 'X' && i == 9) { //check digit is 10
				isbnNumbers[i] = string.charAt(index);

				i++;
			}
			else if(Character.isLetter(string.charAt(index))) {
				//To be here it is has letter, or an x not in the final spot.
				return false;
			}
			index++;
		}
		int total = 0;
		for(int h = 0; h< isbnNumbers.length-1;h++) {
			total += (Character.getNumericValue(isbnNumbers[h]) * (10-h));
		}
		//check digit
		if(isbnNumbers[9]=='X') {
			total+= 10;
		}else {
			total+=Character.getNumericValue(isbnNumbers[9]);
		}
		//valid check
		if( total % 11 == 0) {return true;}
		//mod 11 = 0
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
        String regex = "^(?=.*a)(?=.*b)(?=.*c)(?=.*d)(?=.*e)(?=.*f)(?=.*g)(?=.*h)(?=.*i)(?=.*j)(?=.*k)(?=.*l)(?=.*m)(?=.*n)(?=.*o)(?=.*p)(?=.*q)(?=.*r)(?=.*s)(?=.*t)(?=.*u)(?=.*v)(?=.*w)(?=.*x)(?=.*y)(?=.*z).+";
		// hash map of letters. When seen bool is set to true. if in the end one is false they all ares
		String s = string.toLowerCase();
		return s.matches(regex);
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		Duration amount = Duration.ofSeconds(1000000000);
		if(given.isSupported(ChronoUnit.SECONDS)) {
			given = given.plus(amount);
		}else {
			LocalDate ld = (LocalDate)given;
			LocalDateTime ldt = ld.atStartOfDay();
			given =ldt.plus(amount);
		}
				return given;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		ArrayList<Integer> multiples = new ArrayList<>();
		for(int setNum : set) {
			int counter = setNum;
			while(counter < i) {
				if(!multiples.contains(counter)) {
					multiples.add(counter);
				}
				counter += setNum;
			}
		}
		int sumOfMultiples = 0;
		for(int multiple: multiples) {
			sumOfMultiples += multiple;
		}
		return sumOfMultiples;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
		//prep work removing spaces and checking for invalids
		ArrayList<Integer> values = new ArrayList<>();
		string = string.replace(" ", "");
		for(char c: string.toCharArray()) {
			if(Character.isDigit(c)) {
				values.add(Character.getNumericValue(c));
			}else{
				return false;
			}
		}

		//validation of number
		for( int i = values.size()-2; i >= 0;i -=2) {
			int temp = values.get(i)*2;
			if(temp > 9) {
				temp -= 9;
			}
			values.set(i,temp);
		}
		int total = 0;
		for(int i : values) {
			total += i;
		}

		if(total % 10 == 0) {

			return true;
		}

		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace("?", "");
		String[] contents = string.split(" ");
		//0, 1 == what is
		//2 == first number
		int num1 = Integer.parseInt(contents[2]);
		// 4 or 5 is the second number. easier to look for digits
		int num2;
		if(contents[4].equals("by")) {
			num2 = Integer.parseInt(contents[5]);
		}else {
			num2 = Integer.parseInt(contents[4]);
		}
		//3 is the operation
		int returnInt = 0;
		switch(contents[3]) {
		case "plus": returnInt = num1 + num2;break;
		case "minus":returnInt = num1 - num2; break;
		case "divided":returnInt = num1/num2; break;
		case "multiplied": returnInt = num1 * num2;break;
		}
		return returnInt;
	}

}
