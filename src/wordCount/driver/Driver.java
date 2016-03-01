package wordCount.driver;

import wordCount.treesForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

public class Driver {

	public static void main(String[] args) {
		if (args.length > 1) {
			int Num_it = Integer.parseUnsignedInt(args[2]);
			Logger.getInstance().setDebug(Integer.parseUnsignedInt(args[2]));
			long startTime = System.currentTimeMillis();
			for (int i = 1; i <= 3; i++) {
				FileProcessor fp = new FileProcessor();
				fp.openInputFile(args[0]);
				fp.openOutputFile(args[1]);
				Visitor v1 = new PopulateTreeVisitor(fp);
				Visitor v2 = new WordCountVisitor(fp);
				Tree t = new Tree();
				t.accept(v1);
				t.accept(v2);
			}
			long finishTime = System.currentTimeMillis();
			double Total_time = (finishTime - startTime) / Num_it;
			System.out.println(Total_time);

		} else {
			System.out
					.println("Invalid arguments: Please enter the correct input and output file name");
			System.exit(1);
		}

	}

}
