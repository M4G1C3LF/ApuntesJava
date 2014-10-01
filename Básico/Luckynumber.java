class Luckynumber
{
	int dia,mes,ano;
	int luck;
	
	Luckynumber()
	{
		int i;
		int aux = 0;
		dia=2;mes=1;ano=1991;
		
		luck=dia+mes+ano;
		
		
		while(luck>=10)
		{
			aux=0;
			for(i=0;i<4;i++)
			{
				aux+=luck%10;
				luck/=10;
			}
			luck=aux;	
			
		}
		System.out.println("Tu número de la suerte es: "+luck);
	}
	
	public static void main (String[] args)
	{
		Luckynumber ejemplo = new Luckynumber();
		
	}
}
