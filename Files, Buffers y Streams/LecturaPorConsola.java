import java.io.*;

public class LecturaPorConsola
{
	public static String leerCadena()
	{
		String cad = "";
		BufferedReader br;
		br = new BufferedReader (new InputStreamReader (System.in));
		
		try
		{
			cad = br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return cad;
	}
	
	public static void main(String args[]) throws IOException
	{
		String cad="";
		System.out.println("Que estoy haciendo????");
		
		while (!cad.equals("andevas"))
		{
			System.out.println(cad);
			cad = leerCadena();
			
		}
		
	}
}
