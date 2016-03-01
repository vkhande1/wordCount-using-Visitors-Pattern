package wordCount.visitors;

import wordCount.treesForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

public class WordCountVisitor implements Visitor {

	FileProcessor f;

	public WordCountVisitor(FileProcessor fp) {
		this.f = fp;
	}

	public void visit(Tree tree) {
		Logger.getInstance().printToStdout(3,
				"WordCountVisitor visit method called");
		f.writeToFile();
		tree.traverse();

	}

}
