package com.dpq.DS.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InterestingProblems<T> {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(100);list.add(100);list.add(100);
		list.add(200);list.add(300);list.add(100);
		InterestingProblems<Integer> obj = new InterestingProblems<>();
		//System.out.println(obj.removedElementsFromInput_1stway(list, 100));
		System.out.println(obj.removedElementsFromInput_2ndway(list, Integer.valueOf(100)));
		
	}
	
	private List<T> removedElementsFromInput_1stway(List<T> input,T data){
		
		return input.stream().filter(e -> !e.equals(data)).collect(Collectors.toList());
		
	}
	
	private List<T> removedElementsFromInput_2ndway(List<T> input,T data){
		Iterator<T> itr = input.iterator();
		while(itr.hasNext()) {
			if(data.equals(itr.next())){
				itr.remove();
			}
		}
		return input;
		
	}

}
