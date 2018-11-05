package shalgueva.third;

import java.util.ArrayList;

public class ThirdTask {

	public static void main(String[] args) {
		Integer[] cats = {0, 1, 2, 7, 11};
		ArrayToList<Integer> newCats = new ArrayToList<Integer>();
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		tmpList = newCats.makeArrayList(cats);
		newCats.printList(tmpList);
		
		Tigers t1 = new Tigers("Fluffy", 7);
		Tigers t2 = new Tigers("Cotton", 3);
		Tigers[] pride = {t1, t2};
		ArrayToList<Tigers> newTigers = new ArrayToList<Tigers>();
		ArrayList<Tigers> tmpL = new ArrayList<Tigers>();
		tmpL = newTigers.makeArrayList(pride);
		newTigers.printList(tmpL);
	}
}
