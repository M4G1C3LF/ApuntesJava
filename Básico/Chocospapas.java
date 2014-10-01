public class Chocospapas
{
	int patatas;
	int choc;
	
////////////////////////////////////	CONSTRUCTORES
	Chocospapas()
	{
		String line;
		
		
		try
		{
			System.out.printf("Introduce los kg. de patatas: ");
			line = System.console().readLine();
			patatas=Integer.parseInt(line);
		
			System.out.printf("Introduce los kg. de chocos: ");
			line = System.console().readLine();
			choc=Integer.parseInt(line);
			
			System.out.println("Con "+patatas+" Kg de patatas y "+choc+" de Chocos salen "+cundeTapa()+" platos");
		}
		catch(NumberFormatException cagada)
		{
			errorEntrada();
			return;
		}
			
		
	}
	Chocospapas(int patatas, int choc){}
	
//////////////////////////////////		MÉTODOS
	
//	int cundeTapa(double papas, double chocos)
	public int cundeTapa()
	{
		
		
		int personas=0;
		double racionPapas=1*(1/3.0);
		double racionChocos=0.5*(1/3.0);
		
		while (patatas > racionPapas && choc > racionChocos)
		{
				patatas-=racionPapas;
				choc-=racionChocos;
				personas++;
				
		}
		
		return personas;
	}
	
	public void errorEntrada()
	{
		System.out.printf("Únicamente se permiten enteros");
		return;
	}
	
	public static void main (String[] args)
	{
		Chocospapas ejemplo = new Chocospapas();
				
	}
}
