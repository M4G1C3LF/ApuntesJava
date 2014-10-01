class Hijo extends Padre
{
	private int dato1, dato2;
	Hijo()
	{
		dato1= 3;
		dato2= 3;
	}
	Hijo(int x, int y)
	{
		super(2,2);
		dato1=x;
		dato2=y;
	}
	public void m()
	{
		System.out.println("Método clase hijo");
		super.dato1=10;
		dato1=20;
	}
	public void getDato()
	{
		System.out.println("Padre dato1: "+super.dato1);
		System.out.println("Padre dato2: "+super.dato2);
		System.out.println("Hijo dato1: "+this.dato1);
		System.out.println("Hijo dato2: "+this.dato2);
	}
	public void mostrar()
	{
		this.m();
		m();
		super.m();
	}
}
