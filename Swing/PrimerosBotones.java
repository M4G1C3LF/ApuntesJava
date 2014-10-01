import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class PrimerosBotones
{
	private static JFrame frame = new JFrame("Mi primera vez");
	private static JLabel label = new JLabel("--");
	private static JButton botonEscribe = new JButton("Escribe");
	private static JButton botonBorrar = new JButton("Borrar");
	public static void inicializarListeners()
	{
		botonEscribe.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					acciones(e);
				}
			});
			botonBorrar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					acciones(e);
				}
			});
	}
	public static void acciones(ActionEvent e)
	{
		Object obj = e.getSource();
		if (obj == botonEscribe)
		{
			System.out.println("escribo");
			label.setText("Hola");
		}
		else if(obj == botonBorrar)
		{
			System.out.println("borro");
			label.setText("");
		}
	}

	
	public static void main (String[] args)
	{
			
		inicializarListeners();
		frame.getContentPane().add(label);
		frame.getContentPane().add(botonEscribe);
		frame.getContentPane().add(botonBorrar);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1));
		frame.pack();
		
		frame.setVisible(true);
	}
}
