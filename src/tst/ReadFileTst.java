package tst;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import tddParser.Parser;

public class ReadFileTst {	
	
	@Test
	public void TestReadFileSuccess() {
		Parser parser = new Parser();
		parser.readFile("");
		assertEquals(1337, parser.getFile(), 0);
	}

}
