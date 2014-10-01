import javax.swing.*;
class PrimeraInterfaz
{
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Mi primera vez");
		JLabel texto = new JLabel("Hola Mundo");
		
		frame.getContentPane().add(texto);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
