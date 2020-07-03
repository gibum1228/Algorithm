/*
 * ���ϸ�: TopologicalSort.java
 * �ۼ���: ����
 * �ۼ���: 2020.06.08.
 * ����: ���� ���� �˰��� 2 ������ ����� �����ϱ�
 */
package hw;

import java.util.Scanner;

public class TopologicalSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw10_2 : ����\n");
		
		System.out.println("���� ������ �����մϴ�. DAG�� �Է��ϼ���.");
		System.out.print("���� �� �Է�: ");
		int v = sc.nextInt(); // ���� �� �Է�
		DirectedGraph dG = new DirectedGraph(v); // �׷��� ����
		System.out.print("���� �� �Է�: ");
		int e = sc.nextInt(); // ���� �� �Է�
		System.out.println();
		
		System.out.println(e + "���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for(int i = 1; i <= e; i++) {
			System.out.print("���� " + i + " �Է�: ");
			
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			dG.addEdge(v1, v2);
		}
		System.out.println();
		
		dG.printAdjacencyList(); // �׷��� ��� ���
		System.out.println();
		
		dG.printTS(); // ���� ���� ���
		
		sc.close();
	}

}
