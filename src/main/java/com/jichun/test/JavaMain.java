package com.jichun.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaMain {
	static String var2;

	public static void main(String[] args) {
		File fromFile = new File("D:\\\\log.txt");
		File toFile = new File("D:\\\\to.txt");
		
		try {
			fun5(fromFile,toFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fun1() {
		String var1 = "asdgl";
		System.out.println(var1 + "---" + var2);
	}

	public static void fun1(String name) {

	}

	public static void fun2() {

		for (int i = 1; i < 10; i++) {

			for (int j = 1; j < 10; j++) {
				if (j <= i) {
					System.out.print(i + "*" + j + "=" + i * j + "    ");
				}
			}
			System.out.println();
		}
	}

	public static void fun3() {
		String str[] = new String[3];
		String str1[] = { "dsfg", "dsfgt" };
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
		for (int i = 0; i <= str1.length; i++) {
			System.out.println(str1[i]);
			System.out.println(str1.length);
		}
	}

	public static void fun4() {
		int a[] = { 1, 2, 3, 7, 8 };
		for (int i : a) {
			System.out.println(i);
		}
		String str[] = new String[] { "sadg", "sdagdf" };
		for (String s : str) {
			System.out.println(s);
		}
	}

	public static void fun5(File fromFile,File toFile) throws IOException {
		FileInputStream ins = new FileInputStream(fromFile);
		FileOutputStream out = new FileOutputStream(toFile);
		byte[] b = new byte[1024];
		int n = 0;
		while ((n = ins.read(b)) != -1) {
			out.write(b, 0, n);
		}

		ins.close();
		out.close();
	}
}
