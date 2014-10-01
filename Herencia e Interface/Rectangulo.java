class Rectangulo implements Cloneable
{

		private int ancho;
		private int alto;
		private String nombre;
		
		Rectangulo(int an, int al, String nom)
		{
			ancho=an;
			this.alto=al;
			nombre = nom;
		}
		
		public int getAncho(){return this.ancho;}
		public int getAlto(){return alto;}
		public String getNombre() { return this.nombre;}

		
		public void setNombre(String nom)
		{
			this.nombre=nom;
		}
		
		public Rectangulo incrementarAncho()
		{
			this.ancho++;
			return this;
		}
		
		public Rectangulo incrementarAlto()
		{
			this.alto++;
			return this;
		}
		
		public Object clone()
		{
			Object objeto= null;
			try
			{
					objeto=super.clone();
			}
			catch(CloneNotSupportedException ex)
			{
				System.out.println("Error a duplicar");
			}
			
			return objeto;
		}
		
		public boolean equals2(Rectangulo entrada)
		{
			if(this.alto == entrada.getAlto() && this.ancho == entrada.getAncho())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
}
