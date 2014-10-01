class Trycatch
{
	public static void main (String[] args)
	{
			int a=10, b=0,c;
			
			try
			{
				c=a/b;
			
				System.out.println("Resultado: "+c);
			}
			catch(ArithmeticException error)
			{
				System.out.println("División por 0");
			}
	}
}
