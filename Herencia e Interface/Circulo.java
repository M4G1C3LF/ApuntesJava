public class Circulo extends Figura
{
		private int radio;
		Circulo(int rad){radio=rad;}
		
		public double getArea(){return Math.PI*Math.pow(radio,2);}
}
