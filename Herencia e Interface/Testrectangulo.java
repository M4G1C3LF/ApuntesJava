class Testrectangulo
{
	public static void main(String[] args)
	{
	/*	Rectangulo r1 = new Rectangulo(20,30);
		Rectangulo r2 = r1.incrementarAncho();
		System.out.printf("Ancho: "+r1.getAncho()+"\t Alto: "+r1.getAlto()+"\n");
		System.out.printf("Ancho: "+r2.getAncho()+"\t Alto: "+r2.getAlto()+"\n");*/
		
	/*	Rectangulo r1 = new Rectangulo(50,20,"Rictángulo");
		Rectangulo r2 = (Rectangulo) r1.clone();
		
		
		
		System.out.printf("Fase1\n\n");
		
		System.out.printf("Nombre: "+r1.getNombre()+"\t Ancho: "+r1.getAncho()+"\t Alto: "+r1.getAlto()+"\n");
		System.out.printf("Nombre: "+r2.getNombre()+"\t Ancho: "+r2.getAncho()+"\t Alto: "+r2.getAlto()+"\n\n");

		r1.incrementarAlto();
		r2.incrementarAncho();

		r1.setNombre("Rectangle");
		r2.setNombre("Boyzard");

		System.out.printf("Fase2\n\n");
		
		
		
		System.out.printf("Nombre: "+r1.getNombre()+"\t Ancho: "+r1.getAncho()+"\t Alto: "+r1.getAlto()+"\n");
		System.out.printf("Nombre: "+r2.getNombre()+"\t Ancho: "+r2.getAncho()+"\t Alto: "+r2.getAlto()+"\n");*/
		
		Rectangulo r1 = new Rectangulo(5,7,"Rectangle");
		Rectangulo r2 = new Rectangulo(5,7,"Rectangle");
		Rectangulo r3 = r1;
		
		if (r1.equals2(r2)){System.out.println("r1 y r2 son iguales");}
		if (r1.equals2(r3)){System.out.println("r1 y r3 son iguales");}
		
		System.out.printf(r1.toString()+"\n");
		System.out.printf(r2.toString()+"\n");
		System.out.printf(r3.toString()+"\n");
		
	}
}
