package utils;

import java.io.IOException;

public class JACOCORunner {

	private static void executeCucumberTests() {
		String command = "java -javaagent:C:\\Users\\rajes\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.10\\org.jacoco.agent-0.8.10.jar -jar your-test-jar.jar";

		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void generateJaCoCoReport() {
		String command = "mvn clean verify";

		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();

			// Open the generated report in a web browser (example for Unix-like systems)
			Runtime.getRuntime().exec("xdg-open target/site/jacoco/index.html");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
