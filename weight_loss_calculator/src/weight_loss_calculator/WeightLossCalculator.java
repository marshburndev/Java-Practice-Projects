package weight_loss_calculator;

//This class contains all of the methods required to run and output a weight loss calculator.

public class WeightLossCalculator {

	public static double calculateBMR(int age, int inches, int pounds) {
		double BMR;
		BMR = 66 + (6.2 * pounds) + (12.7 * inches) - (6.76 * age);
		return BMR;
	}
	
	public static double convertWeight(int pounds) {
		return pounds / 2.2;
	}
	
	public static double convertHeight(int inches) {
		return inches / 39.37;
	}
	
	public static double calculateBMI(int inches, int weight) {
		double kiloGrams;
		double meters;
		double BMI;
		
		kiloGrams = convertWeight(weight);
		meters = convertHeight(inches);
		
		BMI = kiloGrams / (meters * meters);
		return BMI;
	}
	
	public static String weightClassification(double BMI) {
		String classification = "";
		if(BMI <= 18.5) {
			classification = "Classification: Underweight";
		}
		if(BMI >= 18.5 && BMI <= 24.9) {
			classification = "Classification: Normal weight";
		}
		if(BMI >= 25 && BMI <= 29.9) {
			classification = "Classification: Overweight";
		}
		if(BMI >= 30) {
			classification = "Classification: Obese";
		}
		
		return classification;
	}
	
	public static void showActivityOptions() {
		System.out.println("What is you activity level?");
		System.out.println("1. Sedentary - minimal activity.");
		System.out.println("2. Lightly Active - minimal activity, but do some standing and moving.");
		System.out.println("3. Moderately Active - mostly standing at your job or exercizing 3x per week.");
		System.out.println("4. Very Active - physically intensive job, working out majority of the week.");
	}
	
	public static void calculateTDEE(double BMR, double BMI, String activity_level) {
		double TDEE;
		
		switch(activity_level) {
		case "1": 
			TDEE = BMR * 1.2;
			System.out.println("Your TDEE is: " + Math.round(TDEE));
			System.out.println("Your BMI is: " + BMI);
			calsToEat(TDEE);
			break;
		
		case "2":
			TDEE = BMR * 1.375;
			System.out.println("Your TDEE is: " + Math.round(TDEE));
			System.out.println("Your BMI is: " + BMI);
			calsToEat(TDEE);
			break;
			
		case "3":
			TDEE = BMR * 1.725;
			System.out.println("Your TDEE is: " +Math.round(TDEE));
			System.out.println("Your BMI is: " + BMI);
			calsToEat(TDEE);
			break;
			
		case "4":
			TDEE = BMR * 1.9;
			System.out.println("Your TDEE is: " + Math.round(TDEE));
			System.out.println("Your BMI is: " + BMI);
			calsToEat(TDEE);
			break;
			
		default:
			System.out.println("Sorry cannot compute!");
		}
	}
	
	public static void printStats(double BMI){//Test this in the AM
			System.out.println("Your TDEE is: " +Math.round(TDEE));
			System.out.println("Your BMI is: " + BMI);
	}
	
	public static void calsToEat(double TDEE) {
		double calsPerDay;
		System.out.println("Calculating weight loss...");
		System.out.println("To keep things simple, it is recommended that you start with 1 pound per week");
		System.out.println("To safely lose 1 pound per week, deduct 500 from your TDEE.");
		calsPerDay = TDEE - 500;
		System.out.println("Recommended intake per day: " + Math.round(calsPerDay));
	}
}
