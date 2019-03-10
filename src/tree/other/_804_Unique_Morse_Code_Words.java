package tree.other;

import java.util.TreeSet;

/**
 * @program: algorithmset
 * @description:
 * @author: Daffupman
 * @create: 2019-03-09 20:17
 **/
public class _804_Unique_Morse_Code_Words {

	public int uniqueMorseRepresentations(String[] words) {
		//借助set存储的元素是不可重复的特性

		String[] codeTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		TreeSet<String> set = new TreeSet<>();

		for (String word : words) {
			StringBuilder res = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				res.append(codeTable[word.charAt(i)-'a']);
			}
			set.add(res.toString());
		}
		return set.size();
	}

	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};

		System.out.println((new _804_Unique_Morse_Code_Words()).uniqueMorseRepresentations(words));
	}

}
