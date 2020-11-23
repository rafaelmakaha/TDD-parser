package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import java.util.Scanner;

import exceptions.ArquivoNaoEncontradoException;

public class Parser {
	private Vector<Vector<Integer>> vls;
	private String delimiter;
	
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
	
	public void setDelimiter (String delimiter) {
		this.delimiter = delimiter;
	}
	
	public Vector<Vector<Integer>> getFile () {
		return this.vls;
	}
	
}
