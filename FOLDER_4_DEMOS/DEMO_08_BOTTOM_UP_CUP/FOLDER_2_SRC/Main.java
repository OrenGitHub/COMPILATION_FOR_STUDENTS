   
import java.io.*;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import AST.*;

public class Main
{
	static public void main(String argv[])
	{
		Lexer l;
		Parser p;
		Symbol s;
		Integer result;
		FileReader file_reader;
		PrintWriter file_writer;
		String inputFilename = argv[0];
		String outputFilename = argv[1];
		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			file_reader = new FileReader(inputFilename);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			file_writer = new PrintWriter(outputFilename);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(file_reader);
			
			/*******************************/
			/* [4] Initialize a new parser */
			/*******************************/
			p = new Parser(l);

			/***********************************/
			/* [5] 3 ... 2 ... 1 ... Parse !!! */
			/***********************************/
			System.out.print("\n\n\n");
			result = (int) p.parse().value;
			System.out.print("\n\n\nresult is: ");
			System.out.print(result);
			System.out.print("\n\n\n");
			
			/*************************/
			/* [6] Close output file */
			/*************************/
			file_writer.close();
    	}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}


