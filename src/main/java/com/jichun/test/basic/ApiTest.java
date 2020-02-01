package com.jichun.test.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.jichun.domain.User;
import com.jichun.utils.DateUtils;
import com.jichun.utils.StringUtil;

public class ApiTest {

	public ApiTest() {

	}
	
	//测试获取当前时间
	@Test
	public void test_2020_0201_2230() {
		System.out.println(DateUtils.getCurrentDate2("yyyy-MM-dd HH:mm:ss"));
	}

	//测试格式化日期格式
	@Test
	public void test_2020_0201_2219() {
		Date date = new Date();
		String pattern="yyyy/MM/dd HH:mm:ss SSS";
		String format = DateUtils.format(date, pattern);
		System.out.println(format);
	}

	// 测试获取日期的月份
	@Test
	public void test_2020_0131_2340() {
		@SuppressWarnings("deprecation")
		Date date = new Date();
		System.out.println(date.toString());
		String month = DateUtils.getMonth(date);
		System.out.println(month);
	}

	// 测试获取每年的第一天
	@Test
	public void test_2020_0131_2332() {
		String firstDayOfYear = DateUtils.getFirstDayOfYear(-2020);
		System.out.println(firstDayOfYear);
	}

	// 测试获取每个月的第一天日期
	@Test
	public void test_2020_0131_2316() {
		String fistDayOfMonth = DateUtils.getFirstDayOfMonth(2021, 4);
		System.out.println(fistDayOfMonth);
	}

	// 统计单词的个数
	@Test
	public void test_2020_0131_1629() {
		String str = "i am a good boy";
		System.out.println(StringUtil.wordCount(str));
	}

	// 去除字符串中的你重复值
	@Test
	public void test_2020_0131_1617() {
		String str = "aaabbbcdef";
		String removeDuplicate2 = StringUtil.removeDuplicate2(str);
		System.out.println(removeDuplicate2);
	}

	@Test
	public void test_2020_0131_1519() {
		String s = "abcd";
		char[] cs = s.toCharArray();
		StringBuffer sb = new StringBuffer();

		for (int j = 1; j < cs.length; j++) {
			StringUtil.combineRecursive(cs, 0, j, sb);
		}
	}

	@Test
	public void test_20181218() {
		System.out.println(System.currentTimeMillis());
	}

	/**
	 * Func:测试foreach Date：20181213 20:40
	 */
	@Test
	public void test_for_20181213() {
		String[] str = new String[] { "张三丰", "张无忌", "张铁林" };
		for (String i : str) {
			System.out.println(str);// 这样输出的是str这个对象的地址
			System.out.println(i);// 这样输出的是数组中的每一个值
		}
	}

	/**
	 * 三元运算符测试：a == null ?1:0 这条语句转化为正常的if语句就是 如果a的值是 null 那么就等于 1 不为空的话就等于0
	 */
	@Test
	public void test_20181022() {
		String a = null;// 局部变量jvm不会赋予默认值，必须初始化
		Object b = new String[] { "dfh" };
		System.out.println(a == null ? 1 : 0);// 输出1
		System.out.println(b == null ? 1 : 0);// 输出0
	}

	@Test
	public void test_20181029() {
		int key = 0;
		switch (key) {
		case 1:
			System.err.println("Mom!");
			break;
		case 2:
			System.out.println("Tue");
			break;
		default:
			System.out.println("null");
			break;
		}
	}

	/**
	 * @author pactera 20180910
	 */
	@Test
	public void test_20180919() {
		int a = 10;
		int b, c, d, e;
		b = a--;
		c = --a;
		d = a++;
		e = ++a;
		System.out.println("b=" + b); // b多少？
		System.out.println("c=" + c); // c多少？
		System.out.println("d=" + d);
		System.out.println("e=" + e);
		System.out.println(a++);
		System.out.println(++a);
		System.out.println(a--);
		System.out.println(--a);
	}

	@Test
	public void test2() throws IOException, SQLException {
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add("dsfh");
		arrayList.add("dfh");
		Object[] array = arrayList.toArray();
		/*
		 * for(int i=0;i<array.length;i++){ System.out.println(array[i]); }
		 */

		for (Object i : array) {
			System.out.println(i);
		}

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

	/**
	 * List遍历
	 * 
	 * @param list
	 */
	public static void scanList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
	}

	/**
	 * Map集合遍历
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
	 * Map集合的遍历
	 * 
	 * @param map
	 */
	public static void scanMap(Map<String, String> map) {
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
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
	 * 获取最大值
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int getMax(int x, int y) {
		return (x > y) ? x : y;
	}

	/**
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
	 * 判断闰年
	 * 
	 * @param year
	 */
	public static void leap(int year) {
		if (((year % 100 != 0) && (year % 4 == 0)) || ((year % 100 == 0) && (year % 400 == 0))) {
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
			os.writeObject(user); //
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:\\user.txt"));
			user = (User) is.readObject();
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
