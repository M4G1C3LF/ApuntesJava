import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseFileLockedException;


public class Main {
	private static Consultas db;
	private static JFrame frame = new JFrame("Ejercicio DB4O");
	private static JPanel panel = new JPanel(new GridLayout(0,1));
	private static JButton botonConsultar = new JButton("Consultar");
	private static JButton botonIntroducir = new JButton("Introducir Datos");
	
	private static JButton botonCons1 = new JButton("Todos los Alumnos");
	private static JButton botonCons2 = new JButton("Alumnos con proyecto...");
	private static JButton botonCons3 = new JButton("Proyectos asignados al Profesor...");
	private static JButton botonCons4 = new JButton("Proyectos sin asignar");
	private static JButton botonCons5 = new JButton("Proyectos entregados correctamente");
	private static JButton botonCons6 = new JButton("Proyectos entregados fuera de plazo");
	private static JButton botonCons7 = new JButton("Nota media de los proyectos");
	private static JButton botonCons8 = new JButton("Nota media de los proyectos de un profesor");
	private static JButton botonCons9 = new JButton("Alumnos entre dos notas");
	private static JButton botonCons10 = new JButton("Alumnos con nota menor que...");
	private static JButton botonCons11 = new JButton("Edad media de Alumnos");
	
	private static JLabel label = new JLabel();
	private static JButton botonBuscar = new JButton("Buscar");
	private static JLabel labelBuscar = new JLabel("Patr贸n: ");
	private static JTextField textBuscar = new JTextField();
	private static JTextField textBuscar2 = new JTextField();
	private static int consulta;
	
	private static String respuesta;
	
	private static JButton botonIntr1 = new JButton("Borrar Base de Datos");
	private static JButton botonIntr2 = new JButton("Introducir Alumno");
	private static JButton botonIntr3 = new JButton("Introducir Proyecto");
	private static JButton botonIntr4 = new JButton("Introducir Profesor");
	private static JButton botonIntr5 = new JButton("Asignar alumno a proyecto");
	private static JButton botonIntr6 = new JButton("Asignar proyecto a profesor");
	private static JButton botonIntr7 = new JButton("Eliminar Alumno");
	
	private static JTextField campo1 = new JTextField();
	private static JTextField campo2 = new JTextField();
	private static JTextField campo3 = new JTextField();
	private static JButton alumIntroducir = new JButton("Guardar Alumno");
	private static JButton proyIntroducir = new JButton("Guardar Proyecto");
	private static JButton profIntroducir = new JButton("Guardar Profesor");
	private static JButton asignarAlumProy = new JButton("Asignar");
	private static JButton asignarProyProf = new JButton("Asignar");
	private static JButton alumDel = new JButton("Eliminar");
	private static JButton profDel = new JButton("Eliminar");
	private static JButton proyDel = new JButton("Eliminar");
	
	private static JComboBox comboAlumnos = new JComboBox();
	private static JComboBox comboProyectos = new JComboBox();
	private static JComboBox comboProfesores = new JComboBox();
	
	public static void listenerButton(JButton obj)
	{
		obj.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				acciones(e);
			}
		});
	}
	public static void listenerCombo(JComboBox obj)
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
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.setLocation(500, 300);
		frame.pack();
		frame.setVisible(true);
		
		//CERRAR BASE DE DATOS AL CERRAR LA APLICACI脫N
		frame.addWindowListener(
			    new WindowAdapter() {
			        public void windowClosing(WindowEvent e) {
			        	db.getDb().close();
			            System.exit(0);
			        }
			    }
			);
	}
	public static void inicializarListeners()
	{
		listenerButton(botonConsultar);
		listenerButton(botonIntroducir);
		listenerButton(botonCons1);
		listenerButton(botonCons2);
		listenerButton(botonCons3);
		listenerButton(botonCons4);
		listenerButton(botonCons5);
		listenerButton(botonCons6);
		listenerButton(botonCons7);
		listenerButton(botonCons8);
		listenerButton(botonCons9);
		listenerButton(botonCons10);
		listenerButton(botonCons11);
		listenerButton(botonBuscar);
		
		listenerButton(botonIntr1);
		listenerButton(botonIntr2);
		listenerButton(botonIntr3);
		listenerButton(botonIntr4);
		listenerButton(botonIntr5);
		listenerButton(botonIntr6);
		listenerButton(botonIntr7);
		
		listenerButton(alumIntroducir);
		listenerButton(proyIntroducir);
		listenerButton(profIntroducir);
		
		listenerCombo(comboAlumnos);
		listenerCombo(comboProyectos);
		listenerButton(asignarAlumProy);
		listenerButton(asignarProyProf);
		listenerButton(alumDel);
		listenerButton(profDel);
		listenerButton(proyDel);
	}
	
	public static void acciones(ActionEvent e)
	{
		Object obj = e.getSource();
		label.setText("");
		
		
		JButton botonPulsado = (JButton) obj;
		if (obj == botonConsultar)
		{
			label.setText("");
			ventanaConsultas();
		}
		if (obj == botonIntroducir)
		{
			label.setText("");
			ventanaIntroducir();
		}
		if (obj == botonIntr1)
		{
			db.vaciarBD();
		}
		if (obj == botonIntr2)
		{
			ventanaIntroducirAlumno();
		}
		if (obj == alumIntroducir)
		{
			try
			{
				String name = campo1.getText();
				int age = Integer.parseInt(campo2.getText());
				double qual = Double.parseDouble(campo3.getText());
				
				if (db.almacenarAlumno(new Alumno(name,age,qual)))
				{
					label.setText("Alumno "+name+" guardado en la base de datos");
				}
				else
				{
					label.setText("Alumno "+name+" ya existe en la base de datos");
				}

			}
			catch(NumberFormatException e1)
			{
				label.setText("Error en los atributos del Alumno");
			}
		}
		if (obj == botonIntr3)
		{
			ventanaIntroducirProyecto();
		}
		if (obj == proyIntroducir)
		{
			String name = campo1.getText();
			
			if (db.almacenarProyecto(new Proyecto(name,new Alumno[]{null},null,"Pendent")))
			{
				label.setText("Proyecto "+name+" guardado en la base de datos");
			}
			else
			{
				label.setText("El Proyecto "+name+" ya existe en la base de datos");
			}
		}
		if (obj == botonIntr4)
		{
			ventanaIntroducirProfesor();
		}
		if (obj == profIntroducir)
		{
			String name = campo1.getText();
			
			if (db.almacenarProfesor(new Profesor(new Proyecto[]{null},name)))
			{
				label.setText("Profesor "+name+" guardado en la base de datos");
			}
			else
			{
				label.setText("El Profesor "+name+" ya existe en la base de datos");
			}
		}
		if (obj == botonIntr5)
		{
			ventanaAnadirAlumnoProyecto();
		}
		if (obj == asignarAlumProy)
		{
			String alum = (String) comboAlumnos.getSelectedItem();
			String proy = (String) comboProyectos.getSelectedItem();
			
			Proyecto p = db.buscarProyecto(proy);
			Alumno a = db.buscarAlumno(alum);
			p.agregarAlumno(a);
			for (Alumno aux: p.getAlumnos())
			{
				db.borrarAlumno(aux.getNombre());
			}
			
			db.borrarProyecto(proy);
			
			if (db.almacenarProyecto(p))
			{
				label.setText("Alumno "+alum+" agregado correctamente al proyecto "+proy+".");
			}
			else
			{
				label.setText("Error al a馻dir alumno al proyecto");
			}
		}
		if (obj == botonIntr6)
		{
			ventanaAnadirProyectoProfesor();
		}
		if (obj == asignarProyProf)
		{
			String proy = (String) comboProyectos.getSelectedItem();
			String prof = (String) comboProfesores.getSelectedItem();
			
			Proyecto p = db.buscarProyecto(proy);
			Profesor pro = db.buscarProfesor(prof);
			pro.agregarProyecto(p);
			for (Proyecto aux: pro.getListaProyectos())
			{
				db.borrarProyecto(aux.getDescripcion());
			}
			db.borrarProfesor(prof);
			
			if (db.almacenarProfesor(pro))
			{
				label.setText("Proyecto "+proy+" asignado correctamente al profesor "+prof+".");
			}
			else
			{
				label.setText("Error al a馻dir proyecto al profesor");
			}
		}
		if (obj== botonIntr7)
		{
			ventanaEliminarAlumno();
		}
		if (obj == alumDel)
		{
			String name = (String) comboAlumnos.getSelectedItem();
			
			if (db.borrarAlumno(name))
			{
				label.setText("Alumno "+name+" eliminado de la base de datos");
				
			}
			else
			{
				label.setText("Error al intentar eliminar a "+name);
			}

		}
		if (obj == botonCons1)
		{
				
				ventanaRespuesta(db.todoAlumno(),false,false);
				consulta = 1;
			
		}
		if (obj == botonCons2)
		{
			
			ventanaRespuesta(null,true,false);
			consulta = 2;
		}
		if (obj == botonCons3)
		{
			label.setText("");
			ventanaRespuesta(null,true,false);
			consulta = 3;
		}
		if (obj == botonCons4)
		{
			ventanaRespuesta(db.proyectosSinAsignar(),false,false);
			consulta = 4;
		}
		if (obj == botonCons5)
		{
			ventanaRespuesta(db.proyectosOk(),false,false);
			consulta = 5;
		}
		if (obj == botonCons6)
		{
			ventanaRespuesta(db.proyectosFueraPlazo(),false,false);
			consulta = 6;
		}
		if (obj == botonCons7)
		{
			ventanaRespuesta(db.notaMediaProyectos(),"Nota Media de Proyectos");
			consulta = 7;
		}
		if (obj == botonCons8)
		{
			label.setText("");
			ventanaRespuesta(null,true,false);
			consulta = 8;
		}
		if (obj == botonCons9)
		{
			ventanaRespuesta(null,true,true);
			consulta = 9;
		}
		if (obj == botonCons10)
		{
			ventanaRespuesta(null,true,false);
			consulta = 10;
		}
		if (obj == botonCons11)
		{
			ventanaRespuesta(db.edadMediaAlumnos(),"Edad media de alumnos");
			consulta = 11;
		}
		if (obj== botonBuscar)
		{
			ObjectSet res;
			switch(consulta)
			{
				case 2:	
					res = db.alumnosDeProyecto(textBuscar.getText());
					db.muestraConsulta(db.alumnosDeProyecto(textBuscar.getText()));
					respuesta = "<html>";
					while(res.hasNext())
					{
						Proyecto p = (Proyecto) res.next();
						respuesta+= p+"<br/>" ;
					}
					respuesta+="</html>";
					break;
				case 3:
					res = db.proyectosDeProfesor(textBuscar.getText());
					db.muestraConsulta(db.proyectosDeProfesor(textBuscar.getText()));
					respuesta = "<html>";
					while (res.hasNext())
					{
						respuesta+=res.next()+"<br/>";
					}
					respuesta+="</html>";
					break;
				case 8:
					
					double notaMedia = db.notaMediaProyectos(textBuscar.getText());
					if (notaMedia == 0.0)
					{
						respuesta = "No existe el profesor \""+textBuscar.getText()+"\"";
						break;
					}
					respuesta = "Nota media de Proyectos de "+textBuscar.getText()+": "+notaMedia;
					
					break;
				case 9:
					try
					{
						res = db.todoAlumno(Double.parseDouble(textBuscar.getText()),Double.parseDouble(textBuscar2.getText()));
						db.muestraConsulta(db.proyectosDeProfesor(textBuscar.getText()));
						respuesta = "<html>";
						while (res.hasNext())
						{
							respuesta+=res.next()+"<br/>";
						}
						respuesta+="</html>";
						
					}
					catch(NumberFormatException e1)
					{
						respuesta="Valor incorrecto para una nota.";
						
					}
					break;
				case 10:
					try
					{
						res = db.todoAlumno(Double.parseDouble(textBuscar.getText()));
						respuesta = "<html>";
						while (res.hasNext())
						{
							respuesta+=res.next()+"<br/>";
						}
						respuesta+="</html>";
					}
					catch(NumberFormatException e1)
					{
						respuesta="Valor incorrecto para una nota.";
						
					}
					break;
			}
			
			if (respuesta.contains("<html></html>"))
			{
				respuesta = "No se ha encontrado nada";
			}
			label.setText(respuesta);
		}
		
	}
	
	
	private static void ventanaAnadirProyectoProfesor() {
		JFrame frame = new JFrame("A馻dir Proeyecto a un Profesor");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel proyecto = new JLabel("Proyecto");
		JLabel profesor = new JLabel("Profesor");
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		String[] profesores = {""};
		String[] proyectos = {""};
		
		ObjectSet res = db.todoProyecto();
		int i = 0;
		while (res.hasNext())
		{
			
			Proyecto p = (Proyecto) res.next();
			String[] proyAux = new String[proyectos.length+1];
			for (i=0;i<proyectos.length;i++)
			{
				proyAux[i] = proyectos[i];
			}
			
			if (p.getDescripcion() != null)
			{
				proyAux[i] = p.getDescripcion();
			}
			proyectos = proyAux;
		}
		comboProyectos = new JComboBox(proyectos);
		
		res = db.todoProfesor();
		i = 0;
		while (res.hasNext())
		{
			Profesor p = (Profesor) res.next();
			String[] profAux = new String[profesores.length+1];
			for (i=0;i<profesores.length;i++)
			{
				profAux[i] = profesores[i];
			}
			
			if (p.getNombre() != null)
			{
				profAux[i] = p.getNombre();
			}
			profesores = profAux;
		}
		comboProfesores = new JComboBox(profesores);
		
		panel.add(proyecto);
		panel.add(comboProyectos);
		panel.add(profesor);
		panel.add(comboProfesores);
		panel.add(asignarProyProf);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
		
	}
	private static void ventanaAnadirAlumnoProyecto() {
		JFrame frame = new JFrame("A馻dir Alumno a un Proyecto");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel nombre = new JLabel("Alumno");
		JLabel proyecto = new JLabel("Proyecto");
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		String[] alumnos = {""};
		String[] proyectos = {""};
		
			ObjectSet res = db.todoAlumno();
			int i;
			while (res.hasNext())
			{
				
				Alumno a = (Alumno) res.next();
				String[] alumAux = new String[alumnos.length+1];
				for (i=0;i<alumnos.length;i++)
				{
					alumAux[i] = alumnos[i];
				}
				alumAux[i] = a.getNombre(); 
				alumnos = alumAux;
			}
			comboAlumnos = new JComboBox(alumnos);
		
			res = db.todoProyecto();
			i = 0;
			while (res.hasNext())
			{
				
				Proyecto p = (Proyecto) res.next();
				String[] proyAux = new String[proyectos.length+1];
				for (i=0;i<proyectos.length;i++)
				{
					proyAux[i] = proyectos[i];
				}
				
				if (p.getDescripcion() != null)
				{
					proyAux[i] = p.getDescripcion();
				}
				proyectos = proyAux;
			}
			
			comboProyectos = new JComboBox(proyectos);
			
		panel.add(nombre);
		panel.add(comboAlumnos);
		panel.add(proyecto);
		panel.add(comboProyectos);
		panel.add(asignarAlumProy);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
		
	}

	private static void ventanaEliminarAlumno() {
		JFrame frame = new JFrame("Eliminar Alumno");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel nombre = new JLabel("Nombre");
		
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		String alumnos[] = {""};
		ObjectSet res = db.todoAlumno();
		int i;
		while (res.hasNext())
		{
			
			Alumno a = (Alumno) res.next();
			String[] alumAux = new String[alumnos.length+1];
			for (i=0;i<alumnos.length;i++)
			{
				alumAux[i] = alumnos[i];
			}
			alumAux[i] = a.getNombre(); 
			alumnos = alumAux;
		}
		comboAlumnos = new JComboBox(alumnos);
		panel.add(nombre);
		panel.add(comboAlumnos);
		panel.add(alumDel);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
	}
	private static void ventanaElimniarProyecto()	{
		JFrame frame = new JFrame("Eliminar Proyecto");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel descripcion = new JLabel("Descripcion");
		
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		panel.add(descripcion);
		panel.add(campo1);
		panel.add(proyDel);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
	}
	private static void ventanaEliminarProfesor(){
		JFrame frame = new JFrame("Eliminar Profesor");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel nombre = new JLabel("Nombre");
		
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		panel.add(nombre);
		panel.add(campo1);
		panel.add(profDel);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
	}
	private static void ventanaIntroducirProfesor() {
		JFrame frame = new JFrame("Introducir Profesor");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel nombre = new JLabel("Nombre");
		
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		panel.add(nombre);
		panel.add(campo1);
		panel.add(profIntroducir);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
		
	}


	private static void ventanaIntroducirProyecto() {
		JFrame frame = new JFrame("Introducir Proyecto");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel descripcion = new JLabel("Descipcion");
		
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		panel.add(descripcion);
		panel.add(campo1);
		panel.add(proyIntroducir);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
		
	}


	private static void ventanaIntroducirAlumno() {
		JFrame frame = new JFrame("Introducir Alumno");
		JPanel panel = new JPanel(new GridLayout(0,1));
		JLabel nombre = new JLabel("Nombre");
		JLabel edad = new JLabel("Edad");
		JLabel nota = new JLabel("Nota");
		campo1.setText("");
		campo2.setText("");
		campo3.setText("");
		
		panel.add(nombre);
		panel.add(campo1);
		panel.add(edad);
		panel.add(campo2);
		panel.add(nota);
		panel.add(campo3);
		panel.add(alumIntroducir);
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
	}


	private static void ventanaIntroducir() {
		JFrame frame = new JFrame("Introducir Datos");
		JPanel panel = new JPanel(new GridLayout(0,1));
		panel.add(botonIntr1);
		panel.add(botonIntr2);
		panel.add(botonIntr3);
		panel.add(botonIntr4);
		panel.add(botonIntr5);
		panel.add(botonIntr6);
		panel.add(botonIntr7);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	public static void ventanaConsultas()
	{
		JFrame frame = new JFrame("Realizar Consulta");
		JPanel panel = new JPanel(new GridLayout(0,1));
		label.setText("");
		panel.add(botonCons1);
		panel.add(botonCons2);
		panel.add(botonCons3);
		panel.add(botonCons4);
		panel.add(botonCons5);
		panel.add(botonCons6);
		panel.add(botonCons7);
		panel.add(botonCons8);
		panel.add(botonCons9);
		panel.add(botonCons10);
		panel.add(botonCons11);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public static void ventanaRespuesta(ObjectSet res, boolean txt,boolean txt2)
	{
		JFrame frame = new JFrame("Salida");
		JPanel panel = new JPanel(new GridLayout(4,3));
		respuesta = "";
		textBuscar.setText("");
		textBuscar2.setText("");
		if (txt)
		{
			
			panel.add(labelBuscar);
			panel.add(textBuscar);
			panel.add(botonBuscar);
		}
		if(txt2)
		{
			
			panel.add(textBuscar2);
			
		}
		
		if (res != null)
		{
			respuesta = "<html>";
			while(res.hasNext())
			{
				respuesta+= res.next()+"<br/>" ;
			}
			respuesta+="</html>";
			if (respuesta == "<html></html>")
			{
				respuesta = "No se ha encontrado nada";
			}
			label.setText(respuesta);
			
		}
		else
		{
			label.setText(respuesta);
		}
		
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(400,300);
	
	}
	public static void ventanaRespuesta(double res,String campo)
	{
		JFrame frame = new JFrame("Salida");
		JPanel panel = new JPanel(new GridLayout(4,3));
		
		
			respuesta = campo+": "+res;
			label.setText(respuesta);
			
		
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(600,400);
	
	}
	public static void main(String[] args)
	{
		try
		{
		db = new Consultas();
		db.getConfig().common().objectClass(Proyecto.class).cascadeOnDelete(true);
		db.seleccionarBd("alumnos.db4o");
		
		Proyecto.modificarFechaLimite(23,3,2013);
		
		db.vaciarBD();
		
		
		/*
			db.almacenarAlumno(new Alumno("Sugar",27,6.8));
			db.almacenarAlumno(new Alumno("Alfredo",19,7.4));
			db.almacenarProyecto(new Proyecto("Robot con Arduino",new Alumno[]{new Alumno("Roberto",20,5.6),new Alumno("Javier",18,7.4)},Calendar.getInstance(),"Ok"));
			db.almacenarProyecto(new Proyecto("Servidor",new Alumno[]{null},Calendar.getInstance(),"Ok"));
			db.almacenarProyecto(new Proyecto("Serevidore",new Alumno[]{null},Calendar.getInstance(),"Fuera de plazo"));
			
			
			
			Profesor prf1 = new Profesor(new Proyecto[]{new Proyecto("Aplicaci贸n en Red",new Alumno[]{new Alumno("Francisco",19,8.4),new Alumno("Gerardo",48,9.8)})},"Federico");
			prf1.agregarProyecto(new Proyecto("Brazo Rob贸tico de la parra", new Alumno[]{new Alumno("Sebasti谩n",22,7.8),new Alumno("Agust铆n",21,8.7)}));
			db.almacenarProfesor(prf1);
			prf1.tieneAlumno("Francisco");
			
			System.out.println("-----TODOS LOS ALUMNOS-----");
			db.muestraConsulta(db.todoAlumno());
			System.out.println("----ALUMNOS ASIGNADOS A UN PROYECTO-----");
			db.muestraConsulta(db.alumnosDeProyecto("Robot con Arduino"));
			System.out.println("----PROYECTOS ASIGNADOS A UN PROFESOR-----");
			db.muestraConsulta(db.proyectosDeProfesor("Federico"));
			System.out.println("----PROYECTOS SIN ASIGNAR-----");
			db.muestraConsulta(db.proyectosSinAsignar()); 
			System.out.println("----PROYECTOS CON ESTADO OK-----");
			db.muestraConsulta(db.proyectosOk());
			System.out.println("----CANTIDAD DE PROYECOTOS CON ESTADO OK-----");
			System.out.println(db.countProyectosOk());
			System.out.println("----PROYECTOS FUERA DE PLAZO-----");
			db.muestraConsulta(db.proyectosFueraPlazo());
			System.out.println("----CANTIDAD DE PROYECOTOS FUERA DE PLAZO-----");
			System.out.println(db.countProyectosFueraPlazo());
			System.out.println("----NOTA MEDIA DE LOS PROYECTOS----");
			System.out.println(db.notaMediaProyectos());
			System.out.println("----NOTA MEDIA DE LOS PROYECTOS POR NOMBRE DE PROFESOR----");
			System.out.println(db.notaMediaProyectos("Federico"));
			System.out.println("----ALUMNOS ENTRE NOTA ALTA Y NOTA BAJA----");
			System.out.println(db.todoAlumno(5.8,8.5));
			System.out.println("----ALUMNOS CON MENOS NOTA QUE...----");
			System.out.println(db.todoAlumno(6.0));
			System.out.println("----EDAD MEDIA DE ALUMNOS----");
			System.out.println(db.edadMediaAlumnos());
			System.out.println("----PROYECTOS SIN ASIGNAR-----");
			db.muestraConsulta(db.proyectosSinAsignar());
			System.out.println("----CAMBIAR FECHA DE ENTREGA A PROYECTO-----");
			Proyecto proj = new Proyecto("Servidor",new Alumno[]{null},null,null);
			System.out.println("ANTES: "+proj);
			proj.modificarFechaEntrega(3,6,1992);
			System.out.println("DESPU脡S: "+proj);
			
			proj.entregarProyecto(Calendar.getInstance());
			System.out.println("Entregar Proyecto: "+proj);
			
			System.out.println("----ALUMNOS ASIGNADOS A UN PROYECTO-----");
			db.muestraConsulta(db.alumnosDeProyecto("Robot con Arduino"));
			
			db.almacenarAlumno(new Alumno("Roberto",23,6.7));
			db.almacenarAlumno(new Alumno("Roberto",23,6.7));
			
			db.almacenarProyecto(new Proyecto("kk",new Alumno[]{new Alumno("Sugar",27,6.8)},Calendar.getInstance(),"Ok"));
			db.almacenarProyecto(new Proyecto("kk",new Alumno[]{null},Calendar.getInstance(),"Ok"));
			
			db.almacenarProfesor(new Profesor(new Proyecto[]{new Proyecto("Aplicaci贸n en Red",new Alumno[]{new Alumno("Francisco",19,4.2),new Alumno("Gerardo",48,6.8)})},"Fedrico"));
			
			Alumno a1 = new Alumno("Elisabeth",24,7.6);
			db.almacenarAlumno(a1);
			Proyecto p1 = new Proyecto("Prueba",new Alumno[]{null});
			p1.agregarAlumno(a1);
			db.almacenarProyecto(p1);
			*/
		
		inicializarItems();
		inicializarListeners();
			
		}
		catch(DatabaseFileLockedException e)
		{
			e.printStackTrace();
			panel.add(new JLabel("La base de datos est谩 siendo utilizada, por favor, cierre la aplicaci贸n abierta e int茅ntelo de nuevo"));
			
			frame.getContentPane().add(panel);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setLocation(500, 300);
			frame.pack();
			frame.setVisible(true);
		}
		
	}
}
