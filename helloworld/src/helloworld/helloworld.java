package helloworld;
import it.myutil.*;
import java.io.*;
import java.util.*;

public class helloworld {
	
	public static void main(String[] args){
		System.out.printf(BelleStringhe.incornicia("Ciao, sto reimparando Java!"));
		
		Scanner reader = new Scanner(System.in);
		PrintStream writer = System.out;
		
		writer.print("A? ");
		int a = reader.nextInt();
		writer.print("B? ");
		int b = reader.nextInt();
		int c = 0;
		reader.close();
		try{
			c = a/b;
		}
		
		catch(ArithmeticException e){
			System.out.printf("a cazzo \n");
		}
		System.out.printf("Risultato: %d", c);
	}	

}
