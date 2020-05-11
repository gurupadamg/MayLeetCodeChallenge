package com.mlcc.week1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {

	private LinkedHashMap<Integer, Employee> dataMap = null;
	private final int CAPACITY;

	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		//dataMap = new LinkedHashMap<>();
		dataMap = new LinkedHashMap<Integer, Employee>(CAPACITY, 0.75f, true) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Employee> eldest) {
				return size() > CAPACITY;
			}

		}; 
	}

	public Employee get(int key) {
		return dataMap.getOrDefault(key, null);
	}

	public void put(int key, Employee employee) {
		dataMap.put(key, employee);
	}

	public void display() {
		System.out.println("*******************************************");
		for (Map.Entry<Integer, Employee> entry : dataMap.entrySet()) {
			System.out.println(entry.getValue().empId + "::" + entry.getValue().empName);
		}
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(5);
		System.out.println("LRU Cache");
		lruCache.put(101, new Employee("101", "Alok"));
		lruCache.put(102, new Employee("102", "Bob"));
		lruCache.display();
		lruCache.get(101);
		lruCache.display();
		lruCache.put(103, new Employee("103", "C'Mon"));
		lruCache.put(104, new Employee("104", "Don"));
		lruCache.put(105, new Employee("105", "Ellon"));
		lruCache.display();
		lruCache.get(101);
		lruCache.display();
		lruCache.put(106, new Employee("106", "Fintoff"));
		lruCache.display();

	}

}

class Employee {
	String empId;
	String empName;

	Employee(String empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
}
