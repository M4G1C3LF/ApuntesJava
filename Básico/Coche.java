class Coche
{
	private int velocidad;
	
	Coche(){velocidad=0;}
	
	int getVelocidad(){return this.velocidad;}
	
	void acelerar(int ace)
	{
		this.velocidad+=ace;
	}
	
	void frenar(int fre)
	{
		this.velocidad-=fre;
	}
	
	public static void main(String[] args)
	{
		Coche ford= new Coche();
		Coche bmw= new Coche();
		
		System.out.println("Velocidad de Ford: "+ford.getVelocidad());
		System.out.println("Velocidad de B.M.W.: "+bmw.getVelocidad());
		
		ford.acelerar(30);
		bmw.acelerar(80);
		
		System.out.println("\nAceleración");
		
		System.out.println("Velocidad de Ford: "+ford.getVelocidad());
		System.out.println("Velocidad de B.M.W.: "+bmw.getVelocidad());
		
		ford.frenar(20);
		bmw.frenar(15);
		
		System.out.println("\nFrenada");
		
		System.out.println("Velocidad de Ford: "+ford.getVelocidad());
		System.out.println("Velocidad de B.M.W.: "+bmw.getVelocidad());
		
	}
}
