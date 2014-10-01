public class Ejercicio 
{
	public static void main(String argv[])
	{
		int a=10;
		int b=5;
		int aux;
		
		System.out.println("Valor de a: "+a+"\nValor de b: "+b+"\n\nCambio de Valor Nº 1!\n");
		
		aux=a;
		a=b;
		b=aux;
		
		System.out.println("Valor de a: "+a+"\nValor de b: "+b+"\n\nCambio de Valor Nº 2!\n");
		
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("Valor de a: "+a+"\nValor de b: "+b+"\n");
		
		int edad = 29;
		int n_estudios = 5;
		int sueldo =27000;
		
		boolean boleana = ((edad>=28 && n_estudios>3)|| (edad>28 && sueldo >28000)); 
		
		System.out.println("Variable boolean: "+boleana);
	}
}
