class Pececito extends Pez
{
	Pececito(String nom, String col){nombre=nom;color=col;}
	Pececito(Pececito molde){nombre=molde.getNombre(); color=molde.getColor(); }
	public void ruido(){System.out.println("Se oye un ruido... Se entiende algo como 'BOOOYZAAAARD'");}
}
