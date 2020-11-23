package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.DelimitadorInvalidoException;

class DelimiterTst {

	@Test
	void TestDelimiterSuccess () throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimiter(";");
		assertEquals(";", parser.getDelimiter());
	}
	
	@Test
	void TestDelimiterSuccess2 () throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimiter(",");
		assertEquals(",", parser.getDelimiter());
	}
}
