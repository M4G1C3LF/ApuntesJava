import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.db4o.ObjectSet;


public class Interfaz {
		private static JFrame frame = new JFrame("Ejercicio DB4O");
		private static JPanel panel = new JPanel(new GridLayout(0,1));
		private static JButton botonConsultar = new JButton("Consultar");
		private static JButton botonIntroducir = new JButton("Introducir Datos");
		private static JButton botonTodosAlumnos = new JButton("Todos los Alumnos");
		
		public static void listener(JButton obj)
		{
			obj.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					acciones(e);
				}
			});
		}
		public static void inicializarItems()
		{
			panel.add(new JLabel("Base de datos orientada a objetos"));
			panel.add(botonConsultar);
			panel.add(botonIntroducir);
			

			
			frame.getContentPane().add(panel);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		}
		public static void inicializarListeners()
		{
			listener(botonConsultar);
			listener(botonIntroducir);
			listener(botonTodosAlumnos);
		}
		
		public static void acciones(ActionEvent e)
		{
			Object obj = e.getSource();
			JButton botonPulsado = (JButton) obj;
			if (obj == botonConsultar)
			{
				ventanaConsultas();
			}
			if (obj == botonIntroducir)
			{
				System.out.println("the game");
			}
			if (obj == botonTodosAlumnos)
			{
				//ventanaRespuesta(db.t);
			}
		}
		
		public static void ventanaConsultas()
		{
			JFrame frame = new JFrame("Realizar Consulta");
			JPanel panel = new JPanel(new GridLayout(0,1));
			
			panel.add(botonTodosAlumnos);
			frame.getContentPane().add(panel);
			frame.pack();
			frame.setVisible(true);
		}
		public static void ventanaRespuesta(ObjectSet res)
		{
			JFrame frame = new JFrame("Salida");
			JPanel panel = new JPanel(new GridLayout(0,1));
			String str = "";
			while(res.hasNext())
			{
				str+= res.next()+"\n" ;
			}
			
			JLabel label = new JLabel(str);
			panel.add(label);
			frame.getContentPane().add(panel);
			frame.pack();
			frame.setVisible(true);
		
		}
}
