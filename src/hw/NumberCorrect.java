// 201814066 ����
package hw;

import java.util.Scanner;

public class NumberCorrect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int intList[] = {-30, -15, 1, 40, 50, 200, 315, 800, 900, 12345}; // ���� �迭
		System.out.println("hw0_1 : ����");
		System.out.println("���� ���߱� ���α׷��Դϴ�.");
		System.out.print("�ϳ��� �������� �Է��ϼ��� : ");
		int inputN = sc.nextInt();
		int score = 100; // ����
		
		for(int i = 0; i < intList.length; i++) {
			if(inputN == intList[i]) { // ���� �������� �ֱ� ������ 100��
				break;
			}else if(i == 0){ // �Է¹��� ���� -30���� ���� ���
				if(inputN < intList[i]) {
					score = score - (intList[0] - inputN);
					break;
				}
			}else {
				if(inputN < intList[i]) { // ����� ���� ã�� ������ ���
					if(inputN - intList[i-1] < intList[i] - inputN) { // ���� �������� �� ����� ���
						score = score - (inputN - intList[i-1]);
					}else {
						score = score - (intList[i] - inputN); // ������ �������� �� ����� ���
					}
					break;
				}
			}
		}
		
		if(score < 0) { // 100 �̻� ���̳��� 0��
			score = 0;
		}
		
		System.out.println("���� = " + score);
		
		sc.close();
	}

}
