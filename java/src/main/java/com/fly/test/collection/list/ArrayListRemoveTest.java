package com.fly.test.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListRemoveTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("shanghai");
		list.add("guangzhou");
		list.add("shenzhen");
		list.add("hangzhou");
		remove13(list, "shanghai");
	}
	
	private static void print(List<String> list){
		for (String item : list) {
			System.out.println("元素值：" + item);
		}
	}

	/*
	 * 错误
	 */
	public static void remove11(List<String> list, String target){
		int size = list.size();
		for(int i = 0; i < size; i++){
			String item = list.get(i);
			if(target.equals(item)){
				list.remove(item);
			}
		}
		print(list);
	}
	/*
	 * 错误
	 */
	public static void remove12(List<String> list, String target){
		for(int i = 0; i < list.size(); i++){
			String item = list.get(i);
			if(target.equals(item)){
				list.remove(item);
			}
		}
		print(list);
	}
	/*
	 * 正确
	 */
	public static void remove13(List<String> list, String target){
		int size = list.size();
		for(int i = size - 1; i >= 0; i--){
			String item = list.get(i);
			if(target.equals(item)){
				list.remove(item);
			}
		}
		print(list);
	}
	/*
	 * 正确
	 */
	public static void remove14(List<String> list, String target){
		for(int i = list.size() - 1; i >= 0; i--){
			String item = list.get(i);
			if(target.equals(item)){
				list.remove(item);
			}
		}
		print(list);
	}
	
	/*
	 * 错误
	 */
	public static void remove21(List<String> list, String target){
		for(String item : list){
			if(target.equals(item)){
				list.remove(item);
			}
		}
		print(list);
	}
	
	/*
	 * 正确
	 */
	public static void remove22(ArrayList<String> list, String target) {
		final CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<String>(list);
		for (String item : cowList) {
			if (item.equals(target)) {
				cowList.remove(item);
			}
		}
		print(cowList);
	}
	
	/*
	 * 错误
	 */
	public static void remove31(List<String> list, String target){
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (item.equals(target)) {
				list.remove(item);
			}
		}
		print(list);
	}
	/*
	 * 正确
	 */
	public static void remove32(List<String> list, String target){
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String item = iter.next();
			if (item.equals(target)) {
				iter.remove();
			}
		}
		print(list);
	}
	
	@Test
	public void testArrayListRemove() {
		ArrayList<String> al = new ArrayList<String>();
	    al.add("a");
	    al.add("b");
	    al.add("b");
	    al.add("c");
	    al.add("d");

	    for (int i = 0; i < al.size(); i++) {
	        if (al.get(i) == "b") {
	            al.remove(i);
	            i--;
	        }
	    }
	}
	
	@Test
	public void testArrayListRemove2() {
		ArrayList<String> al = new ArrayList<String>();
	    al.add("a");
	    al.add("b");
	    al.add("b");
	    al.add("c");
	    al.add("d");

	    for (String s : al) {
	        if (s.equals("a")) {
	            al.remove(s);
	        }
	        
            System.out.println("s:" + s +"-----al:" + al);
	    }
	}
	
	@Test
	public void testArrayListRemove3() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.add("b");
		al.add("c");
		al.add("d");

		Iterator<String> iter = al.iterator();
		while (iter.hasNext()) {
		    if (iter.next().equals("a")) {
		        iter.remove();
		    }
		}
	}

}


