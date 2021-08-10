package com.dpq.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetcodeProblems {

	public static void main(String[] args) {
		System.out.println(Arrays.stream(twoSum(new int [] {2,7,11,15}, 9)).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(twoSum(new int [] {2,2,11,15}, 4)).boxed().collect(Collectors.toList()));
		System.out.println(Arrays.stream(optimizedTwoSum(new int [] {2,2,11,13}, 24)).boxed().collect(Collectors.toList()));
		
		System.out.println(addTwoNumbersfromLinkedList(Arrays.stream(new int [] {9,9,9,9,9,9,9}).boxed().collect(Collectors.toList())
		, Arrays.stream(new int [] {9,9,9,9}).boxed().collect(Collectors.toList())));
		
	}
	
	public static LinkedList<Integer> addTwoNumbersfromLinkedList(List<Integer> l1, List<Integer> l2) {
		LinkedList<Integer> result  =  new LinkedList<>();
		int carry = 0;
		
		for(int i=0 , j=0 ; i<l1.size() || j<l2.size() ; i++,j++) {
			int sum = 0;
			if(l1.size() == l2.size()) {
				sum = carry + l1.get(i) + l2.get(j);
			}else if(i>l1.size()) {
				sum = carry + l2.get(j);
			}else if(j>l2.size()) {
				sum = carry + l1.get(i) ;
			}
			
			carry = sum / 10;
			result.add(sum % 10);
		}
		if (carry > 0) {
			result.add(carry);
	    }
		return result;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    System.out.println("dummyHead.next:"+dummyHead.next);
	    System.out.println("curr.next:"+curr.next);
	    System.out.println("curr:"+curr);
	    return dummyHead.next;
	}
	
	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	public static int[] twoSum(int[] nums, int target) {
        for(int i=0 ; i < nums.length ; i++){
            for(int j=i+1 ; j < nums.length ; j++){
                if(nums[i]+nums[j] == target){
                    return new int [] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	public static int[] optimizedTwoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	       
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
