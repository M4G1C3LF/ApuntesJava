import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 import java.io.*;
import java.util.*;
public class ReadXMLFile {
	public String introducirString()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(isr);
			String cadena = buff.readLine();
			
			return cadena;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public void escribirEnFichero(String paraEscribir,BufferedWriter bw)
	{
		try
		{
			bw.write(paraEscribir);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
   public static void main(String argv[]) {
	  
	final  ReadXMLFile ejemplo = new ReadXMLFile();
	  
	System.out.printf("Introduce un fichero de salida: ");
	String salida = ejemplo.introducirString();
	File fo= new File(salida);
    try {
	
	FileWriter fw = new FileWriter(fo);
	final BufferedWriter bw = new BufferedWriter(fw);
	
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 
	DefaultHandler handler = new DefaultHandler() {
 
	boolean bfname = false;
	boolean blname = false;
	boolean bnname = false;
	boolean bsalary = false;
 
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
 
		System.out.println("Start Element :" + qName);
 
		if (qName.equalsIgnoreCase("FIRSTNAME")) {
			bfname = true;
		}
 
		if (qName.equalsIgnoreCase("LASTNAME")) {
			blname = true;
		}
 
		if (qName.equalsIgnoreCase("NICKNAME")) {
			bnname = true;
		}
 
		if (qName.equalsIgnoreCase("SALARY")) {
			bsalary = true;
		}
}

public void endElement(String uri, String localName,
		String qName) throws SAXException {
 
		System.out.println("End Element :" + qName);
 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
 
			String item = "";
		if (bfname) {
			item = "Empleado: "+new String(ch, start, length)+"\t";
			System.out.println("First Name : " + new String(ch, start, length));
			ejemplo.escribirEnFichero(item,bw);
			bfname = false;
		}
 
		if (blname) {
			System.out.println("Last Name : " + new String(ch, start, length));
			blname = false;
		}
 
		if (bnname) {
			System.out.println("Nick : " + new String(ch, start, length));
			bnname = false;
		}
 
		if (bsalary) {
			System.out.println(new String("Salario : " + new String(ch, start, length)));
			Double SalarioDou = new Double(Double.parseDouble(new String(ch, start, length))*1.05);
			System.out.println(SalarioDou);
			item= "Salario: "+SalarioDou.toString()+"\n";
			ejemplo.escribirEnFichero(item,bw);
			bsalary = false;
		}
		
	}
 
     };
 
       saxParser.parse("ficheroxml.xml", handler);
		bw.close();
			
			fw.close();
			
     } catch (Exception e) {
       e.printStackTrace();
     }
 
   }
 
}
