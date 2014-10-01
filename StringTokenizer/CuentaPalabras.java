import java.io.*;
import java.util.*;
class CuentaPalabras
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
		CuentaPalabras ejemplo = new CuentaPalabras();
		int palabras = 0;
		String s;
		StringTokenizer str;
		System.out.printf("Introduce un nombre de fichero: ");
		File fi= new File(ejemplo.introducirString());
		try
		{
			FileReader fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			
			while( (s=br.readLine()) != null)
			{
				str = new StringTokenizer(s);
				while (str.hasMoreTokens())
				{
					palabras++;
					str.nextToken();
				}
				
				
			}
			System.out.println("El archivo tiene "+palabras+" palabras");
			fr.close();
		}
		
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
}
