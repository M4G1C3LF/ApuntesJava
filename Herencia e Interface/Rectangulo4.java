class Rectangulo4
{
	private int ancho;
	private int alto;
	
	Rectangulo4(){alto=0; ancho=0;}
	Rectangulo4(int an, int al)
		{
			ancho=an;
			this.alto=al;
		}
	Rectangulo4(Rectangulo4 molde)
	{
		this.ancho = molde.getAncho();
		this.alto = molde.getAlto();
	}
	public int getAncho(){return this.ancho;}
	public int getAlto(){return alto;}
}
