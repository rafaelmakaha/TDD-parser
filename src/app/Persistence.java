package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Persistence {
	private OutputStreamWriter writer;
	
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
}
