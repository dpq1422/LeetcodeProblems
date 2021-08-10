package com.dpq.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java8ForEachExample {

	public static void main(String[] args) {
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator Value::"+i);
		}
		
		//traversing through forEach method of Iterable with anonymous class
		myList.forEach((t) ->System.out.println("forEach anonymous class Value::"+t));
		
	}

}