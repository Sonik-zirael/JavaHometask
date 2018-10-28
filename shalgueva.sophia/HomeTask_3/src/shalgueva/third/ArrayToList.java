package shalgueva.third;

import java.util.ArrayList;

public class ArrayToList<T> {
	public ArrayList<T> makeArrayList(T[] a) {
		ArrayList<T> retList = new ArrayList<T>();
        for (T i : a){ 
            retList.add(i); 
        }
        return retList;
	}
	
	public void printList (ArrayList<T> tmpList) {
		for (int i=0; i < tmpList.size(); i++) {
			System.out.println(tmpList.get(i));
		}
	}
}
