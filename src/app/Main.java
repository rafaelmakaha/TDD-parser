package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Scanner;

import org.junit.rules.ExpectedException;

import exceptions.ArquivoNaoEncontradoException;
import exceptions.DelimitadorInvalidoException;
import exceptions.EscritaNaoPermitidaException;

public class Main {

	public static void main(String[] args) {
		Parser parser = new Parser();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Input file path: ");
		try {
			parser.readFile(scan.next());
		} catch(Exception err) {
			System.out.println(err);
			System.exit(-1);
		}
		
		System.out.print("Input delimiter: ");
		try {
			parser.setDelimiter(scan.next());
		} catch (Exception err) {
			System.out.println(err);
			System.exit(-1);
		}
		
		System.out.print("Input Sequence Format ROW or COLUMN: ");
		try {
			parser.setSequenceFormat(scan.next());
		} catch (Exception err) {
			System.out.println(err);
			System.exit(-1);
		}

		System.out.print("Output file path: ");
		try {
			parser.setOutputFilePath(scan.next());	
		} catch (Exception err) {
			System.out.println(err);
			System.exit(-1);
		}
		
		try {
			parser.writeFile();
		} catch (Exception err) {
			System.out.println(err);
			System.exit(-1);
		}
		System.out.println("File written successfully!");
	}
}
