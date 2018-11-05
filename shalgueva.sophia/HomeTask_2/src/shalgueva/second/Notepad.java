package shalgueva.second;

import java.util.ArrayList;
import java.util.Scanner;

public class Notepad {
	public ArrayList<NoteInNotepad> arrayOfNotes_ = new ArrayList<NoteInNotepad>();
	
	public void addNote() {
		System.out.println("Add new note");
		System.out.println("Enter name: ");
		String name = Correctness.checkCorStr();
		System.out.println("Enter age: ");
		int age = Correctness.checkCorInt();
		System.out.println("Enter salary: ");
		double salary = Correctness.checkCorDouble();
		arrayOfNotes_.add(new NoteInNotepad(name, age, salary));
	}
	
	public void removeNote() {
		System.out.println("Enter index of note for deletion: ");
		int index = Correctness.checkCorInt();
		if (index > 0 || index <= arrayOfNotes_.size()) {
			arrayOfNotes_.remove(index);
		} else {
			throw new IllegalArgumentException ("Index is out of range");
		}		
	}
	
	public void changeNote() {
		System.out.println("Enter index of note for change: ");
		int index = Correctness.checkCorInt();
		System.out.println("Enter new values");
		System.out.println("Enter name: ");
		String name = Correctness.checkCorStr();
		System.out.println("Enter age: ");
		int age = Correctness.checkCorInt();
		System.out.println("Enter salary: ");
		double salary = Correctness.checkCorDouble();
		NoteInNotepad tmp = new NoteInNotepad(name, age, salary);
		if (index > 0 || index <= arrayOfNotes_.size()) {
			arrayOfNotes_.remove(index);
		} else {
			throw new IllegalArgumentException ("Index is out of range");
		}	
		arrayOfNotes_.set(index, tmp);		
	}
	
	public void showAllNotes(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException ("Notepad is empty");
		}
		System.out.println("Print all notes: ");
		for (int i = 0; i < arrayOfNotes_.size(); i++) {
			System.out.println(arrayOfNotes_.get(i));
		}
	}
}
