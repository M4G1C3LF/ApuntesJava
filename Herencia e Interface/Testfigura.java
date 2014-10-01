public class Testfigura
{
	public static void main(String[] args)
	{
		Circulo cercle = new Circulo(9);
		Triangulo triangle = new Triangulo(30,21);
		Rectangulo4 rectangle = new Rectangulo4(10,5);
		
		System.out.println("Area circulo: "+cercle.getArea());
		System.out.println("Area triangulo: "+triangle.getArea());
		
		cercle.setColor("Verde");
		triangle.setColor("Azul");
		
		System.out.println("Color circulo: "+cercle.getColor());
		System.out.println("Color triangulo: "+triangle.getColor());
		
		Rectangulo4 copia = new Rectangulo4(rectangle);
		
		System.out.println("Rectangle: "+rectangle.getAlto()+" x "+rectangle.getAncho()+"\n");
		System.out.println("Rectangle: "+copia.getAlto()+" x "+copia.getAncho()+"\n");
	}
}
