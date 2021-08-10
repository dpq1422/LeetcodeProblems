package com.dpq.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo5 {
	
	public static void main(String[] args) {
		List<CheckDomain> list = new ArrayList<>();
		
		list.add(new CheckDomain(100l,"GOC1",new Date()));
		list.add(new CheckDomain(100l,"GOC1",new Date()));
		list.add(new CheckDomain(101l,"GOC2",new Date()));
		list.add(new CheckDomain(101l,"GOC2",new Date()));
		list.add(new CheckDomain(101l,"GOC2",new Date()));
		list.add(new CheckDomain(102l,"GOC3",new Date()));
		list.add(new CheckDomain(103l,"GOC4",new Date()));
		list.add(new CheckDomain(104l,"GOC5",new Date()));
		list.add(new CheckDomain(105l,"GOC6",new Date()));
		
		System.out.println("list:"+list);
		
		//TO filter records using stream
		//Filtering out records whose run id is 101
		
		List<CheckDomain> filteredList = list.stream().filter( e-> e.getRunId()!=101l).collect(Collectors.toList());
		
		System.out.println("filteredList:"+filteredList);
		
		// to fetch list of specific attribute from list of domains
		//Fetching all gocs
		List<String> gocs = list.stream().map(CheckDomain::getGocDetails).collect(Collectors.toList());
		System.out.println("gocs:"+gocs);
		
		// Fetching all unique run ids
		Set<Long> uniqueRunIds = list.stream().map(CheckDomain::getRunId).collect(Collectors.toSet());
		System.out.println("uniqueRunIds:"+uniqueRunIds);
		
		// TO change value in list but this will update same value to all records so we will first filter and then will update
		list.stream().filter(e -> e.getGocDetails().equals("GOC1")).forEach(e -> e.setGocDetails("GOC0"));
		System.out.println("modified list:"+list);
		
		//Converting list into map based on key here we are taking run id as key
		Map<Long , List<CheckDomain>> map = list.stream().collect(Collectors.groupingBy(CheckDomain::getRunId));
		System.out.println("map:"+map);
		
		//Above operations has been performed using stream same operation can be performed using parallel stream and we can take benifits of available cores
		Map<Long , List<CheckDomain>> parallelMap = list.parallelStream().collect(Collectors.groupingBy(CheckDomain::getRunId));
		System.out.println("parallelMap:"+parallelMap);
		
		List<String> gocsUsingPStream = list.parallelStream().map(CheckDomain::getGocDetails).collect(Collectors.toList());
		System.out.println("gocsUsingPStream:"+gocsUsingPStream);
	}
	
	
	
}

class CheckDomain{
	private Long runId;
	private String gocDetails;
	private Date createdDate;
	
	public CheckDomain() {}
	
	public CheckDomain(Long runId, String gocDetails, Date createdDate) {
		super();
		this.runId = runId;
		this.gocDetails = gocDetails;
		this.createdDate = createdDate;
	}
	public Long getRunId() {
		return runId;
	}
	public void setRunId(Long runId) {
		this.runId = runId;
	}
	public String getGocDetails() {
		return gocDetails;
	}
	public void setGocDetails(String gocDetails) {
		this.gocDetails = gocDetails;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

	@Override
	public String toString() {
		return "CheckDomain [runId=" + runId + ", gocDetails=" + gocDetails + ", createdDate=" + createdDate + "]";
	}
	
	
}