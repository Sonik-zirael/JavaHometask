package shalgueva.fourth;

public class FourthTask {

	public static void main(String[] args) {
		try {
			YellowSubmarine submarine = new YellowSubmarine(5);
			submarine.swim();
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
