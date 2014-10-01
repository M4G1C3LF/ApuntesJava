public class Profesor {

	private Proyecto[] listaProyectos;
	private String nombre;
	/*
	 * CONCSTRUCTORES
	 */
	public Profesor(String nombre)
	{
		this.nombre = nombre;
		this.listaProyectos = new Proyecto[]{null};
	}
	public Profesor(Proyecto[] lProyectos, String nombre)
	{
		if (lProyectos == null)
		{
			this.listaProyectos = new Proyecto[]{null};
		}
		else
		{
			this.listaProyectos = lProyectos;
		}
		this.nombre = nombre;
	}
	
	/*
	 * TOSTRING GETTERS Y SETTERS
	 */
	
	public String toString()
	{
		String str=new String();
		
		if (this.listaProyectos[0] != null)
		{
			for(Proyecto l: this.listaProyectos)
			{
				str += "---"+l.toString();
			}
		}
		return nombre+"[[["+str+"]]]";
	}
	public Proyecto[] getListaProyectos() {
		return listaProyectos;
	}
	public void setListaProyectos(Proyecto[] p)
	{
		this.listaProyectos = p;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/*
	 *  MÉTODOS
	 */
	
	public int getNumProyectos()
	{
		return this.listaProyectos.length;
	}
	public boolean tieneProyecto(String proyecto)
	{
		for(Proyecto l: this.listaProyectos)
		{
			if (l.getDescripcion() == proyecto)
			{
				return true;
			}
		}
		return false;
	}
	public boolean tieneAlumno(String nombreAlumno)
	{
		for(Proyecto l: this.listaProyectos)
		{
			for(Alumno a: l.getAlumnos())
			{
				if (a.getNombre() == nombreAlumno)
				{
					return true;
				}
			}
		}
		return false;
	}
	public void agregarProyecto(Proyecto p)	//He tenido problemas a la hora de redimensionar el array.
	{
		Proyecto[] aux = this.listaProyectos;
		Proyecto[] aux2 = new Proyecto[1];
		if (this.listaProyectos[0] != null)
		{
			aux2 = new Proyecto[aux.length+1];
			for (int i=0;i<aux.length;i++)
			{
				System.out.println(aux[i]);
				aux2[i] = aux[i];
			}
			aux2[aux2.length-1] = p;
		}	
		else
		{
			
			aux2[0] = p;
		}
		this.listaProyectos = aux2;
	}
	public double notaMediaDeAlumnos()
	{
		int i=0;
		double suma = 0;
		for(Proyecto l: this.listaProyectos)
		{
			for(Alumno a: l.getAlumnos())
			{
				suma+=a.getNota();
				i++;
			}
		}
		
		return suma/i;	
	}
	public boolean esIgual(Profesor entrada)
	{

		if (entrada.getNombre() == null)
		{
			return false;
		}
		if(this.getNombre().matches(entrada.getNombre()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
