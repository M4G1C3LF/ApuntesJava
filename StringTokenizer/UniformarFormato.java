import java.io.*;
import java.util.*;
class UniformarFormato
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
	public String uniformarPalabra(String palabra)
	{
		String palabraOk,mayus;
		
		Character primera = palabra.charAt(0);
		mayus = primera.toString().toUpperCase();
		palabraOk = mayus + palabra.substring(1).toLowerCase();
		
		
		return palabraOk;
		
	}
	public static void main(String[] args)
	{
		String linea, token, s1 = "";
		StringTokenizer strTok;
		UniformarFormato ejemplo = new UniformarFormato();
		
		System.out.printf("Introduce un fichero de entrada: ");
		String entrada = ejemplo.introducirString();
		System.out.printf("Introduce un fichero de salida: ");
		String salida = ejemplo.introducirString();
		
		File fi= new File(entrada);
		File fo= new File(salida);
		try
		{
			FileReader fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(fo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while ((linea=br.readLine()) != null)
			{
				
				strTok = new StringTokenizer(linea);
				while (strTok.hasMoreTokens())
				{
					token = strTok.nextToken();
					token = ejemplo.uniformarPalabra(token);
					bw.write(token,0,token.length());
					bw.write(" ",0,1);
				}
				bw.newLine();
			}
			bw.close();
			br.close();
			fw.close();
			fr.close();
			
		}
		catch (FileNotFoundException fnf)
		{
			System.err.println("No se encuentra el fichero...");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

}
