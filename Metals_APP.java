package metals_app;

import java.util.Scanner;
import java.io.PrintStream;

public class Metals_APP {
	static Scanner usin = new Scanner(System.in);
	
	//Created a conversion function
	static double FromCelcius (double temp) {
		double answer = (9.0/5)* temp + 32;
		return answer;
	}
	
	//Function to create the metal table
	static String[][] CT_metal_table (int row_metals){
		//Defining the variables
		PrintStream so = System.out;
		
		String[][] metals_table = new String[row_metals][5];
		
		String M_name, Density, hardness;
		double melt = 0, boil = 0;
		
		//Created a for loop to fill in the table
		for(int i = 0; i < row_metals; i++) {
			//Manually inserting the headers
			if(i==0) {
				metals_table[i][0] = "Metal";
				metals_table[i][1] = "Density (g/cm\u00b3)";
				metals_table[i][2] = "Melting point (\u00B0F)";
				metals_table[i][3] = "Boiling point (\u00B0F)";
				metals_table[i][4] = "Hardness";
			}
			//The user places the values into the table
			else {
				so.print("Enter Name of Metal: ");
				M_name = usin.next();
				so.print("Enter Density(g/cm\u00b3) of " + M_name + ": ");
				Density = usin.next();
				so.print("Enter Melting Point(\u00b0C) of " + M_name + ": ");
				melt = FromCelcius(usin.nextDouble());
				so.print("Enter Boiling Point(\u00b0C) of " + M_name + ": ");
				boil = FromCelcius(usin.nextDouble());
				so.print("Enter Hardness(1-10) of "+ M_name + ": ");
				hardness = usin.next();
				
				//Inserting the values into the correct column
				metals_table[i][0] = M_name;
				metals_table[i][1] = Density;
				metals_table[i][2] = Double.toString(melt);
				metals_table[i][3] = Double.toString(boil);
				metals_table[i][4] = hardness;
			}
		}
		//Returning the table
		return metals_table;
	}
	
	//Created a function to print the metals table
	static void print_table(String[][] m_table, int rows) {
		PrintStream so = (System.out);
		
		//Iterating the rows
		for(int i = 0; i < rows; i++) {
				so.printf("\n\n%s : %s : %s : %s : %s \n", m_table[i][0], m_table[i][1], m_table[i][2], m_table[i][3], m_table[i][4]);
		}
	}
	
	public static void main(String[] args) {
		//Created variables
		PrintStream so = System.out;
		
		String[][] toPrintTable; 
		int num_metals = 0;
		
		//Creating the Metal's table which the rows are defined by the user
		so.print("Enter the quantity of metals that are being entered into the system: ");
		num_metals = usin.nextInt();
		//Sending the total number of metals to the function and retrieving the table
		toPrintTable = CT_metal_table(num_metals+1);
		//Sending the table to the print function
		print_table(toPrintTable, num_metals+1);
		
		
	}
}
