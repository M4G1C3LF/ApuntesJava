import java.util.*;

class Fecha
{
	Date d;
	GregorianCalendar c;
	
	public void cumpleanos(ano)
	{
		
		
	}
	
	public static void main(String[] args)
	{
		
		Date d = new Date();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);
	
		System.out.println(d);
		System.out.println("Dia del mes :"+c.get(c.DAY_OF_MONTH));
		System.out.println("Mes :"+c.get(c.MONTH));
		System.out.println("Año :"+c.get(c.YEAR));
		
	}
}
