package app;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Vector;

import exceptions.EscritaNaoPermitidaException;

public class WriteFile {
	final Parser parser;
	
	public WriteFile (Parser parser) {
		this.parser = parser;
	}
	
	public void write() throws EscritaNaoPermitidaException {
		try {
			FileOutputStream file = parser.openOutputFile();
			
			OutputStreamWriter writer =
					new OutputStreamWriter(file, StandardCharsets.UTF_8);
			
			Vector<Vector<Integer>> values = parser.getFile();
			
			if (parser.getSequenceFormat() == "ROW") {				
				for(int i=0; i < values.size(); i++) {
					Vector<Integer> aux = values.elementAt(i);
					writer.write(Integer.toString(i+1));
					writer.write(parser.getDelimiter());
					for (int j=0; j < aux.size(); j++) {
						writer.write(Integer.toString(aux.elementAt(j)));
						writer.write(parser.getDelimiter());
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
		} catch (Exception err) {
			throw new EscritaNaoPermitidaException();
		}
	}
}
