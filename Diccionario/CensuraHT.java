import java.io.*;
import java.util.*;
class CensuraHT
{
	public Hashtable dic;
	public Enumeration k,e;
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
	public void crearDiccionario()
	{
		StringTokenizer str;
		String scen;

		this.dic = new Hashtable();
		
		File censura = new File("censura.txt");
		try
		{
			FileReader censuraReader = new FileReader(censura);
			BufferedReader censuraBuffer = new BufferedReader(censuraReader);

			while((scen = censuraBuffer.readLine()) != null)
			{
				str = new StringTokenizer(scen);
				dic.put(str.nextToken(),str.nextToken());
				
			}
			censuraReader.close();
			this.k = dic.keys();
			this.e = dic.elements();
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
	public static void main(String[] args)
	{
		CensuraHT ejemplo = new CensuraHT();
		
		String s1,s2,token,scen;
		StringTokenizer str;
		
		ejemplo.crearDiccionario(); 
		System.out.printf("Introduce un nombre de fichero: ");
		File fi= new File(ejemplo.introducirString());
		
		try
		{
			FileReader fr = new FileReader(fi);
			BufferedReader br = new BufferedReader(fr);
			while((scen.hasMoreTokens() != null))
			{
				str = new StringTokenizer(scen);

				while(str.hasMoreTokens())
				{
					token =str.nextToken();
					System.out.println(token);
					if (ejemplo.dic.containsKey(token))
					{
						s1=s1.replace(token,(String)ejemplo.dic.get(token));
					}
				}
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
