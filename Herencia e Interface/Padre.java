class Padre
{
	protected int dato1, dato2;
	Padre(){this(5,5);}
	Padre(int x, int y)
	{
		dato1= x;
		dato2= y;
	}
	public void m()
	{
		System.out.println("Método clase Padre");

	}
	
}
