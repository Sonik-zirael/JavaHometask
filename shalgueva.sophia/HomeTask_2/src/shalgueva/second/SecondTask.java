package shalgueva.second;

public class SecondTask {

	public static void main(String[] args) {
		try {
			Notepad notes = new Notepad();
			notes.addNote();
			notes.addNote();
			notes.removeNote();
			notes.addNote();
			notes.showAllNotes();
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

}
