package com.pactera.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.pactera.domain.User;
import com.pactera.utils.JDBCOracleUtils;

public class ApiTest  {

	public ApiTest() {

	}



	@Test
	public void test2() throws IOException, SQLException {

		Connection connection = JDBCOracleUtils.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from emp");
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			String name = resultSet.getString("ename");
			System.out.println(name);
		}
		JDBCOracleUtils.close();
	}


	@Test
	public void teststring() throws IOException {

		String filename = "E:\\wifi����.txt";
		String file1 = "D:\\a.txt";
		File file = new File(filename);
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(file);
			byte b[] = new byte[1024];
			is.read(b);
			os = new FileOutputStream(file1);
			os.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("sadg");
		list.add("kfkgh");
		System.out.println(list.get(1));
		scanList(list);
	}

	public static void scanList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}

	/**
	 * Map����ı�����ʽ2
	 * 
	 * @param map
	 */
	public static void scanMap1(Map<String, String> map) {
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "===" + value);
		}
	}

	/**
	 * ����map����
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
	 * 打印99乘法口诀表
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
	 * 获取最大值ֵ
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getMax(int x, int y) {
		return (x > y) ? x : y;
	}

	/**
	 * ��ȡ�����������ֵ
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
	 * ��дһ��Java��������Ļ�����1��+2��+3��+����+10���ĺ͡�
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
	 * ��n�Ľ׳� ���:n! ==n*(n-1)....1
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
	 * �ж��Ƿ�Ϊ����
	 * 1����ͨ���ܱ�4�������Ҳ��ܱ�100������Ϊ���ꡣ����2004��������꣬1901�겻�����꣩
	 * 2���������ܱ�400�����������ꡣ(��2000�������꣬1900�겻������)
	 * 
	 * @param year
	 *            ��������
	 */
	public static void leap(int year) {
		if (((year % 100 != 0) && (year % 4 == 0)) || ((year % 100 == 0) && (year % 400 == 0))) {
			System.out.println(year + ":������");
		} else {
			System.out.println(year + ":��������");
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
	 * ȥ���ַ������ߵĿո�ķ��� "   dsfghj     "
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
	 * ���ܣ����ַ�����ת
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
	 * ����Ԫ�ؽ���
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
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:\\user.txt"));
			os.writeObject(user); // ��User����д���ļ�
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\user.txt"));
			user = (User) is.readObject(); // �����ж�ȡUser������
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
