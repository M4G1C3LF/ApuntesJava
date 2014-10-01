class Ejercicio2
{
	/*
	 * 		   *
	 * 		  ***
	 * 		 *****	
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	 int x,y;
	Ejercicio2()
	{
		for (y=0;y<=2;y++)
		{
			for (x=1;x<=5;x++)
			{
				if(x+y>=3 && x-y <=3){System.out.printf("*");}
				else{System.out.printf(" ");}
			}
			System.out.printf("\n");
		}
	}
	
	public static void main(String[] args)
	{
		Ejercicio2 ejemplo = new Ejercicio2();
	}
	
}
