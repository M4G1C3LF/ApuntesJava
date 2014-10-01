import java.io.*;
import java.util.*;
class Censura
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
		Censura ejemplo = new Censura();
		
		String s1,s2;
		StringTokenizer str;
		System.out.printf("Introduce un nombre de fichero: ");
		File fi= new File(ejemplo.introducirString());
		try
		{
			FileReader fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			
			while( (s1=br.readLine()) != null)
			{
				File censura = new File("censura.txt");
				FileReader censuraReader = new FileReader(censura);
				BufferedReader censuraBuffer = new BufferedReader(censuraReader);

//				str = new StringTokenizer(s2=censuraBuffer.readLine());		ESTO NO!!!
				String scen;
				while((scen = censuraBuffer.readLine()) != null)
				{
					str = new StringTokenizer(scen);
					s1=s1.replace(str.nextToken(),str.nextToken());
					
				}
				censuraReader.close();
				System.out.println(s1);
				
			}
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
