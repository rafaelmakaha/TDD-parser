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
	
	public Parser() {
		this.vls = new Vector<Vector<Integer>>();
	}
	public void readFile (String fileName) throws ArquivoNaoEncontradoException {
		setInputFilePath(fileName);
		Scanner reader = openFile(this.inputFilePath);
		
		
		while (reader.hasNextLine()) {
			String value = reader.nextLine();
			if (value.startsWith("-")) {
				this.vls.add(new Vector<Integer>());
			} else {
				this.vls.lastElement().add(Integer.parseInt(value));
			}
		}
		reader.close();
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
	
	public boolean writeFile () throws EscritaNaoPermitidaException  {
		try {
			String outFile = null;
			if (getInputFilePath().contains("analysis"))
				outFile = "analysisTimeTab.out";
			if (getInputFilePath().contains("total"))
				outFile = "analysisTimeTab.out";
			FileOutputStream file = new FileOutputStream(getOutputFilePath()+outFile);
			
			OutputStreamWriter writer =
					new OutputStreamWriter(file, StandardCharsets.UTF_8);
			
			Vector<Vector<Integer>> values = getFile();
			
			if (getSequenceFormat() == "ROW") {				
				for(int i=0; i < values.size(); i++) {
					Vector<Integer> aux = values.elementAt(i);
					writer.write(Integer.toString(i+1));
					writer.write(getDelimiter());
					for (int j=0; j < aux.size(); j++) {
						writer.write(Integer.toString(aux.elementAt(j)));
						writer.write(getDelimiter());
					}
					writer.write("\n");
				}
			} else {
				Vector<Integer> sizes = new Vector<Integer>();
				for(int i=0; i < values.size(); i++) {
					sizes.add(values.elementAt(i).size());
					writer.write(Integer.toString(i+1));
					writer.write(";");
				}
				writer.write("\n");
				for(int i=0; i < Collections.max(sizes); i++) {
					int j = 0;
					while(j < values.size()) {
						Vector<Integer> aux = values.elementAt(j);							
						try {
							writer.write(Integer.toString(aux.elementAt(i)));
						} catch (Exception e) {
							writer.write("");
						}
						writer.write(";");
						j++;
					}
					writer.write("\n");
				}
			}
			writer.close();
			return true;
		} catch (Exception err) {
			throw new EscritaNaoPermitidaException();
		}
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
