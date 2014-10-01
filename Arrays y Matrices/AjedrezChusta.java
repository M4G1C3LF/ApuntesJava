import java.io.*;
import java.util.*;
class AjedrezChusta
{
	public	char[][] tablero = new char[2][8];

	public char[][] inicializarArray(char[][] tabla)
	{
		int y,x;
		for (y=0;y<2;y++)
		{
			for (x=0;x<8;x++)
			{
				tabla[y][x]=' ';
			}
				
		}
		return tabla;
	}
	
	public Integer introducirNumero()
	{
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader buff = new BufferedReader(isr);
			String numero = buff.readLine();
			System.out.printf("\n");
			
			return Integer.parseInt(numero);
		}
		catch(NumberFormatException e)
		{
			
			return -1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void pintar(char[][] tabla)
	{
		int y,x;
		for (y=0;y<2;y++)
		{
			for (x=0;x<8;x++)
			{
				if ((tabla[y][x])==' ')
				{
					System.out.printf("_");
				}
				else
				{
					System.out.print(tabla[y][x]);
				}
			}
			System.out.print("\n");
		}
	}
	public int ponerRey()
	{
		Integer posRey= -1;
		
		while(posRey < 1 || posRey >8)
		{
			System.out.printf("Jugador 1, escoja la posición del Rey (1-8): ");
			posRey = this.introducirNumero();
		
			if (posRey < 1 || posRey > 8)
			{
				System.out.println("Ha introducido un número incorrecto, vuelva a introducirlo.");
			}
			else
			{
				this.tablero[0][posRey-1] = 'R';

			}
			
		
		}
		return posRey;
	}
	public void ponerPeones()
	{
		Integer pos = -1,nPeones = 1;
		while (nPeones <=3)
		{
			pos = -1;
			while(pos < 1 || pos >8)
			{
				System.out.printf("Jugador 2, escoja la posición del Peón "+nPeones+" (1-8): ");
				pos = this.introducirNumero();
			
				if (pos < 1 || pos > 8)
				{
					System.out.println("Ha introducido un número incorrecto, vuelva a introducirlo.");
				}
				else
				{
					if (this.tablero[1][pos-1] != 'P')
					{
						this.tablero[1][pos-1] = 'P';
						nPeones++;
					}
					else
					{
						System.out.println("Posición ocupada!");
					}
			
				}
				
			}
				
		}
	}
	public void comentarJugada(int posRey)
	{
		switch (posRey)
			{
				case 0:
					if(this.tablero[1][posRey+1] == 'P')
					{
						System.out.print("Jaque");
						if (this.tablero[1][posRey] == 'P' || this.tablero[1][posRey+2] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					break;
				case 1:
					if(this.tablero[1][posRey-1] == 'P' || this.tablero[1][posRey] == 'P' || this.tablero[1][posRey+1] == 'P')
					{
						System.out.print("Jaque");
						if(this.tablero[1][posRey] == 'P' && this.tablero[1][posRey+1] == 'P' && this.tablero[1][posRey-1] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					break;
				case 6:
					if(this.tablero[1][posRey-1] == 'P' || this.tablero[1][posRey] == 'P' || this.tablero[1][posRey+1] == 'P')
					{
						System.out.print("Jaque");
						if(this.tablero[1][posRey] == 'P' && this.tablero[1][posRey+1] == 'P' && this.tablero[1][posRey-1] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					break;
				case 7:
					if(this.tablero[1][posRey-1] == 'P')
					{
						System.out.print("Jaque");
						if (this.tablero[1][posRey] == 'P' || this.tablero[1][posRey-2] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					break;
				default:
					if(this.tablero[1][posRey-1] == 'P')
					{
						System.out.print("Jaque");
						if (this.tablero[1][posRey] == 'P' && this.tablero[1][posRey+1] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					else if(this.tablero[1][posRey+1] == 'P')
					{
						System.out.print("Jaque");
						if (this.tablero[1][posRey] == 'P' && this.tablero[1][posRey-1] == 'P')
						{
							System.out.print(" mate\n");
						}
					}
					
			}
	}
	
	public static void main (String[] args)
	{
			AjedrezChusta ejemplo = new AjedrezChusta();
			ejemplo.tablero = ejemplo.inicializarArray(ejemplo.tablero);
			Integer posRey=ejemplo.ponerRey();
			ejemplo.ponerPeones();
			ejemplo.pintar(ejemplo.tablero);
			ejemplo.comentarJugada(posRey-1);
			

	}
}
