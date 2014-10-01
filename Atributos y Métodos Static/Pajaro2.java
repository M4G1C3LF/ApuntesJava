class Pajaro2
{
		private static int numpajaros=0;
		private char color;
		private int edad;
		
		static void nuevopajaro(){numpajaros++;}
		
		Pajaro2(){color='v'; edad=0;nuevopajaro();}
		Pajaro2(char c, int e){color=c;edad=e;nuevopajaro();}
		
		static void muestrapajaros(){System.out.println(numpajaros);}
		
		public static void main(String[] args)
		{
			Pajaro2 p1,p2;
			p1=new Pajaro2();
			p2=new Pajaro2('a',3);
			
			p1.muestrapajaros();
			p2.muestrapajaros();
		}
}
