package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import java.util.Scanner;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

public class Parser {
	private Vector<Vector<Integer>> vls;
	private String delimiter;
	private String sequenceFormat;
	private String outputFilePath;
	
	public Parser() {
		this.vls = new Vector<Vector<Integer>>();
	}
	public void readFile (String fileName) throws ArquivoNaoEncontradoException {
		Scanner reader;
		try {
			reader = new Scanner(new FileReader(fileName));
		}catch (FileNotFoundException err) {
			throw new ArquivoNaoEncontradoException(fileName);
		}
		
		while (reader.hasNextLine()) {
			String value = reader.nextLine();
			if (value.startsWith("-")) {
				this.vls.add(new Vector<Integer>());
			} else {
				vls.lastElement().add(Integer.parseInt(value));
			}
		}
		reader.close();
	}
	
	public String getDelimiter () {
		return this.delimiter;
	}
	
	public void setDelimiter (String delimiter) throws DelimitadorInvalidoException {
		if (delimiter.length() == 1)
			this.delimiter = delimiter;
		else
			throw new DelimitadorInvalidoException(delimiter);
	}
	
	public Vector<Vector<Integer>> getFile () {
		return this.vls;
	}
	
	public void setSequenceFormat(String sequenceFormat) {
		this.sequenceFormat = sequenceFormat;
	}
	
	public String getSequenceFormat() {
		return this.sequenceFormat;
	}
	
	public String getOutputFilePath() {
		return this.outputFilePath;
	}
	
	public void setOutputFilePath(String outputFilePath) throws EscritaNaoPermitidaException {
		if (outputFilePath.contains("src/output/")) {
			this.outputFilePath = outputFilePath;			
		} else {
			throw new EscritaNaoPermitidaException();
		}
	}
	
}
