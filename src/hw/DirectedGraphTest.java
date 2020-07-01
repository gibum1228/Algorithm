/*
 * ���ϸ�: DirectedGraphTest.java
 * �ۼ���: ����
 * �ۼ���: 2020.06.08.
 * ����: ���� �׷����� ���� ����Ʈ�� ǥ���ϱ�
 */
package hw;

import java.util.Scanner;

public class DirectedGraphTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw10_1 : ����\n");
		System.out.print("���� �� �Է�: ");
		int v = sc.nextInt(); // ���� ��
		DirectedGraph dG = new DirectedGraph(v); // ũ�� v�� ���� ����Ʈ ����
		System.out.print("���� �� �Է�: ");
		int e = sc.nextInt(); // ���� ��
		System.out.println();
		
		System.out.println(e + "���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for(int i = 1; i <= e; i++) {
			System.out.print("����" + i + " �Է�: ");
			
			int v1 = sc.nextInt(); // ���� ��ȣ 2��
			int v2 = sc.nextInt(); 
			
			dG.addEdge(v1, v2);
		}
		
		System.out.println();
		dG.printAdjacencyList();
		
		sc.close();
	}

}
