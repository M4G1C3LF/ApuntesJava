import java.io.*;
public class EjemploFlujos
{
	public static void main(String[] args)
	{
		//Cadena con lo que queremos guardar
		String s = new String("En un lugar de la Mancha de cuyo nombre no quiero acordarme,");
		s = s + "no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, ";
		s = s + "adarga antigua, rocín flaco y galgo corredor...";
		
		char[] arr = new char[s.length()]; //Creamos array de carácteres con la longitud de la cadena s.
		int car=0;
		
		StringReader flujoInput = new StringReader(s); //Se instancia un objeto de tipo StringReader con el String que tenemos en memoria.
		CharArrayWriter flujoOutput = new CharArrayWriter(); //Instanciamos un objeto de tipo CharArrayWritter sin especificar el tamaño de Array.
		
		try{
			while ((car = flujoInput.read()) != -1){	//Mientras haya un carácter que leer en el fichero escribe un carácter.
				flujoOutput.write(car);
			}
			
			arr = flujoOutput.toCharArray(); //Se almacena en arr el contenido del flujo
			System.out.println(arr); //Se imprime el array.
		}
		catch (IOException e){
			e.printStackTrace(); //Salta el error si el contenido del try falla
		}
		
		finally
		{
			flujoInput.close();	//Cerramos los flujos
			flujoOutput.close();
		}
	}
}
