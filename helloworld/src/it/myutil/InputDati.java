package it.myutil;

import java.util.*;

public class InputDati 
{
	  private static Scanner lettore = creaScanner();
	  
	  private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	  private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
	  private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
	  private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
	  private final static String MESSAGGIO_AMMISSIBILI= "Attenzione: i caratteri ammissibili sono: ";
	  private final static String MSG_COD_FISCALE = "Inserisca il CODICE FISCALE: ";
	  private final static String MSG_TELEFONO = "Inserisca il suo numero di telefono: ";
	  private final static char RISPOSTA_SI='S';
	  private final static char RISPOSTA_NO='N';

	  
 
	  private static Scanner creaScanner ()
	  {
	   Scanner creato = new Scanner(System.in);
	   creato.useDelimiter(System.getProperty("line.separator"));
	   return creato;
	  }
	  
	  public static String leggiStringa (String messaggio)
	  {
		  System.out.print(messaggio);
		  return lettore.next();
	  }
	  
	  public static String leggiStringaNonVuota(String messaggio)
	  {
	   boolean finito=false;
	   String lettura = null;
	   do
	   {
		 lettura = leggiStringa(messaggio);
		 lettura = lettura.trim();
		 if (lettura.length() > 0)
		  finito=true;
		 else
		  System.out.println(ERRORE_STRINGA_VUOTA);
	   } while (!finito);
	   
	   return lettura;
	  }
	  
	  public static String leggiNumeroTelefono(){
		  boolean wrong = false;
		  String telefono = null;
		  
		  try{
			  do{
				  wrong = false;
				  telefono = leggiStringaNonVuota(MSG_TELEFONO);
				  if(telefono.length() != 10){
					  System.out.println(ERRORE_FORMATO);
					  wrong = true;
				  }
				  for(int i = 0; i < telefono.length(); i++){
					  if(telefono.charAt(i) < '0' || telefono.charAt(i) > '9') wrong = true;
				  }
				  
			  }while(wrong);
		  }
		  catch(IndexOutOfBoundsException e){
			  System.out.println(ERRORE_FORMATO);
			  wrong = true;
		  }
		  
		  return telefono;
	  }
	  
	  public static String leggiAlbo(String MSG){
		  boolean wrong = false;
		  String albo = null;
		  
			  do{
				  try{
					  wrong = false;
					  albo = leggiStringaNonVuota(MSG);
					  albo = albo.toUpperCase();
					  String lettere = albo.substring(0, 2);
					  String numeri = albo.substring(3);
					  
					  for(int i = 0; i < lettere.length(); i++){
						  if(lettere.charAt(i) < 'A' || lettere.charAt(i) > 'Z') wrong = true;
					  }
					  
					  for(int i = 0; i < numeri.length(); i++){
						  if(numeri.charAt(i) < '0' || numeri.charAt(i) > '9') wrong = true;
					  }
				  }
				  catch(IndexOutOfBoundsException e){
					  System.out.println(ERRORE_FORMATO);
				  }

			  }while(wrong);
		  		  
		  return albo;
	  }
	  
	  public static String leggiCodiceFiscale(){
		  boolean wrong = false;
		  String codice = null;
		  
		  do{
			  try{
				  wrong = false;
				  codice = leggiStringaNonVuota(MSG_COD_FISCALE);
				  codice = codice.toUpperCase();
				  String lettere = codice.substring(0, 5) + codice.charAt(8) + codice.charAt(11) + codice.charAt(15);
				  String numeri = codice.substring(6, 7) + codice.substring(9, 10) + codice.substring(12, 14);
				  
				  if(codice.length() != 16) wrong = true; 
				  for(int i = 0; i < lettere.length(); i++){
					  if(lettere.charAt(i) < 'A' || lettere.charAt(i) > 'Z') wrong = true;
				  }
				  
				  for(int i = 0; i < numeri.length(); i++){
					  if(numeri.charAt(i) < '0' || numeri.charAt(i) > '9') wrong = true;
				  }
				  if(wrong) System.out.println(ERRORE_FORMATO);
			  }
			  
			  catch(IndexOutOfBoundsException e){
				  System.out.println(ERRORE_FORMATO);
				  wrong = true;
			  } 
			  
		  }while(wrong);
		  
		  
		  
		  return codice;
	  }
	  
	  public static char leggiChar (String messaggio)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	    {
	     System.out.print(messaggio);
	     String lettura = lettore.next();
	     if (lettura.length() > 0)
	      {
	       valoreLetto = lettura.charAt(0);
	       finito = true;
	      }
	     else
	      {
	       System.out.println(ERRORE_STRINGA_VUOTA);
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	  
	  public static char leggiUpperChar (String messaggio, String ammissibili)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	   {
	    valoreLetto = leggiChar(messaggio);
	    valoreLetto = Character.toUpperCase(valoreLetto);
	    if (ammissibili.indexOf(valoreLetto) != -1)
		 finito  = true;
	    else
	     System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
	   } while (!finito);
	   return valoreLetto;
	  }
	  
	  
	  public static int leggiIntero (String messaggio)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     try
	      {
	       valoreLetto = lettore.nextInt();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }

	  public static int leggiInteroPositivo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,1);
	  }
	  
	  public static int leggiInteroNonNegativo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,0);
	  }
	  
	  
	  public static int leggiInteroConMinimo(String messaggio, int minimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  public static int leggiIntero(String messaggio, int minimo, int massimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo && valoreLetto<= massimo)
	      finito = true;
	     else
	      if (valoreLetto < minimo)
	         System.out.println(ERRORE_MINIMO + minimo);
	      else
	    	 System.out.println(ERRORE_MASSIMO + massimo); 
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  
	  public static double leggiDouble (String messaggio)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     try
	      {
	       valoreLetto = lettore.nextDouble();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	 
	  public static double leggiDoubleConMinimo (String messaggio, double minimo)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiDouble(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }
	  
	  public static double leggiDouble(String messaggio, double minimo, double massimo){
		  
		   boolean finito = false;
		   double valoreLetto = 0;
		   do
		    {
		     valoreLetto = leggiIntero(messaggio);
		     if (valoreLetto >= minimo && valoreLetto<= massimo)
		      finito = true;
		     else
		      if (valoreLetto < minimo)
		         System.out.println(ERRORE_MINIMO + minimo);
		      else
		    	 System.out.println(ERRORE_MASSIMO + massimo); 
		    } while (!finito);
		     
		   return valoreLetto;
		  
	  }
	  
	  public static boolean yesOrNo(String messaggio)
	  {
		  String mioMessaggio = messaggio + "("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		  char valoreLetto = leggiUpperChar(mioMessaggio,String.valueOf(RISPOSTA_SI)+String.valueOf(RISPOSTA_NO));
		  
		  if (valoreLetto == RISPOSTA_SI)
			return true;
		  else
			return false;
	  }

}

