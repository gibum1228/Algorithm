// 201814066 ����
package hw;

import java.util.Scanner;

public class ArrayCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a[] = new int [100]; // ũ�Ⱑ 100�� �� ���� �迭 ����
		int b[] = new int [100];
		int aSize = 100, bSize = 100; // ���� �Է� ���� �迭 ũ�⸦ �˱� ���� ����
		boolean same = false; // �� ���Ҹ� ������ �� ������ true, ���� ������ false
		System.out.println("hw0_2: ����");
		System.out.println("���� ���� ������ ���ϴ� ���α׷��Դϴ�.");
		
		System.out.print("\nù��° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ���: "); // ù��° �迭 �Է¹ޱ�
		for(int i = 0; i < 100; i++) {
			int inputN = sc.nextInt();
			if(inputN <= 0) { // ���� ������ �ƴ� ���� �Է� �޾��� ��� �Է� ����
				aSize = i;
				break;
			}else {
				a[i] = inputN;
			}
		}
		System.out.print("�ι�° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ���: "); // �ι�° �迭 �Է¹ޱ�
		for(int j = 0; j < 100; j++) {
			int inputN = sc.nextInt();
			if(inputN <= 0) { // ���� ������ �ƴ� ���� �Է� �޾��� ��� �Է� ����
				bSize = j;
				break;
			}else {
				b[j] = inputN;
			}
		}
		
		// �� ������ ũ�Ⱑ ������ ���ٰ�� ��ð� �Ǿ� ���� ����
		if(aSize != bSize) { // �� ������ ũ�Ⱑ �ٸ� ���
		}else {
			for(int k = 0; k < aSize; k++) { // �� ������ ũ�Ⱑ ���� ��� ���� ��
				same = false;
				for(int l = 0; l < bSize; l++) { // �� ������ ���Ҹ� �ϳ� �ϳ� ���ϱ�
					if(a[k] == b[l]) { // ������ same�� true�� �ٲٰ� ���� ���Ҹ� �������� ���ϱ�
						same = true;
						break;
					}
				}
				
				if(!(same)) { // ���� ���Ұ� ���� ��� �ݺ��� ����
					break;
				}
			}
		}
		
		if(same) {
			System.out.println("�� ������ �����ϴ�.");
		}else {
			System.out.println("�� ������ ���� �ʽ��ϴ�.");
		}
		
		sc.close();
	}

}
