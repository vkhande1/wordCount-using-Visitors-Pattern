package wordCount.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	private int debugLevel;

	public void setDebug(int level) {
		debugLevel = level;
	}

	public int getDebug() {
		return debugLevel;
	}

	private volatile static Logger uniqueInstance;

	private Logger() {
	}

	public static Logger getInstance() {
		if (uniqueInstance == null) {
			synchronized (Logger.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Logger();
				}
			}
		}
		return uniqueInstance;
	}

	public void printToStdout(int level, String debugMessage) {

		if (level == 0) {

		} else if (debugLevel == level) {
			try {
				File f = new File("Log.txt");
				FileWriter fw = new FileWriter(f, true);
				fw.write(debugMessage + "\r\n");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println(debugMessage);
		} else {

		}
	}
}
