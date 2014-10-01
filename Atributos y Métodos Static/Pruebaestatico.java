public class Pruebaestatico
{
	public int dato=0;
	public static int datostatico=0;
	public void metodo() {this.datostatico++;}
	
	public static void metodostatico()
	{
		this.datostatico++; //peta porque es un método estatico usando this
		datostatico++;
	}
	
	public static void main(String[] args)
	{
		dato++; //peta, se supone que esto se puede utilizar en UN OBJETO
		datostatico++;
		metodostatico();
		metodo(); //peta porque necesitas un objeto
	}
}
