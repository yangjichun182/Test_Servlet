package com.jichun.myconcern;

import org.junit.Test;

public class MyArray {
	int arr[] = { 1, 2, 3, 4 };
    int arr1[] ={5,6,7};
    /**
     * 遍历数组
     */
	@Test
	public void scan() {
       for(int i=0;i<=arr.length;i++){
    	   System.out.println(i);
       }
	}
	
	@Test
	public void test_array(){
		 int arr3[] = new int[8];
		 int arr4[] ={1,2,3,4};
		 System.arraycopy(arr4, 0, arr3, 0, 3);
		 for(int i=0;i<=arr3.length-1;i++){
			 System.out.println(arr3[i]);;
		 }
	}
}
