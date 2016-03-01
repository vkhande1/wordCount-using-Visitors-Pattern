package wordCount.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class FileProcessor {
	static BufferedReader br;
	static FileReader fileReader;
	static PrintStream out;

	public void openInputFile(String input_file) {
		try {
			Logger.getInstance()
					.printToStdout(3, "openInputFile method called");
			File file = new File(input_file);
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println("Message, " + e.getMessage());
			System.exit(1);
		}

	}

	public void openOutputFile(String Output_file) {
		Logger.getInstance().printToStdout(3, "openOutputFile method called");
		try {

			out = new PrintStream(new FileOutputStream(Output_file, true));

		} catch (FileNotFoundException e) {
			System.err.println("Message - " + e.getMessage());
			System.exit(1);
		}
	}

	public String readfromFile() {
		// Logger.getInstance().printToStdout(3, "readfromFile method called");
		String line = null;
		try {
			line = br.readLine();

		} catch (IOException e) {
			System.err.println("Exception while reading from file");
			System.exit(1);
		}
		return line;

	}

	public void writeToFile() {
		System.setOut(out);
	}

}
