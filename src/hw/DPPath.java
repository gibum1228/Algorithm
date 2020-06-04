/*
 * 파일명: DPPath.java
 * 작성자: 김기범
 * 작성일: 2020.05.22.
 * 내용: 동적 프로그래밍 행렬 경로 문제 
 */
package hw;

import java.util.Scanner;

public class DPPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw8_1: 김기범\n");
		System.out.print("행의 크기 입력: ");
		int n = sc.nextInt();
		int[][] procession = new int [n+1][n+1];
		
		System.out.println(n + " x " + n + "크기의 행렬 원소 입력:"); 
		for(int i = 1; i < n + 1; i++) { // array input
			for(int j = 1; j < n + 1; j++){
				int num = sc.nextInt();
				procession[i][j] = num;
			}
		}
		
		int[][] copyC = matrixPath(n, procession); // 경로 점수가 저장된 배열을 받기
		System.out.println("\n최대 점수: " + copyC[n][n]);
		System.out.print("최대 점수 경로 = ");
		vertexPrint(copyC);
		
		sc.close();
	}

	// 경로 점수가 저장된 배열을 만드는 메소드
	public static int[][] matrixPath(int n, int[][] m) {
		int[][] c = new int [n+1][n+1];
		
		// 경계면 0으로 초기화
		for(int i = 0; i < n+1; i++) {
			c[i][0] = 0;
		}
		for(int j = 1; j < n+1; j++) {
			c[0][j] = 0;
		}
		
		// 경로의 합들 구하기
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				c[i][j] = m[i][j] + Math.max(c[i-1][j], c[i][j-1]);
			}
		}
		
		return c;
	}
	
	// 경로 추적하는 메소드
	public static void vertexPrint(int[][] m) {
		// (n, n)에서부터 역추적
		int i = m.length-1;
		int j = m.length-1;
		String s = "";
		
		while(true) {
			s += ")" + j + " ," + i + "("; // 경로 저장

			if(i == 1 && j == 1) {
				break;
			}
			
			// 경로 추적
			if(i == 1) {
				j--;
			}else if(j == 1) {
				i--;
			}else {
				if(m[i-1][j] > m[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		
		// s를 뒤집어서 출력
		for(int k = s.length() - 1; k >= 0; k--) {
			System.out.print(s.charAt(k));
		}
	}
}
