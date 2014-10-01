public class Pez implements Cloneable
{
	protected String nombre, color;
	static int nPeces = 0;
	
	Pez(){nombre="Julián Muñoz"; color="Lila"; nPeces++;}
	Pez(String nom, String col){nombre=nom;color=col; nPeces++;}
	Pez(Pez molde){nombre=molde.getNombre(); color=molde.getColor(); nPeces++;}
	
	public int getNumPeces(){return nPeces++;}
	public String getNombre(){return nombre;}
	public String getColor(){return color;}
	public void setNombre(String nom){nombre=nom;}
	public void setColor(String col){color=col;}
	
	public boolean equals(Pez entrada)
	{
		if(this.nombre == entrada.getNombre() && this.color == entrada.getColor())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Object clone()
		{
			Object objeto=null;
			try
			{
					objeto=super.clone();
					nPeces++;
			}
			catch(CloneNotSupportedException ex)
			{
				System.out.println("Error a duplicar");
			}
			
			return objeto;
		}
}
