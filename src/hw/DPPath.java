/*
 * ���ϸ�: DPPath.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.22.
 * ����: ���� ���α׷��� ��� ��� ���� 
 */
package hw;

import java.util.Scanner;

public class DPPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw8_1: ����\n");
		System.out.print("���� ũ�� �Է�: ");
		int n = sc.nextInt();
		int[][] procession = new int [n+1][n+1];
		
		System.out.println(n + " x " + n + "ũ���� ��� ���� �Է�:"); 
		for(int i = 1; i < n + 1; i++) { // array input
			for(int j = 1; j < n + 1; j++){
				int num = sc.nextInt();
				procession[i][j] = num;
			}
		}
		
		int[][] copyC = matrixPath(n, procession); // ��� ������ ����� �迭�� �ޱ�
		System.out.println("\n�ִ� ����: " + copyC[n][n]);
		System.out.print("�ִ� ���� ��� = ");
		vertexPrint(copyC);
		
		sc.close();
	}

	// ��� ������ ����� �迭�� ����� �޼ҵ�
	public static int[][] matrixPath(int n, int[][] m) {
		int[][] c = new int [n+1][n+1];
		
		// ���� 0���� �ʱ�ȭ
		for(int i = 0; i < n+1; i++) {
			c[i][0] = 0;
		}
		for(int j = 1; j < n+1; j++) {
			c[0][j] = 0;
		}
		
		// ����� �յ� ���ϱ�
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				c[i][j] = m[i][j] + Math.max(c[i-1][j], c[i][j-1]);
			}
		}
		
		return c;
	}
	
	// ��� �����ϴ� �޼ҵ�
	public static void vertexPrint(int[][] m) {
		// (n, n)�������� ������
		int i = m.length-1;
		int j = m.length-1;
		String s = "";
		
		while(true) {
			s += ")" + j + " ," + i + "("; // ��� ����

			if(i == 1 && j == 1) {
				break;
			}
			
			// ��� ����
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
		
		// s�� ����� ���
		for(int k = s.length() - 1; k >= 0; k--) {
			System.out.print(s.charAt(k));
		}
	}
}
