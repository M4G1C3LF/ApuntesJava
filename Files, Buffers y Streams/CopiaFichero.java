import java.io.*;
import java.util.*;
public class CopiaFichero
{
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
		CopiaFichero ejemplo = new CopiaFichero();
		
		FileInputStream f1=null;
		FileOutputStream f2=null;
		//ZipOutputStream z1=null;
		
	//	System.out.printf("Introduzca un archivo a copiar: ");
		
	//	>String entrada = ejemplo.introducirString();
		
		String entrada = (args[0]);
		
	//	System.out.printf("\nIntroduzca el destino: ");
		
	//	String salida = ejemplo.introducirString();
		String salida = (args[1]);
		char c=0;
		
		try
		{
			f1=new FileInputStream(entrada);
			f2=new FileOutputStream(salida);
			ZipOutputStream z1=new ZipOutputStream(f2);
			int size = f1.available();
			
			for (int i=0; i<size;i++)
			{
				c= (char)f1.read();
				z1.write((byte)c);				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				f1.close();
				f2.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
