/*
 * ���ϸ�: BoyerMooreHospoolTest.java
 * �ۼ���: ����
 * �ۼ���: 2020.06.20.
 * ����: ���̾�-����-ȣ��Ǯ �˰��� ����
 */
package hw;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BoyerMooreHorspoolTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw12_1: ����");
		System.out.print("���� �Է�: ");
		String[] pArray = sc.next().split(""); // ����
		System.out.print("�ؽ�Ʈ �Է�: ");
		String[] tArray = sc.next().split(""); // �ؽ�Ʈ
		Map<String, Integer> jump = new HashMap<>(); // ���� ���̺�
		jump = computeJump(pArray, jump);
		
		BoyerMooreHorspool(tArray, pArray, jump); // �˰��� �۵�
		
		sc.close();
	}
	
	static Map<String, Integer> computeJump(String[] p, Map<String, Integer> jump){ // ���� ���̺� �ʱ�ȭ
		int m = p.length;
		
		jump.put(p[m-1], m); // ������ ��Ҵ� m��ŭ ����
		
		for(int i = 0; i < m-1; i++) { // m-1 ~ 1���� ���������� �ʱ�ȭ
			jump.put(p[i], m-1-i);
		}
		
		return jump;
	}
	
	static void BoyerMooreHorspool(String[] t, String[] p, Map<String, Integer> jump) {
		int n = t.length; // �ؽ�Ʈ ����
		int m = p.length; // ���� ����
		int index = m - 1;
		int jumpCount = 0; // ���� ��
		String matchIndex = ""; // ��Ī ��ġ
		
		for(int i = 0; i <= n-m+1; i += index) {
			if(i == n-m+1) { // ��Ī ���� ��ġ�� �ؽ�Ʈ ������ ��Ҷ��
				break;
			}
			boolean matching = true; // ��Ī �Ǵ�
			index = m;
			
			for(int j = m-1; j >= 0; j--) {
				if(t[i+j].compareTo(p[j]) != 0) { // ��Ұ� ���� �ʴٸ�
					String nowString = t[i+j];
					Integer jumping = jump.get(nowString);
					
					if(jumping == null) { // ��Ÿ�� m��ŭ ����
						index = m;
					}else {
						index = jumping; // �ƴϸ� ���� ���̺�ŭ ����
					}
					
					matching = false;
					break;					
				}
			}
			
			if(matching) { // ��Ī �����̸� ��Ī ��ġ �߰�
				matchIndex += i;
			}
			
			if(i + index <= n-m+1) { // ������ �����ϸ� ���� �� ++
				jumpCount++;
			}
		}

		// ��Ī ��ġ ���
		System.out.print("��Ī ��ġ =");
		if(matchIndex.compareTo("") != 0) {
			for(int i = 0; i < matchIndex.length(); i++) {
				System.out.print(" " + matchIndex.charAt(i));
			}
		}
		System.out.println();
		
		// ���� �� ���
		System.out.print("���� �� = " + jumpCount);
	}
}
