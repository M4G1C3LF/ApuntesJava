import java.io.File;

import com.db4o.*;
import com.db4o.query.*;
import com.db4o.config.EmbeddedConfiguration;

public class Consultas {

	private EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
	private ObjectContainer db; 
	private String nombreDb;
	
	//config.common().objectClass(Proyecto.class).cascadeOnDelete(true); ACUERDATE DE PONERLO POR ALGÚN LADO, PARGUELA
	/*
	 * GETTERS Y SETTERS
	 */
	public EmbeddedConfiguration getConfig() {
		return config;
	}
	public void setConfig(EmbeddedConfiguration config) {
		this.config = config;
	}
	public ObjectContainer getDb() {
		return db;
	}
	public void setDb(ObjectContainer db) {
		this.db = db;
	}
	public String getNombreDb() {
		return nombreDb;
	}
	public void setNombreDb(String nombreDb) {
		this.nombreDb = nombreDb;
	}
	/*
	 * MÉTODOS
	 */
	
	public void seleccionarBd(String fichero)
	{
		config = Db4oEmbedded.newConfiguration();
		db = Db4oEmbedded.openFile(config,fichero);
		nombreDb = fichero;
	}
	public boolean almacenarAlumno(Alumno a)
	{
		ObjectSet res = this.todoAlumno();
		while (res.hasNext())
		{
			Alumno aAux = (Alumno) res.next();
			if (aAux.esIgual(a))
			{
				System.out.println("El alumno "+a+" ya existe");
				return false;
			}
		}
		db.store(a);
		System.out.println(a+" guardado correctamente");
		return true;
		
	}
	public boolean almacenarProyecto(Proyecto p)
	{
		Alumno[] lAlum = p.getAlumnos();
		
		for (Alumno a: lAlum)
		{
			if (!this.almacenarAlumno(a))
			{
				return false;
			}
		}
		ObjectSet res = this.todoProyecto();
		while (res.hasNext())
		{
			Proyecto pAux = (Proyecto) res.next();
			
			if (p.esIgual(pAux))
			{
				System.out.println("El proyecto "+p+"<- ya existe");
				return false;
			}
		}
		db.store(p);
		System.out.println(p+" guardado correctamente");
		return true;
	}
	public boolean almacenarProfesor(Profesor prf)
	{
		Proyecto[] lProj = prf.getListaProyectos();
		
		if (lProj[0] != null)
		{
			for (Proyecto p: lProj)
			{
				if (!this.almacenarProyecto(p))
				{
					return false;
				}
			}
		}
		ObjectSet res = this.todoProfesor();
		while (res.hasNext())
		{
			Profesor prfAux = (Profesor) res.next();
			if (prfAux.esIgual(prf))
			{
				System.out.println("El profesor "+prf+" ya existe");
				return false;
			}
		}
		db.store(prf);
		System.out.println(prf+" guardado correctamente");
		return true;
	}
	public void vaciarBD()
	{
		this.getDb().close();
		new File(nombreDb).delete();
		this.getConfig().common().objectClass(Proyecto.class).cascadeOnDelete(true);
		this.seleccionarBd(nombreDb);
	}
	
	public boolean borrarProyecto(String desc)
	{
		
			Query query = db.query();
			query.constrain(Proyecto.class);
			query.descend("descripcion").constrain(desc);
			ObjectSet result=query.execute();
			
			while (result.hasNext())
			{
				Proyecto p =(Proyecto)result.next();
				System.out.println("Borrado: "+p);
				db.delete(p);
				return true;
			}
			return false;
	}
	public boolean borrarAlumno(String nombre)
	{
		
			Query query = db.query();
			query.constrain(Alumno.class);
			query.descend("nombre").constrain(nombre);
			ObjectSet result=query.execute();
			
			while (result.hasNext())
			{
				Alumno a =(Alumno)result.next();
			/*	ObjectSet res = this.todoProyecto();
				while (res.hasNext())
				{
					Proyecto p = (Proyecto) res.next();
					p.eliminarAlumno(a);
					this.borrarProyecto(p.getDescripcion());
					db.store(p);
				}*/
				System.out.println("Borrado: "+a);
				db.delete(a);
				return true;
			}
			return false;
		
		
	}
	public boolean borrarProfesor(String nombre)
	{
		
			Query query = db.query();
			query.constrain(Profesor.class);
			query.descend("nombre").constrain(nombre);
			ObjectSet result=query.execute();
			
			while (result.hasNext())
			{
				Profesor p =(Profesor)result.next();
				System.out.println("Borrado: "+p);
				db.delete(p);
				return true;
			}
			return false;
	}
	public Alumno buscarAlumno(String nombre)
	{
		Query query = db.query();
		query.constrain(Alumno.class);
		query.descend("nombre").constrain(nombre);
		ObjectSet result=query.execute();
		Alumno a = null;
		
		while (result.hasNext())
		{
			a =(Alumno)result.next();		
		}
		return a;
	}

	public Proyecto buscarProyecto(String desc)
	{
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("descripcion").constrain(desc);
		ObjectSet result=query.execute();
		Proyecto p= null;
		
		while (result.hasNext())
		{
			p =(Proyecto)result.next();		
		}
		return p;
	}
	public Profesor buscarProfesor(String nombre)
	{
		Query query = db.query();
		query.constrain(Profesor.class);
		query.descend("nombre").constrain(nombre);
		ObjectSet result=query.execute();
		Profesor p= null;
		
		while (result.hasNext())
		{
			p =(Profesor)result.next();		
		}
		return p;
	}
	/*
	 * CONSULTAS DE EJERCICIOS
	 */
	public void muestraConsulta(ObjectSet res)
	{
		System.out.println("Recuperados "+res.size()+" objetos");
		while(res.hasNext())
		{
			System.out.println(res.next());
		}
	}
	public ObjectSet todoAlumno()
	{
		return db.queryByExample(new Alumno(null,0,0.0));
	}
	public ObjectSet todoProyecto()
	{
		Proyecto p = new Proyecto(null,new Alumno[]{null},null,null);
		p.setHayAlumno(null);
		return db.queryByExample(p);
	}
	public ObjectSet todoProfesor()
	{
	//	Proyecto p = new Proyecto(null,new Alumno[]{null},null,null);
	//	p.setHayAlumno(null);
		Profesor prof = new Profesor(new Proyecto[]{null},null);
		return db.queryByExample(prof);
	}
	public ObjectSet todoAlumno(double notaBaja, double notaAlta)
	{
		if (notaBaja < 0 || notaAlta > 10)
		{
				return null;
		}
		
		Query query = db.query();
		query.constrain(Alumno.class);
		query.descend("nota").constrain(notaBaja).greater().and(query.descend("nota").constrain(notaAlta).smaller());
		return query.execute();
		
	}
	public ObjectSet todoAlumno(double notaCorte)
	{
		if (notaCorte < 0 || notaCorte > 10)
		{
				return null;
		}
		
		Query query = db.query();
		query.constrain(Alumno.class);
		query.descend("nota").constrain(notaCorte).smaller();
		return query.execute();
		
	}
	public ObjectSet alumnosDeProyecto(String nombreProyecto)
	{
		
		
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("descripcion").constrain(nombreProyecto);
		return query.execute();
		
	
		
	}
	public ObjectSet proyectosDeProfesor(String nombre)
	{
		System.out.println(nombre);
		Proyecto p = new Proyecto(null,new Alumno[]{null},null,null);
		p.setHayAlumno(null);
		Profesor prof = new Profesor(new Proyecto[]{p},nombre);
		return db.queryByExample(prof);
		
	}
	public ObjectSet proyectosAsignados()
	{
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("alumnos").constrain(null).not();
		return query.execute();
	}
	public ObjectSet proyectosSinAsignar()	//Finalmente, he teido que crear el atributo "hayAlumno" en la clase Proyecto para que funcione esta consulta.
	{
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("hayAlumno").constrain("no");
		return query.execute();
	}
	
	public ObjectSet proyectosOk()
	{
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("estadoProyecto").constrain("Ok");
		return query.execute();
	}
	public int countProyectosOk()
	{
		return this.proyectosOk().size();
	}
	public ObjectSet proyectosFueraPlazo()
	{
		Query query = db.query();
		query.constrain(Proyecto.class);
		query.descend("estadoProyecto").constrain("Fuera de plazo");
		return query.execute();
	}
	public int countProyectosFueraPlazo()
	{
		return this.proyectosFueraPlazo().size();
	}
	public double notaMediaProyectos()
	{
		ObjectSet res = proyectosAsignados();
		Proyecto p;
		double suma = 0;
		int i = 0;
		while(res.hasNext())
		{
			p = (Proyecto) res.next();
			for (Alumno a: p.getAlumnos())
			{
				suma += a.getNota();
				i++;
			}
		}
		return suma/i;
	}
	public double notaMediaProyectos(String profesor)
	{
		Query query = db.query();
		query.constrain(Profesor.class);
		query.descend("nombre").constrain(profesor);
		
		if (query.execute().hasNext())
		{
			Profesor prf = (Profesor) query.execute().next();
			
			int i=0;
			double suma = 0;
			for (Proyecto pro: prf.getListaProyectos())
			{
				for(Alumno al: pro.getAlumnos())
				{
					suma += al.getNota();
					i++;
				}
			}
			return suma/i;
		}
		return 0.0;
	}
	
	public double edadMediaAlumnos()
	{
		Alumno al;
		ObjectSet alumnos = todoAlumno();
		double suma = 0;
		int i = 0;
		while(alumnos.hasNext())
		{
			al = (Alumno) alumnos.next();
			suma += al.getEdad();
			i++;
		}
		return suma/i;
	}
}
