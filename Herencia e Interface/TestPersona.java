public class TestPersona
{
	
	public static void main(String[] argv)
	{
		Persona p1;
		p1 = new Empleado();
		p1.setNombre("Perico Palotes");
		((Empleado)p1).setSueldo(100);
		
		Empleado e1;
		e1 = new Encargado();
		e1.setSueldo(500);
		System.out.println(e1.getSueldo());
	}
}
