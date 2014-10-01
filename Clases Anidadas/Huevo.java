public class Huevo
{		
	Huevo(){System.out.println("Soy un huevo");}


	public class Yema
	{
		Yema(){System.out.println("Soy una yema");}
	}
	
	public class Clara
	{
		Clara(){System.out.println("Soy una clara");}
	}
	
	public Yema hazYema()
	{
		return new Yema();
	}
	
	public Clara hazClara()
	{
		return new Clara();
	}
	
	public static void main(String[] args)
	{
		Huevo h1 = new Huevo();
		
		Clara clarita = h1.hazClara();
		Yema yemita = h1.hazYema();
	
	 
	}
}
