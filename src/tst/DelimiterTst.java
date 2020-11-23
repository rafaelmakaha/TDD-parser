package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.DelimitadorInvalidoException;

class DelimiterTst {

	@Test
	void TestDelimiterSuccess() throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		assertEquals(";", parser.getDelimiter());
	}

}
