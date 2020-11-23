package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.DelimitadorInvalidoException;

class DelimiterTst {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}

	@Test
	public void TestDelimiterSuccess () throws DelimitadorInvalidoException {
		parser.setDelimiter(";");
		assertEquals(";", parser.getDelimiter());
	}
	
	@Test
	public void TestDelimiterSuccess2 () throws DelimitadorInvalidoException {
		parser.setDelimiter(",");
		assertEquals(",", parser.getDelimiter());
	}
	
	@Test 
	public void TestDelimiterSuccess3 () throws DelimitadorInvalidoException {
		parser.setDelimiter("g");
		assertEquals("g", parser.getDelimiter());
	}
	
	@Test
	public void TestDelimitadorInvalidoException () {
		assertThrows(DelimitadorInvalidoException.class, () -> {
			parser.setDelimiter("ab");
		});
	}
}
