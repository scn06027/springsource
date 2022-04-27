package com.study.calc;
/*
 * 재귀호출
 * 재귀호출: 메소드 안에서 자신의 메소드를 다시 호출한다
 * 		기본 단계와 재귀단계로 나뉜다
 */
public class Recursion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=4;
		func(num);
	}
	
	public static void func(int n) {
		if(n>0) {
			System.out.println("hello");
			func(n-1);
			//재귀단계
		}else{
			return; //기본단계
		}
		
		
		
	}
	/*
	 * void countdown(int i) { 
	 * if(i>=0) 
	 * { //기본 단계 return;
	 *  }else { countdown(i-1); }
	 * }
	 */
}
