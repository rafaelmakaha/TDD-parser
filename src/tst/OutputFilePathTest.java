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
		parser.setOutputFilePath("src/output/output.out");
		assertEquals("src/output/output.out", parser.getOutputFilePath());
	}

}
