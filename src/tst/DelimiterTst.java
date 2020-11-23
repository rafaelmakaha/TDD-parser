package tst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.DelimitadorInvalidoException;

class DelimiterTst {

	@Test
	public void TestDelimiterSuccess () throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimiter(";");
		assertEquals(";", parser.getDelimiter());
	}
	
	@Test
	public void TestDelimiterSuccess2 () throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimiter(",");
		assertEquals(",", parser.getDelimiter());
	}
	
	@Test 
	public void TestDelimiterSuccess3 () throws DelimitadorInvalidoException {
		Parser parser = new Parser();
		parser.setDelimiter("g");
		assertEquals("g", parser.getDelimiter());
	}
	
	@Test
	public void TestDelimitadorInvalidoException () {
		Parser parser = new Parser();
		
		assertThrows(DelimitadorInvalidoException.class, () -> {
			parser.setDelimiter("ab");
		});
	}
}
