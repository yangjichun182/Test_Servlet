package com.pactera.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.pactera.domain.User;

public class ApiTest extends B{
	
	public ApiTest() {
	}

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("sadg");
		list.add("kfkgh");
		System.out.println(list.get(1));
		scanList(list);
	}
	
	public static  void scanList(List<String> list){
		for(int i=0;i<list.size();i++){
			String str = list.get(i);
			System.out.println(str);
		}
	}
	
	/**
	 * Map数组的遍历方式2
	 * @param map
	 */
	public static void scanMap1(Map<String, String> map) {
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"==="+value);
		}
	}

	/**
	 * 遍历map集合
	 * 
	 * @param map
	 */
	public static void scanMap(Map<String, String> map) {
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		String val = "";
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + "====" + value);
		}
	}

	/**
	 * 打印99乘法表
	 * 
	 * @param n
	 */
	public static void print99(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 比较两个数的大小，返回较大的值
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getMax(int x, int y) {
		return (x > y) ? x : y;
	}

	/**
	 * 获取三个数的最大值
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static int getMax(int x, int y, int z) {
		int max = getMax(x, y);
		return getMax(max, z);
	}

	/**
	 * 编写一个Java程序在屏幕上输出1！+2！+3！+……+10！的和。
	 * 
	 * @param n
	 * @return sum
	 */
	public static int getSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += getFactorial(i);
		}
		return sum;
	}

	/**
	 * 求n的阶乘 输出:n! ==n*(n-1)....1
	 * 
	 * @param n
	 * @return
	 */
	public static int getFactorial(int n) {

		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	/**
	 * 判断是否为闰年 1、普通年能被4整除；且不能被100整除的为闰年。（如2004年就是闰年，1901年不是闰年）
	 * 2、世纪年能被400整除的是闰年。(如2000年是闰年，1900年不是闰年)
	 * 
	 * @param year
	 *            输入的年份
	 */
	public static void leap(int year) {
		if (((year % 100 != 0) && (year % 4 == 0))
				|| ((year % 100 == 0) && (year % 400 == 0))) {
			System.out.println(year + ":是闰年");
		} else {
			System.out.println(year + ":不是闰年");
		}
	}

	@Test
	public void max_array() {
		int[] arr = new int[] { 7, 5, 9, 12, 3 };
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}

	@Test
	public void test_array() {
		System.out.println(myTrim("   dsfghj     "));
		System.out.println("sadg".charAt(3));
	}

	/*
	 * 去除字符串两边的空格的方法 "   dsfghj     "
	 */
	public String myTrim(String str) {
		int len = str.length();
		int start = 0;
		int end = len;
		while (start <= len && (str.charAt(start) == ' ')) {
			start++;
		}
		while (start <= end && (str.charAt(end - 1) == ' ')) {
			end--;
		}
		return str.substring(start, end);
	}

	@Test
	public void test1() {
		String str = "12356788";
		char[] charArray = str.toCharArray();
		for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
		}
		System.out.println(new String(charArray));
	}

	/**
	 * 功能：将字符串翻转
	 * 
	 * @param str
	 * @return
	 */
	public String reverse(String str) {
		char[] charArray = str.toCharArray();
		reverseArray(charArray);

		return new String(charArray);
	}

	/**
	 * 数组元素交换
	 * 
	 * @param arr
	 */
	public void reverseArray(char[] arr) {

		int x = 0;
		int y = arr.length - 1;
		for (; x < y; x++, y--) {
			char temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}
	}

	@Test
	public void testtransient() {
		User user = new User();
		user.setUsername("Alexia");
		user.setPasswd("123456");

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPasswd());

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("D:\\user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
					"D:\\user.txt"));
			user = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user.getUsername());
			System.err.println("password: " + user.getPasswd());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= n; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
