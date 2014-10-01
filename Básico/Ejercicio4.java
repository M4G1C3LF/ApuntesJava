class Ejercicio4
{
	int x,y;
	Ejercicio4()
	{
		for (y=0;y<=6;y++)
		{
			for (x=0;x<=6;x++)
			{
				if (y+x==3 || x-y==3 || y-x==3 || x+y==9){System.out.printf("*");}
				else{System.out.printf(" ");}
			}
			System.out.printf("\n");
		}
	
	}
	
	public static void main(String[] args)
	{
		Ejercicio4 ejemplo = new Ejercicio4();
	}
}