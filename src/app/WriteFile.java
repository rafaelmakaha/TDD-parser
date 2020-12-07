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
			
			parser.persistence.startWriter(file);
			
			Vector<Vector<Integer>> values = parser.getFile();
			
			if (parser.getSequenceFormat() == "ROW") {				
				for(int i=0; i < values.size(); i++) {
					Vector<Integer> aux = values.elementAt(i);
					parser.persistence.writeString(Integer.toString(i+1));
					parser.persistence.writeString(parser.getDelimiter());
					for (int j=0; j < aux.size(); j++) {
						parser.persistence.writeString(Integer.toString(aux.elementAt(j)));
						parser.persistence.writeString(parser.getDelimiter());
					}
					parser.persistence.writeNewLine();
				}
			} else {
				Vector<Integer> sizes = new Vector<Integer>();
				for(int i=0; i < values.size(); i++) {
					sizes.add(values.elementAt(i).size());
					parser.persistence.writeString(Integer.toString(i+1));
					parser.persistence.writeString(parser.getDelimiter());
				}
				parser.persistence.writeNewLine();
				for(int i=0; i < Collections.max(sizes); i++) {
					int j = 0;
					while(j < values.size()) {
						Vector<Integer> aux = values.elementAt(j);							
						try {
							parser.persistence.writeString(Integer.toString(aux.elementAt(i)));
						} catch (Exception e) {
							parser.persistence.writeString("");
						}
						parser.persistence.writeString(parser.getDelimiter());
						j++;
					}
					parser.persistence.writeNewLine();
				}
			}
			parser.persistence.closeWriter();
		} catch (Exception err) {
			throw new EscritaNaoPermitidaException();
		}
	}
}
