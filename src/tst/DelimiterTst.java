package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import app.Parser;
import exceptions.DelimitadorInvalidoException;

class DelimiterTst {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}
	
	@ParameterizedTest
	@ValueSource(strings = {",",
			".",
			"/",
			"\n",
			"\r",
			"\t",
			";",
			"*",
			"-",
			"_",
			"+"
	} )
	public void TestSetDelimiter (String input) throws DelimitadorInvalidoException {
		parser.setDelimiter(input);
		assertEquals(input, parser.getDelimiter());
	}
	
	@Test
	public void TestDelimitadorInvalidoException () {
		assertThrows(DelimitadorInvalidoException.class, () -> {
			parser.setDelimiter("ab");
		});
	}
}
