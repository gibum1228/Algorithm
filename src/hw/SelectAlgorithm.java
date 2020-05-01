/*
 * ���ϸ�: SelectAlgorithm.java
 * �ۼ���: ����
 * �ۼ���: 2020.04.20.
 * ����: ���� �˰����� �̿��� �迭���� �߾Ӱ��� ������ ã�� ���α׷�
 */
package hw;

import java.util.Scanner;

public class SelectAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw5_1: ����\n");
		System.out.print("���� ���� �Է�: ");
		int size = sc.nextInt(); // ���� ����
		int[] numList = new int [size]; // size���� �迭 ����
		System.out.print(size + "���� ���� �Է�: ");
		for(int i = 0; i < size; i++) {
			numList[i] = sc.nextInt();
		}
		
		int centerIndex; // �߾Ӱ� �ε���
		if(size % 2 == 0) {
			centerIndex = size / 2;
		}else {
			centerIndex = size / 2 + 1;
		}
		
		System.out.println("�߾Ӱ�: " + select(numList, 0, numList.length - 1, centerIndex));
		
		sc.close();
	}
	
	// ��� ���� �ð� ���� �˰���
	static int select(int[] A, int p, int r, int i) {
		if(p == r) { // �迭 ũ�Ⱑ 1�� ���
			return A[p];
		}
		int q = partition(A, p, r); // �迭 ������ ���� ��
		int k = q - p + 1; // q�� �� ��°�� ���� ���������� ���ϱ� ���� ����
		
		if(i < k) {
			return select(A, p, q-1, i); // ���� ������ ����
		}else if(i == k) {
			return A[q]; // ���ذ��� �߾Ӱ�
		}else {
			return select(A, q+1, r, i-k); // ������ ������ ����
		}
	}
	
	static int partition(int[] A, int p, int r) {
		int x = A[r]; // ���� ���Ұ�
		int i = p - 1; // ���� ���Һ��� �۰ų� ���� ������ ������
		for(int j = p; j < r; j++) { // j�� �������� ���� ������ ������
			if(A[j] <= x) { // ���� ���� ���� ������ �۰ų� ������
				int tmp = A[++i]; // �۰ų� ���� ���� +1
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		
		// ���� ���ҿ� ���� ���Һ��� ū ������ �ִ� ù ���ҿ� ��ȯ
		int tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		
		// ���� ���� �ε��� ����
		return i + 1;
	}

}
