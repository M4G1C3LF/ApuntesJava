import java.io.*;
import java.util.*;
class Palindromo
{
	public String introducirString()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(isr);
			String cadena = buff.readLine();
			
			return cadena;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public boolean palindromo(String palabra)
	{
		int i=0;
		int j=palabra.length()-1;
		boolean palin = true;
		palabra = palabra.toUpperCase(); //Para que no se tenga en consideración mayúsculas y minúsculas
		
		char[] aux = palabra.toCharArray();
		
		while (aux[i] == aux[j] && i<j)	{i++; j--;}
		if (aux[i] != aux[j]){palin=false;}
		
		return palin;
	}
	public static void main(String[] args)
	{
		Palindromo ejemplo = new Palindromo();
		System.out.printf("Palabra a comprobar: ");
		String palabra = ejemplo.introducirString();
		if(ejemplo.palindromo(palabra))
		{
			System.out.println(palabra+" es un palindromo");
		}
		else
		{
			System.out.println(palabra+" no es un palindromo");
		}
		
		
		
	}
	
}
