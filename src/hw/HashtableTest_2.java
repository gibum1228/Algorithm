/*
 * ���ϸ�: HashtableTest_2.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.14.
 * ����: <�л�-����>�� �����ϴ� �ؽ� ���̺��� �̿��ϴ� ���α׷�
 */
package hw;

import java.util.Scanner;

public class HashtableTest_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw7_2: ����\n");
		// �ؽ����̺� ũ�� �Է�
		System.out.print("�ؽ����̺� ũ�� �Է�: ");
		int size = sc.nextInt();
		// �ؽ����̺� ����
		Hashtable_2 studentTable = new Hashtable_2(size);
		
		// ���๮
		int op = 0;
		int sNum;
		int grade;
		do {
			System.out.print("\n1:���� 2:�˻� 3:���� 4:���̺� ��� 5:���� ---> ");
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				System.out.print("������ <�й�(����), ����(����)>�� �Է��ϼ���(<ex> 1 3): ");
				sNum = sc.nextInt();
				grade = sc.nextInt();
				
				if(studentTable.put(sNum, grade)) {
					System.out.println(sNum + " �л��� ���� ���� ����");
				}else {
					System.out.println(sNum + " �л��� ���� ���� ����");
				}
				
				break;
			case 2:
				System.out.print("������ �ñ��� �л��� �й�(������)�� �Է��ϼ���: ");
				sNum = sc.nextInt();
				
				System.out.println(sNum + "�� ����: " + studentTable.get(sNum));
				
				break;
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				sNum = sc.nextInt();
				
				if(studentTable.remove(sNum)) {
					System.out.println(sNum + " ���� ����");
				}else {
					System.out.println(sNum + " ���� ����");
				}
				
				break;
			case 4:
				studentTable.print();
				
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				
				break;
			default:
				System.out.println("�޴� ��ȣ�� �߸��Ǿ����ϴ�. �ٽ� �Է��ϼ���.");
			}
		}while(op != 5);
		
		sc.close();
	}

}
