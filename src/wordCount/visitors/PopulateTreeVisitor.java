package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

public class PopulateTreeVisitor implements Visitor {
	FileProcessor f;

	public PopulateTreeVisitor(FileProcessor fp) {
		this.f = fp;
	}

	public void visit(Tree tree) {
		Logger.getInstance().printToStdout(3,
				"PopulateTreeVisitor visit method called");
		String word = f.readfromFile();
		while (word != null) {
			tree.insert(word);
			word = f.readfromFile();

		}

	}

}
