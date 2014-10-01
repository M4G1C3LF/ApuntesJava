public class Factorial
{
	
	private int num, aux, cont;
	
	Factorial()
	{
		num=5; aux=num; cont=num;
		
		while (cont > 0)
		{
			num*=cont;
			cont--;
		}
		System.out.println("El factorial de "+aux+" es "+ num);
	}
	
	public static void main(String[] args)
	{
		Factorial ejemplo = new Factorial();
		
	}
}
