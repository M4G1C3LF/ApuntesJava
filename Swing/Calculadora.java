import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculadora
{
	private static JFrame frame = new JFrame("Calculadora");
	private static JPanel numerosPanel,operacionesPanel,introducirPanel;
	private static JButton boton0;
	private static JButton boton1;
	private static JButton boton2;
	private static JButton boton3;
	private static JButton boton4;
	private static JButton boton5;
	private static JButton boton6;
	private static JButton boton7;
	private static JButton boton8;
	private static JButton boton9;
	private static JButton botonIgual;
	private static JButton botonPunto;
	private static JButton botonSuma;
	private static JButton botonResta;
	private static JButton botonMultiplicar;
	private static JButton botonDividir;
	private static JButton botonReset;
	private static JTextField introducir;
	
	private static Double operando1, operando2;
	private static Character operacion;
	
	public static void inicializarItems()
	{
		
		
		frame.setLayout(new FlowLayout());
		
		introducirPanel = new JPanel(new GridLayout(1,1));
		numerosPanel = new JPanel(new GridLayout(4,3));
		operacionesPanel = new JPanel(new GridLayout(0,1));
		
		boton0 = new JButton("0");
		boton1 = new JButton("1");
		boton2 = new JButton("2");
		boton3 = new JButton("3");
		boton4 = new JButton("4");
		boton5 = new JButton("5");
		boton6 = new JButton("6");
		boton7 = new JButton("7");
		boton8 = new JButton("8");
		boton9 = new JButton("9");
		botonPunto = new JButton(".");
		botonIgual = new JButton("=");
		botonSuma = new JButton("+");
		botonResta = new JButton("-");
		botonMultiplicar = new JButton("*");
		botonDividir = new JButton("/");
		botonReset = new JButton("C");
		
		introducir = new JTextField(10);
		
		numerosPanel.add(boton1);
		numerosPanel.add(boton2);
		numerosPanel.add(boton3);
		numerosPanel.add(boton4);
		numerosPanel.add(boton5);
		numerosPanel.add(boton6);
		numerosPanel.add(boton7);
		numerosPanel.add(boton8);
		numerosPanel.add(boton9);
		numerosPanel.add(boton0);
		numerosPanel.add(botonPunto);
		numerosPanel.add(botonIgual);
		
		operacionesPanel.add(botonSuma);
		operacionesPanel.add(botonResta);
		operacionesPanel.add(botonMultiplicar);
		operacionesPanel.add(botonDividir);
		operacionesPanel.add(botonReset);
		
		introducirPanel.add(introducir);
		
		frame.getContentPane().add(introducirPanel);
		frame.getContentPane().add(numerosPanel);
		frame.getContentPane().add(operacionesPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
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
	public static void inicializarListeners()
	{
		listener(boton0);
		listener(boton1);
		listener(boton2);
		listener(boton3);
		listener(boton4);
		listener(boton5);
		listener(boton6);
		listener(boton7);
		listener(boton8);
		listener(boton9);
		listener(botonPunto);
		listener(botonIgual);
		listener(botonSuma);
		listener(botonResta);
		listener(botonMultiplicar);
		listener(botonDividir);
		listener(botonReset);
			
	}
	public static void calcular()
	{
		if (operando2 == null)
		{
			operando2 = operando1;
		}
		
			switch (operacion)
			{
				case 's':
					operando1=operando1+operando2;
					break;
				case 'r':
					operando1=operando1-operando2;
					break;
				case 'm':
					operando1=operando1*operando2;
					break;
				case 'd':
					operando1=operando1/operando2;
					break;
			}
			introducir.setText(operando1.toString());
			operando2=null;
		
		
	}
	public static void setOperadores()
	{
		String temp;
		if (operando1 == null)
		{
			operando1 = operando1.parseDouble(introducir.getText());
		}
		else
		{
			temp= introducir.getText();
			if (temp.isEmpty())
			{
				//asumimos el 0 	
				operando2 = 0.0;
			}
			
			
			else
			{
				operando2 = operando2.parseDouble(introducir.getText());
			}
			
		}
	}
	public static void mostrarResultado()
	{
		if (operando2 == null)
		{
			introducir.setText("");
		}
		else
		{
			calcular();
			introducir.setText(operando1.toString());
		}
	}
	public static void mostrarResultadoIgual()
	{
		setOperadores();
		calcular();
		introducir.setText(operando1.toString());
	}
	public static void prepararCalculo()
	{
		if (operando2 == null)
		{
			setOperadores();
			introducir.setText("");
		}
		else
		{
			setOperadores();
			mostrarResultado();
		}
	}
	public static void acciones(ActionEvent e)
	{
		Object obj = e.getSource();
		JButton botonPulsado = (JButton) obj;
		if (obj == boton0 || obj == boton1 || obj == boton2 || obj == boton3 || obj == boton4 || obj == boton5 || obj==boton6 || obj==boton7 || obj==boton8 || obj==boton9 )
		{
				
				introducir.setText(introducir.getText()+botonPulsado.getText());	
		}
		if (obj ==botonPunto)
		{
			
			if (! introducir.getText().contains("."))
			{
				if (introducir.getText().length()==0)
				{
					introducir.setText("0.");
				}
				else
				{
					introducir.setText(introducir.getText()+".");
				}
			}
		}
		if (obj == botonSuma)
		{
			operacion = 's';
			prepararCalculo();
		}
		if (obj == botonResta)
		{
			operacion = 'r';
			prepararCalculo();
		}
		if (obj == botonMultiplicar)
		{
			operacion = 'm';
			prepararCalculo();
		}
		if (obj == botonDividir)
		{
			operacion = 'd';
			prepararCalculo();
		}
		if (obj == botonIgual)
		{
			mostrarResultadoIgual();
		}
		if (obj == botonReset)
		{
			operando1 = null;
			operando2 = null;
			introducir.setText("");
		}
	}
	public static void main(String[] args)
	{
		inicializarItems();
		inicializarListeners();
	}
}
