package shalgueva.second;

import java.util.ArrayList;
import java.util.Scanner;

public class Notepad {
	public ArrayList<NoteInNotepad> arrayOfNotes_ = new ArrayList<NoteInNotepad>();
	
	public void addNote() {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int age = scan.nextInt();
		double salary = scan.nextDouble();
		arrayOfNotes_.add(new NoteInNotepad(name, age, salary));
		scan.close();
	}
	
	public void removeNote() {
		Scanner scan = new Scanner(System.in);
		int index = scan.nextInt();
		scan.close();
		if (index > 0 || index <= arrayOfNotes_.size()) {
			arrayOfNotes_.remove(index);
		} else {
			throw new IllegalArgumentException ("Index is out of range");
		}		
	}
	
	public void changeNote() {
		Scanner scan = new Scanner(System.in);
		int index = scan.nextInt();
		System.out.println("Enter new values");
		String name = scan.nextLine();
		int age = scan.nextInt();
		double salary = scan.nextDouble();
		NoteInNotepad tmp = new NoteInNotepad(name, age, salary);
		scan.close();
		if (index > 0 || index <= arrayOfNotes_.size()) {
			arrayOfNotes_.remove(index);
		} else {
			throw new IllegalArgumentException ("Index is out of range");
		}	
		arrayOfNotes_.set(index, tmp);		
	}
	
	public void showAllNotes() {
		for (int i = 0; i < arrayOfNotes_.size(); i++) {
			System.out.println(arrayOfNotes_.get(i));
		}
	}
}
