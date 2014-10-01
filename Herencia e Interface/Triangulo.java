public class Triangulo extends Figura
{
		private int base, altura;
		Triangulo(int bas, int al){base=bas; altura=al;}
		
		public double getArea(){return (base*altura)/2;}
}
