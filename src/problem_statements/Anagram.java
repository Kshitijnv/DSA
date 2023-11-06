package problem_statements;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			HashMap<Character, Integer> anagramMap = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter a choice:\n" + "1.Find Anagram\n" + "2.Exit");
					switch (sc.nextInt()) {
					case 1:
						// Check two strings are anagram or not
						// ex:- eat , ate are ANAGRAM
						// ex:- ant ent are NOT ANAGRAM;
						System.out.println("Enter two words: ");
						String str1 = sc.next().toLowerCase();
						String str2 = sc.next().toLowerCase();
						// Converting the string into an character array
						char[] arr1 = str1.toCharArray();
						char[] arr2 = str2.toCharArray();
						// CONSTRAINT 1 :- for having anagram, length of both array must be equal
						if (arr1.length != arr2.length) {
							System.out.println("Words are not anagram!!!");
							return;
						} else {
							// Choosing hashmap DS because for each character calculate the integer count of
							// character

							for (int i = 0; i < arr1.length; i++) {
								// set the value for newly character in array as 1
								if (anagramMap.get(arr1[i]) == null)
									anagramMap.put(arr1[i], 1);
								// extracting the value for an existing character in the map and set the value
								// ++count
								else {
									Integer count = anagramMap.get(arr1[i]);
									anagramMap.put(arr1[i], ++count);
								}
							}
							for (int i = 0; i < arr2.length; i++) {
								// for any new character get in array 2 that means it is not in old array that
								// means it not anagram
								if (anagramMap.get(arr2[i]) == null) {
									System.out.println("Words are not anagram!!!");
									return;
								}
								// extracting the value for an existing character in the map and set the value
								// --count
								else {
									Integer count = anagramMap.get(arr2[i]);
									anagramMap.put(arr2[i], --count);
								}
							}
							// For anagrams, all characters(key) must have count(value) ZERO
							boolean isAnagram = true;
							for (Character c : anagramMap.keySet()) {
							    if (anagramMap.get(c) != 0) {
							        isAnagram = false;
							        break;
							    }
							}

							if (isAnagram) {
							    System.out.println("Words are anagrams!!!");
							} else {
							    System.out.println("Words are not anagrams!!!");
							}

						}
						break;

					case 2:
						exit = true;
						System.out.println("Exiting");
						break;
					default:
						System.out.println("invalid input");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!");
				}
			}
		}

	}

}
