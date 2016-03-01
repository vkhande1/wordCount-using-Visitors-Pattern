package wordCount.treesForStrings;

import java.util.Map;
import java.util.TreeMap;

import wordCount.util.Logger;
import wordCount.visitors.Visitor;

public class Tree {
	Map<String, Integer> map;

	public Tree() {
		Logger.getInstance().printToStdout(3, "Tree constructor called");
		map = new TreeMap<String, Integer>();
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);

	}

	public void insert(String words) {
		if (map.containsKey(words)) {
			map.put(words, map.get(words) + 1);
		} else {
			map.put(words, 1);

		}

	}

	public void traverse() {
		int char_length = 0;
		int total = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			total = total + entry.getValue();
			// if(entry.getValue() > 1){
			char_length = char_length
					+ (entry.getKey().length() * entry.getValue());
			// } else{
			// char_length = char_length + entry.getKey().length();
			// }

		}

		System.out.println("Total number of nodes: " + total + "  "
				+ "Unique Words: " + map.size() + "  "
				+ "Total number of Characters: " + char_length);

	}

}
