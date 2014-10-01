class Ejercicio3
{
	//Mostrar los 5 primeros números pares
	int i,n;
	Ejercicio3()
	{
		i=1;
		n=1;
		while(i<=5)
		{
			if (n%2==0)
			{
				System.out.println(n);
				i++;
			}
			n++;
		}
	}
	
	public static void main (String[] args)
	{
		Ejercicio3 ejemplo = new Ejercicio3();
	}
}
