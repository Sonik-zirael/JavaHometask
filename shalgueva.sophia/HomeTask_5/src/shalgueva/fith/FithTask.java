package shalgueva.fith;

public class FithTask {

	public static void main(String[] args) {
		try {
			YellowSubmarine submarine = new YellowSubmarine(5);
			Class tmpSub = submarine.getClass();
			CrewInfo inf = (CrewInfo)tmpSub.getAnnotation(CrewInfo.class);
			 
			System.out.println(inf.shipCaptain());
			
			submarine.swim();
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
