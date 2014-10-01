public class Rectangulo2 implements Intfigura
{
	private int ancho,largo;
	Rectangulo2(int an, int al)
	{
		this.ancho=an;
		this.largo=al;
	}
	public int area(){return ancho*largo;}
}
