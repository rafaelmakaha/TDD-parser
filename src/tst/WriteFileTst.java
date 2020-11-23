package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;

class WriteFileTst {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}
	

	@Test
	void TestWriteFile() throws IOException, ArquivoNaoEncontradoException, DelimitadorInvalidoException {
		parser.readFile("src/static/totalTime.out");
		parser.setDelimiter(";");
		parser.setSequenceFormat("ROW");
		assertEquals(true, parser.writeFile());		
	}

}
