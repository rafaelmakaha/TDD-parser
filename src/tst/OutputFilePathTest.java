package tst;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import app.Parser;
import exceptions.EscritaNaoPermitidaException;

class OutputFilePathTest {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
			"src/output/totalTimeTab.out",
			"src/output/analysisTimeTab.out"
	})	
	void TestOutputFilePath(String input) throws EscritaNaoPermitidaException {
		parser.setOutputFilePath(input);
		assertEquals(input, parser.getOutputFilePath());
	}
	
	@Test
	void TestOutputFilePathException() {
		assertThrows(EscritaNaoPermitidaException.class, () -> {
			parser.setOutputFilePath("notAnActualPath/");
		});
	}

}
