import java.io.*;
import java.util.*;
import java.lang.*;
class Matriz
{
	public static void main(String[] args)
	{
		Integer[][] matriz = new Integer[5][5];
		Integer x,y;
		
		for(y=0;y<5;y++)
		{
			for(x=0;x<5;x++)
			{
				matriz[x][y] = x+y;
				System.out.printf(matriz[x][y].toString()+"\t");
			}
			System.out.printf("\n");
		}
	}
}