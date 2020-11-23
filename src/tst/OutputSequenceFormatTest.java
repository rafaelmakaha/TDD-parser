package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Parser;

class OutputSequenceFormatTest {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}
	@Test
	void TestOutputSequenceFormatLINE() {
		parser.setSequenceFormat("LINE");
		assertEquals("LINE", parser.getSequenceFormat());
	}

}
