package javaConcepts;

public class Interitance {

	int z;
	
	public void addition (int x,int y)
	{
		z=x+y;
		System.out.println("The sum of given numbers "+z);
	}
	public void substraction(int x, int y)
	{
		z=x-y;
		System.out.println("The difference between "+z);
	}

	public static class My_Calculation extends Interitance
	{
		public void multiplication(int x, int y)
		{
			z =x*y;
			System.out.println("The product of the numbers "+z);
		}
	}
	public static void main(String[] args) {
		
		int a =20, b=10;
		My_Calculation demo = new My_Calculation();
		demo.addition(a, b);
		demo.substraction(a, b);
		demo.multiplication(a, b);
	}

	}
