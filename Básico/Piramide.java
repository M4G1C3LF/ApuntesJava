class Piramide
{

	Piramide(){}
	public int calcular(int fila, int columna)
	{
		if (columna==1 ){return 1;}
		if (columna < 1 || columna > fila){return 0;} 
	
		
		return calcular(fila-1,columna)+calcular(fila-1,columna-1);
		
	}
	
	public void dibujar(int filas)
	{
		int aux,y=0,x=0,cuentaespacios;
		for (y=0;y<filas;y++)
		{
			for (cuentaespacios=filas-x;cuentaespacios>0;cuentaespacios--)
				{
					System.out.printf(" ");
				}
			for(x=0;x<=y;x++)
			{
				aux =calcular(y,x); 
				if ( aux != 0)
				{
					System.out.printf(Integer.toString(aux)+" ");
				}
				else
				{
					System.out.printf(" ");
				}
				
			}
		
			System.out.printf("\n");
		}
	}
	
	
	public static void main(String[] args)
	{
		Piramide ejemplo = new Piramide();
		
		ejemplo.dibujar(6);
	}
}