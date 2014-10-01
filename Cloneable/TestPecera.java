class TestPecera
{
	
	public static void main(String[] args)
	{
		Pez porDefecto = new Pez();
		Pez creado = new Pez("Nemo","Amarillo");
		Pez copia = new Pez(creado);
		Pez clon = (Pez) porDefecto.clone();
		Pececito mini = new Pececito("Mini Pez","Azulín");
		
		System.out.println("Nombre: "+porDefecto.getNombre()+"\tColor: "+porDefecto.getColor());
		System.out.println("Nombre: "+creado.getNombre()+"\tColor: "+creado.getColor());
		System.out.println("Nombre: "+copia.getNombre()+"\tColor: "+copia.getColor()+"\n");
		System.out.println("Nombre: "+clon.getNombre()+"\tColor: "+clon.getColor()+"\n");
		System.out.println("Nombre: "+mini.getNombre()+"\tColor: "+mini.getColor()+"\n");


		
		System.out.println("Son iguales 'porDefecto' y 'creado'? "+creado.equals(porDefecto));
		System.out.println("Son iguales 'copia' y 'creado'? "+creado.equals(copia)+"\n");
		
		
		
		mini.ruido();
		
		System.out.println("Número de peces: "+porDefecto.getNumPeces());
	}
}
