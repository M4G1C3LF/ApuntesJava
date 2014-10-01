import java.util.Calendar;

public class Proyecto {
	
	private String descripcion;
	private Alumno[] alumnos;
	private Calendar fechaEntrega;
	private String estadoProyecto;
	private static Calendar fechaLimite = Calendar.getInstance();
	public String hayAlumno; //He tenido que acabar poniendo este atributo porque no he sido capaz de buscar "null" en db4o
	private String strFecha;	//He tenido que guardar la fecha aqui con un string porque a la segunda vez que intetntaba acceder me saltaba un "NullPointerException"
	/*
	 * CONSTUCTORES!
	 */
	Proyecto()
	{
		this.descripcion = null;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		
		this.fechaEntrega = null;
		this.estadoProyecto = null;
		this.hayAlumno = "no";
		this.strFecha = null;
	}
	Proyecto(String descripcion){
		this.descripcion = descripcion;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		
		this.fechaEntrega = null;
		this.strFecha = null;
		this.estadoProyecto = null;
		this.hayAlumno = "no";
	}
	Proyecto(Alumno[] alumnos)
	{
		this.descripcion = null;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		else
		{
			this.alumnos = alumnos;
		}
		this.fechaEntrega = null;
		this.strFecha = null;
		this.estadoProyecto = null;
		if (alumnos != null)
		{
			this.hayAlumno = "si";
		}
		else
		{
			this.hayAlumno = "no";
		}
	}
	Proyecto(String descripcion,Alumno[] alumnos)
	{
		this.descripcion = descripcion;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		else
		{
			this.alumnos = alumnos;
		}
		this.fechaEntrega = null;
		this.strFecha = null;
		this.estadoProyecto = null;
		if (alumnos != null)
		{
			this.hayAlumno = "si";
		}
		else
		{
			this.hayAlumno = "no";
		}
	}
	Proyecto(String descripcion,Alumno[] alumnos,Calendar fechaEntrega)
	{
		this.descripcion = descripcion;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		else
		{
			this.alumnos = alumnos;
		}
		this.fechaEntrega = fechaEntrega;
		if (this.fechaEntrega != null)
		{
			this.strFecha = " ("+this.getFechaEntrega().get(Calendar.DATE)+"/"+(this.getFechaEntrega().get(Calendar.MONTH)+1)+"/"+this.getFechaEntrega().get(Calendar.YEAR)+")";
		}
		else
		{
			this.strFecha = null;
		}
		this.estadoProyecto = null;
		if (alumnos != null)
		{
			this.hayAlumno = "si";
		}
		else
		{
			this.hayAlumno = "no";
		}
	}
	Proyecto(String descripcion,Alumno[] alumnos,Calendar fechaEntrega,String estadoProyecto)
	{
		this.descripcion = descripcion;
		if (alumnos == null)
		{
			this.alumnos = new Alumno[]{null};
		}
		else
		{
			this.alumnos = alumnos;
		}
		
		this.fechaEntrega = fechaEntrega;
		if (this.fechaEntrega != null)
		{
			this.strFecha = " ("+this.getFechaEntrega().get(Calendar.DATE)+"/"+(this.getFechaEntrega().get(Calendar.MONTH)+1)+"/"+this.getFechaEntrega().get(Calendar.YEAR)+")";
		}
		else
		{
			this.strFecha = null;
		}
		this.estadoProyecto = estadoProyecto;
		if (alumnos[0] != null)
		{
			this.hayAlumno = "si";
		}
		else
		{
			this.hayAlumno = "no";
		}
	}
	
	/*
	 * TOSTRING GETTERS Y SETTERS
	 */
	public static Calendar getFechaLimite() {
		return fechaLimite;
	}
	public static void setFechaLimite(Calendar fechaLimite) {
		Proyecto.fechaLimite = fechaLimite;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
		if (alumnos != null)
		{
			this.hayAlumno = "si";
		}
		else
		{
			this.hayAlumno = "no";
		}
	}
	public String toString(){
		
		String str = this.descripcion+"->";
		System.out.println(alumnos.length);
		if (alumnos[0] != null)
		{
			for (Alumno a: this.alumnos)
			{
				str += "|"+a.getNombre()+"|";
			}
		}
		if (fechaEntrega != null)
		{
			str += this.strFecha;
		}
		if (estadoProyecto != null)
		{
			str += " Estado: "+this.getEstadoProyecto();
		}
		
		return str;
	}
	public Calendar getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Calendar fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		if (this.fechaEntrega != null)
		{
			this.strFecha = " ("+this.getFechaEntrega().get(Calendar.DATE)+"/"+(this.getFechaEntrega().get(Calendar.MONTH)+1)+"/"+this.getFechaEntrega().get(Calendar.YEAR)+")";
		}
	}
	public String getEstadoProyecto() {
		return estadoProyecto;
	}
	public String getHayAlumno() {
		return hayAlumno;
	}
	public void setHayAlumno(String hayAlumno) {
		this.hayAlumno = hayAlumno;
	}
	public String getStrFecha() {
		return strFecha;
	}
	public void setStrFecha(String strFecha) {
		this.strFecha = strFecha;
	}
	public void setEstadoProyecto(String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}
	
	
	
	/*
	 * MÉTODOS
	 */

	public void entregarProyecto(Calendar fechaEntrega)
	{
		setFechaEntrega(fechaEntrega);
		
		if (fechaEntrega.after(fechaLimite))
		{
			this.estadoProyecto = "Fuera de plazo";
		}
		else
		{
			this.estadoProyecto = "Ok";
		}
	}
	public void agregarAlumno(Alumno al)	//El mismo follón que en agregarProyecto(Proyecto p) de la clase Profesor
	{
		Alumno[] aux = this.alumnos;
		Alumno[] aux2 = new Alumno[1];	//Aqui he tenido problemas con la dimensi�n del array. Solucionado
		if (this.hayAlumno.matches("si"))
		{
			aux2 = new Alumno[aux.length+1];
			for (int i=0;i<aux.length;i++)
			{
				aux2[i] = aux[i];
				System.out.println(aux2[i]);
			}
			aux2[aux2.length-1] = al;
		}
		else
		{
			
			aux2[0] = al;
		}
		this.alumnos = aux2;
		this.hayAlumno = "si";
	}
	public void eliminarAlumno(Alumno al)
	{
		Alumno[] aux = new Alumno[this.alumnos.length-1];
		int i = 0;
		while(!al.esIgual(this.alumnos[i]))
		{
			System.out.println(i);
			aux[i] = this.alumnos[i];
			i++;
		}
		while(i<aux.length)
		{
			this.alumnos[i] = this.alumnos[i+1];
			i++;
		}
		this.setAlumnos(aux);
	}
	public void modificarFechaEntrega(int dia,int mes, int ano)
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE,dia);
		c.set(Calendar.MONTH,mes-1);
		c.set(Calendar.YEAR,ano);
		setFechaEntrega(c);
	}
	public static void modificarFechaLimite(int dia,int mes,int ano)
	{
		fechaLimite.set(Calendar.DATE,dia);
		fechaLimite.set(Calendar.MONTH,mes-1);
		fechaLimite.set(Calendar.YEAR,ano);
		fechaLimite.set(Calendar.HOUR,23);
		fechaLimite.set(Calendar.MINUTE,59);
		fechaLimite.set(Calendar.SECOND,59);
	}
	public boolean esIgual(Proyecto entrada)
	{

		if (entrada.getDescripcion() == null)
		{
			return false;
		}
		if(this.getDescripcion().matches(entrada.getDescripcion()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
