public class Alumno {

	public String nombre;
	public int edad;
	public double nota;
	/*
	 * CONSTRUCTORES
	 */
	Alumno()
	{
		this.nombre = null;
		this.edad = 0;
		this.nota = -1; //Sin nota
	}
	Alumno(String tNombre, Integer tEdad)
	{
		this.nombre = tNombre;
		this.edad = tEdad;
		this.nota = -1; //Sin nota
	}
	Alumno(String tNombre, Integer tEdad, Double tNota)
	{
		this.nombre = tNombre;
		this.edad = tEdad;
		this.nota = tNota;
	}
	
	/*
	 * TOSTRING, GETTERS Y SETTERS
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public String toString(){
		if(this.nota!=-1)return this.nombre+"("+this.edad+") Nota: "+this.nota;
		return this.nombre+"("+this.edad+")";
	}

	/*
	 * MÉTODOS
	 */
	
	public boolean esIgual(Alumno entrada)
	{
		if (entrada == null)
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