package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Parser;

class OutputFilePathTest {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}

	@Test
	void TestOutputFilePath() {
		parser.setOutputFilePath("src/output/totalTimeTab.out");
		assertEquals("src/output/totalTimeTab.out", parser.getOutputFilePath());
	}
	
	@Test
	void TestOutputFilePath2() {
		parser.setOutputFilePath("src/output/analysisTimeTab.out");
		assertEquals("src/output/analysisTimeTab.out", parser.getOutputFilePath());
	}
	
	@Test
	void TestOutputFilePath3() {
		parser.setOutputFilePath("src/output/anotherOne.out");
		assertEquals("src/output/anotherOne.out", parser.getOutputFilePath());
	}

}
