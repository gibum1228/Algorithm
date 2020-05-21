/*
 * ���ϸ�: HashtableTest.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.08.
 * ����: �ؽ����̺��� ����Ͽ� �й��� �����ϴ� ���α׷�
 */
package hw;

import java.util.Scanner;

public class HashtableTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw7_1: ����\n");
		// �ؽ����̺� ũ�� �Է�
		System.out.print("�ؽ����̺� ũ�� �Է�: ");
		int size = sc.nextInt();
		// �ؽ����̺� ����
		Hashtable studentTable = new Hashtable(size);
		
		// ���๮
		int op = 0;
		int sNum;
		do {
			System.out.print("\n1:���� 2:�˻� 3:���� 4:���̺� ��� 5:���� ---> ");
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				sNum = sc.nextInt();
				
				if(studentTable.put(sNum)) {
					System.out.println(sNum + " ���� ����");
				}else {
					System.out.println(sNum + " ���� ����");
				}
				
				break;
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���: ");
				sNum = sc.nextInt();
				
				if(studentTable.contains(sNum)) {
					System.out.println(sNum + " �л��� ã�ҽ��ϴ�.");
				}else {
					System.out.println(sNum + " �л��� ã�� �� �����ϴ�.");
				}
				
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
