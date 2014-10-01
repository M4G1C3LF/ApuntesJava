import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ConversionMonedas
{
	private static JFrame frame = new JFrame("Conversión de Monedas");
	private static JPanel eurosPanel,cambioPanel,dolaresPanel;
	private static JLabel eurosLabel,cambioLabel,dolaresLabel;
	private static JTextField eurosText, cambioText, dolaresText;
	private static JSlider eurosSlider, dolaresSlider;
	

	public static void inicializarItems()
	{
		frame.setLayout(new FlowLayout());
		
		eurosPanel = new JPanel(new GridLayout(0,1));
		cambioPanel = new JPanel(new GridLayout(0,1));
		dolaresPanel = new JPanel(new GridLayout(0,1));
		
		eurosLabel = new JLabel("Euros");
		cambioLabel = new JLabel("Cambio");
		dolaresLabel = new JLabel("Dólares");
		eurosText = new JTextField();
		cambioText = new JTextField();
		dolaresText = new JTextField();
		eurosSlider = new JSlider(0,1000,0);
		dolaresSlider = new JSlider(0,1000,0);
		
		eurosSlider.setPaintTicks(true);
		eurosSlider.setPaintLabels(true);
		eurosSlider.setMinorTickSpacing(200);
		
		
		frame.getContentPane().add(eurosPanel);
		frame.getContentPane().add(cambioPanel);
		frame.getContentPane().add(dolaresPanel);
		eurosPanel.add(eurosLabel);
		eurosPanel.add(eurosText);
		eurosPanel.add(eurosSlider);
		cambioPanel.add(cambioLabel);
		cambioPanel.add(cambioText);
		dolaresPanel.add(dolaresLabel);
		dolaresPanel.add(dolaresText);
		dolaresPanel.add(dolaresSlider);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public static void inicializarListeners()
	{
		eurosText.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				acciones(e);
			}
		});
		
		cambioText.addActionListener(new ActionListener()
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
		if (obj == eurosText || obj == cambioText)
		{
				calcularCambio();
				
		}
	}
	
	public static void moverSlides(Double euros, Double dolares)
	{
		eurosSlider.setValue(euros.intValue());
		dolaresSlider.setValue(dolares.intValue());
	}
	
	public static void calcularCambio()
	{
			Double euros, cambio,dolares;
			
			try
			{
				euros = Double.valueOf(eurosText.getText());
				cambio = Double.valueOf(cambioText.getText());
				dolares = euros*cambio;
			
				System.out.println(euros);
				System.out.println(cambio);
				System.out.println(dolares.toString());
			
				
				dolaresText.setText(dolares.toString());
				moverSlides(euros,dolares);
			}	
			catch (NumberFormatException e)
			{
				dolaresText.setText("Introduce los valores numéricos!");
			}
	}
	
	public static void main(String[] args)
	{
		inicializarItems();
		inicializarListeners();
		
	}
}
