package shalgueva.second;

import java.util.Scanner;

public class SecondTask {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			Notepad notes = new Notepad();
			boolean exit = false;
			System.out.println("Choose necessary function: ");
			int amountOfNotes = 0;
			while (!exit) {
				System.out.println("1 - add note");
				System.out.println("2 - remove note");
				System.out.println("3 - change note");
				System.out.println("4 - show all notes");
				System.out.println("5 - exit");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					notes.addNote();
					amountOfNotes++;
					break;
				case 2: 
					notes.removeNote();
					amountOfNotes--;
					break;
				case 3:
					notes.changeNote();
					break;
				case 4: 
					notes.showAllNotes(amountOfNotes);
					break;
				case 5:
					exit = true;
					break;
				default: exit = true;			
				} 
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
