package tst;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Parser;
import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

class WriteFileTst {
	Parser parser;
	
	@BeforeEach
	public void setup() {
		parser = new Parser();
	}
	

	@Test
	void TestWriteFile1() throws IOException, ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
		parser.readFile("src/static/totalTime.out");
		parser.setOutputFilePath("src/output/out.out");
		parser.setDelimiter(";");
		parser.setSequenceFormat("ROW");
		assertEquals(true, parser.writeFile());	
	}
	
	@Test
	void TestWriteFile2() throws IOException, ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
		parser.readFile("src/static/analysisTime.out");
		parser.setOutputFilePath("src/output/out.out");
		parser.setDelimiter(";");
		parser.setSequenceFormat("ROW");
		assertEquals(true, parser.writeFile());	
	}
	
	@Test
	void TestWriteFile3() throws IOException, ArquivoNaoEncontradoException, DelimitadorInvalidoException, EscritaNaoPermitidaException {
		parser.readFile("src/static/analysisTime.out");
		parser.setOutputFilePath("src/output/out.out");
		parser.setDelimiter("+");
		parser.setSequenceFormat("LINE");
		assertEquals(true, parser.writeFile());	
	}

}
