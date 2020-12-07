package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

public class Parser {
	public Vector<Vector<Integer>> vls;
	private String delimiter;
	private String sequenceFormat;
	private String outputFilePath;
	private String inputFilePath;
	public Persistence persistence;
	
	public Parser() {
		this.vls = new Vector<Vector<Integer>>();
		this.persistence = new Persistence();
	}
	public void readFile (String fileName) throws ArquivoNaoEncontradoException {
		setInputFilePath(fileName);
		persistence.startReader(openFile(this.inputFilePath));
		
		while (persistence.hasNextLine()) {
			String value = persistence.nextLine();
			if (value.startsWith("-")) {
				this.vls.add(new Vector<Integer>());
			} else {
				this.vls.lastElement().add(Integer.parseInt(value));
			}
		}
		persistence.closeReader();
	}
	
	public Scanner openFile (String fileName) throws ArquivoNaoEncontradoException {
		Scanner reader;
		try {
			reader = new Scanner(new FileReader(fileName));
		}catch (FileNotFoundException err) {
			throw new ArquivoNaoEncontradoException(fileName);
		}
		return reader;
	}
	
	public FileOutputStream openOutputFile () throws FileNotFoundException {
		String outFile = null;
		if (getInputFilePath().contains("analysis"))
			outFile = "analysisTimeTab.out";
		if (getInputFilePath().contains("total"))
			outFile = "analysisTimeTab.out";
		return new FileOutputStream(getOutputFilePath()+outFile);
	}
	
	public boolean writeFile () throws EscritaNaoPermitidaException  {
		new WriteFile(this).write();
		return true;
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
		if (outputFilePath.endsWith("/")){
			this.outputFilePath = outputFilePath;			
		} else {
			throw new EscritaNaoPermitidaException();
		}
	}
	
	public void setInputFilePath(String input) {
		this.inputFilePath = input;
	}
	
	public String getInputFilePath() {
		return this.inputFilePath;
	}
	
}
