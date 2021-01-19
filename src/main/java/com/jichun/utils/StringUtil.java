package com.jichun.utils;

/**
 * 
 * @author jichun
 *
 */
public class StringUtil {
	/**
	 * 输出字符串的所有组合
	 * 
	 * @param c
	 * @param begin
	 * @param len
	 * @param sb
	 */
	public static void combineRecursive(char[] c, int begin, int len, StringBuffer sb) {

		if (len == 0) {
			System.out.println(sb + " ");
			return;
		}

		if (begin == c.length)
			return;
		sb.append(c[begin]);
		combineRecursive(c, begin + 1, len - 1, sb);
		sb.deleteCharAt(sb.length() - 1);
		combineRecursive(c, begin + 1, len, sb);

	}

	// O(n^2)
	/**
	 * 删除字符串中重复的元素 2020-01-31 16:20
	 * 
	 * @param str
	 * @return
	 */
	public static String removeDuplicate(String str) {

		char[] cs = str.toCharArray();
		int n = cs.length;

		for (int i = 0; i < n; i++) {

			if (cs[i] == '\0')
				continue;

			for (int j = i + 1; j < n; j++) {

				if (cs[j] == '\0')
					continue;
				if (cs[i] == cs[j])
					cs[j] = '\0';
			}
		}

		int be = 0;
		for (int i = 0; i < n; i++) {
			if (cs[i] != '\0')
				cs[be++] = cs[i];
		}

		return new String(cs, 0, be);
	}

	// 方法二： O(n)
	/**
	 * 删除字符串中重复的元素
	 * 
	 * @param str
	 * @return
	 */
	public static String removeDuplicate2(String str) {

		char[] cs = str.toCharArray();
		int n = cs.length;

		int count[] = new int[256];
		for (int i = 0; i < cs.length; i++) {
			if (count[cs[i]] != 0)
				cs[i] = '\0';
			count[cs[i]]++;
		}

		int be = 0;
		for (int i = 0; i < n; i++) {
			if (cs[i] != '\0')
				cs[be++] = cs[i];
		}

		return new String(cs, 0, be);
	}

	// O(n)
	/**
	 * 
	 * <pre>
	 * 2020-01-31 16:28
	 * 字符串中单词的统计 ,
	 * 给定一段空格分开的字符串，判断单词的个数
	 * </pre>
	 * 
	 * @param str
	 * @return
	 */
	public static int wordCount(String str) {

		int word = 0;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ')
				word = 0;
			else if (word == 0) {
				word = 1;
				count++;
			}
		}

		return count;
	}
}
