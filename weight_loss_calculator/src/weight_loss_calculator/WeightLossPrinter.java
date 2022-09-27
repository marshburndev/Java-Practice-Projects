package weight_loss_calculator;

/*This is a simple weight loss calculator.  This is generally all you need to know to lose weight.
It is important to note that this is does not account for the quality 
of food one actually consumes, quality of food plays a big role in maintaining proper health. 
However this is an excellent starting point to get an approximation of 
how many calories one may need to consume in one day to lose weight.*/

import java.util.Scanner;

public class WeightLossPrinter {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Person user;
		int age;
		int heightInches;
		int weightPounds;
		double BMI;
		double BMR;
		String selection;
		boolean loopRelay = true;
		
		System.out.println("What is your age?");
		age = scnr.nextInt();
		System.out.println("What is your height in inches?");
		heightInches = scnr.nextInt();
		System.out.println("What is your weight in pounds?");
		weightPounds = scnr.nextInt();
		user = new Person(age, heightInches, weightPounds);
		
		
		BMR = Math.round(WeightLossCalculator.calculateBMR(user.getAge(), user.getHeight(), user.getWeight()));
		BMI = Math.round(WeightLossCalculator.calculateBMI(user.getHeight(), user.getWeight()));
		
		while(loopRelay) {
			
			WeightLossCalculator.showActivityOptions();
			selection = scnr.next();
			WeightLossCalculator.calculateTDEE(BMR, BMI, selection);
			loopRelay = false;
		}
		scnr.close();
	}

}

