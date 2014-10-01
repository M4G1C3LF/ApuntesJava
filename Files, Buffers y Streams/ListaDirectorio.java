import java.io.*;
import java.util.*;
public class ListaDirectorio
{
	public void imprimirArrayDeStrings(String[] arrayStrings)
	{
		
		for (String s : arrayStrings)
		{
			System.out.println(s);
		}	
	}
	
	public String introducirString()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(isr);
			String numero = buff.readLine();
			System.out.printf("\n");
			
			return numero;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public static void main(String[] args)
	{
		ListaDirectorio ejemplo = new ListaDirectorio();
		System.out.printf("Introduce el nombre de la carpeta a listar: ");
		try
		{
			File ruta = new File(ejemplo.introducirString());
			if (ruta.isDirectory())
			{
					System.out.println("Es un directorio");
			}
			else
			{
				System.out.println("No es un directorio");
				System.exit(0);
			}
			if (ruta.canWrite())
			{
					System.out.println("Se poseen de Escritura");
			}
			else
			{
				System.out.println("No poseen permisos de Escritura");
			}
			if (ruta.canRead())
			{
					System.out.println("Se poseen de Lectura");
			}
			else
			{
				System.out.println("No poseen permisos de Lectura");
				System.exit(0);
			}
			System.out.println("Listado del directorio\n\n");
			
			ejemplo.imprimirArrayDeStrings(ruta.list());
			
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		
	
	}
}
