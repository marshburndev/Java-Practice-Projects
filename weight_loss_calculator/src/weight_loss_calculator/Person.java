package weight_loss_calculator;

//This class creates a person object with variable necessary to make the weight loss calculator output correctly.  

public class Person {
	private int age;
	private int height;
	private int weight;
	
	public Person() { //Default constructor
		this.age = 0;
		this.height = 0;
		this.weight = 0;
	}
	
	public Person(int age, int height, int weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}


	public int getWeight() {
		return weight;
	}
}
