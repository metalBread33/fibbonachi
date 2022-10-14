import java.util.Scanner; import java.math.*;
public class Fibonacci {
	 
	public static void main(String[] args) {
		boolean quit = false; int num = 0; char choice;  
		greet();
		
		do {
		
		choice = menu();
		
		if (choice != 'q')
			num = number();
		
		switch (choice)
		{
		
		case 'a':
			printR(num);
			printI(num);
			printF(num);
			break;
		case 'r':
			printR(num);
			break;
		case 'i':
			printI(num);
			break;
		case 'f':
			printF(num);
			break;
		case 'q':
			quit = true;
			break;
			
		}
		}
		while (!quit);
		System.out.println("Goodbye and thanks for your time!");
	}
	
	static long recursion(int n)	//O(N^2) 
	{
		if (n <= 0) return 0;
		else if (n == 1) return 1;
		else return recursion(n-1) + recursion(n-2);
		
	}
	
	static long loop(int n)			//O(N)
	{
		long n1 = 0, n2 = 1, n3 = 0; int count = 1;
		while (count < n)
		{
			n3 = n2 + n1; 
			n1 = n2;
			n2 = n3; 
			count++;
		}
		return n3;
	}
	
	static long formula(int n)		//O(N log N) (due to exponentiation) ???
	{
		double phi = 1.61803398875; double phiHat = -0.61803398875; long ans = 0;
		double temp;
		temp = (Math.pow(phi, n)) - (Math.pow(phiHat, n));
		temp = temp/Math.sqrt(5);
		ans = Math.round(temp);
		return ans;

	}

	static void greet()
	{
		System.out.println("Welcome to the Fibonacci calculator!");
		
		System.out.println("This program exists to compare the amount of time"
				+ " it takes for a computer to calculate a fibonacii number"
				+ " with different time complexeties!");
	}
	
	static char menu()
	{
		Scanner in = new Scanner(System.in); char choice;
		System.out.println("Which calculation method would you like to see?");
		System.out.println("a/A - All");
		System.out.println("r/R - Recursive"); System.out.println("i/I - Iterative");
		System.out.println("f/F - Formulaic"); System.out.println("q/Q - Quit");
		choice = in.next().charAt(0);
		Character.toLowerCase(choice);
		while (choice != 'a' && choice != 'r' && choice != 'i' && choice != 'f' && choice != 'q')
		{
			System.out.println("Please enter a valid menu option");
			System.out.println("a/A - All");
			System.out.println("r/R - Recursive"); System.out.println("i/I - Iterative");
			System.out.println("f/F - Formulaic"); System.out.println("q/Q - Quit");
			choice = in.next().charAt(0);
			Character.toLowerCase(choice);
		}
		return choice;
		
	}

	static int number()
	{
		Scanner in = new Scanner(System.in); int num;
		System.out.println("Which fibonachii number would you like to calculate?");
		num = in.nextInt();
		
		while (num <= 0)
		{
			System.out.println("Please enter a positive integer.");
			num = in.nextInt();
		}
		
		return num;
	}
	
	static void printR(int num)
	{		
		long startTime, endTime, elapsed;

		startTime = System.nanoTime();
		System.out.print("The answer using the recursive method is: "
				+ recursion(num));
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.println(" and it took " + elapsed + " nano seconds to run");
	}

	static void printI(int num)
	{
		long startTime, endTime, elapsed;

		startTime = System.nanoTime();
		System.out.print("The answer using the iterative method is: "
				+ loop(num));
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.println(" and it took " + elapsed + " nano seconds to run");
	}

	static void printF(int num)
	{
		long startTime, endTime, elapsed;

		startTime = System.nanoTime();
		System.out.print("The answer using the formulaic method is: "
				+ formula(num));
		endTime = System.nanoTime();
		elapsed = endTime - startTime;
		System.out.println(" and it took " + elapsed + " nano seconds to run");
	}
}
