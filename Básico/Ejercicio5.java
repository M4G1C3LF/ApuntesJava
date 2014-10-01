class Ejercicio5
{
	int numero;
	int[] formado = new int[20]; //No me deja crear el array dentro de la función "numeroVampiro(int)"
	
	Ejercicio5()
	{
		numero = 2187;
	}
	
	void numeroVampiro()
	{
		int i = 0;
		int numCompr = numero;

		while (numCompr > 0)
		{
			formado[i]= numCompr%10;
			System.out.printf("Número: "+numero+"\t NumComp: "+numCompr+"\t Formado: "+formado[i]+"\n");
			numCompr/=10;
			i++;
		}
		
		for(int num: formado){System.out.printf(formado[num]+" ");}
	}


	public static void main(String[] args)
	{
		Ejercicio5 ejemplo = new Ejercicio5();
		
		ejemplo.numeroVampiro();
	}
}