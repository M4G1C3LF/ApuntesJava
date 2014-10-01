public class Temperatura
{	
	private double temperatura;
	
	Temperatura(){temperatura=0;}
	double toFahrenheit(double temp){return (1.8)*temp+32;}
	double toCelsius(double temp){return (temp-32)/1.8;}
	
	
	public static void main(String[] args)
	{
		
		Temperatura celsius = new Temperatura();
		Temperatura fahrenheit = new Temperatura();
		
		celsius.temperatura = 34.5;
		fahrenheit.temperatura = 106.3;
		
		System.out.println(celsius.temperatura+" ºC son "+celsius.toFahrenheit(celsius.temperatura)+" ºF");
		System.out.println(fahrenheit.temperatura+" ºF son "+fahrenheit.toCelsius(fahrenheit.temperatura)+" ºC");
	}
}
