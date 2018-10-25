package shalgueva.fourth;

public class YellowSubmarine {
	public int crew_ = 0;
	
	public YellowSubmarine(int crew) {
		crew_ = crew;
	}
	
	void swim() {
		SubmarineEngine engine = new SubmarineEngine();
		engine.powerOn(crew_);
	}
	
	class SubmarineEngine {
		void powerOn(int crew) {
			if (crew < 0) {
				throw new IllegalArgumentException ("Not enough people :( ");
			} 
			if (crew > 1 && crew < 10 ) {
				System.out.println("We all live in a yellow submarine");
			} else {
				System.out.println("And our friends are all aboard");
			}
		}
	}
}
