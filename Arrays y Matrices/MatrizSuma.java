import java.io.*;
import java.util.*;
import java.lang.*;
class MatrizSuma
{
	public static void main(String[] args)
	{
		Integer[][] matriz1 = new Integer[5][5];
		Integer[][] matriz2 = new Integer[5][5];

		Integer x,y;
		
		for(y=0;y<5;y++)
		{
			for(x=0;x<5;x++)
			{
				matriz1[x][y] = x+y;
				matriz2[x][y] = matriz1[x][y]+matriz1[x][y];
				System.out.printf(matriz2[x][y].toString()+"\t");

			}
			System.out.printf("\n");
		}
	}
}