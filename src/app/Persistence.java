package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Persistence {
	private OutputStreamWriter writer;
	private Scanner reader;
	
	public Persistence() {
		
	}
	
	public void startWriter(FileOutputStream file) {
		this.writer = new OutputStreamWriter(file, StandardCharsets.UTF_8);
	}
	
	public void writeString(String string) throws IOException {
		this.writer.write(string);
	}
	public void writeNewLine() throws IOException {
		this.writer.write("\n");
	}
	public void closeWriter() throws IOException {
		this.writer.close();
	}
	public void startReader(Scanner inputFileName) {
		this.reader = inputFileName;
	}
	public boolean hasNextLine() {
		return this.reader.hasNextLine();
	}
	public String nextLine() {
		return this.reader.nextLine();
	}
	public void closeReader() {
		this.reader.close();
	}
}
