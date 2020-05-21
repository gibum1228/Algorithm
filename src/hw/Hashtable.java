/*
 * ���ϸ�: Hashtable.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.08.
 * ����: �й��� �����ϴ� �ؽ����̺�. �浹 �ذ����� ���� ����, �ؽ� �Լ��� ������ ���
 */
package hw;

public class Hashtable {
	private int[] table; // �ؽ����̺�
	private int m; // �ؽ����̺� ũ��
	private static final int EMPTY = -1; // ����ִ� �ڸ����� ��Ÿ���� ��
	private static final int DELETED = -2; // ������ �ڸ����� ��Ÿ���� ��
	
	// ������
	public Hashtable() {}
	// ũ�Ⱑ size�� �ؽ����̺��� ����
	public Hashtable(int size) {
		this.table = new int [size];
		this.m = size;
		for(int i = 0; i < size; i++) {
			table[i] = EMPTY;
		}
	}
	
	// �ؽ����̺� key ���� �����ϰ� ���� ���� ���θ� ����
	public boolean put(int key) {
		int i = 0;
		
		while(i != m) {
			int j = hash(i, key);
			
			// ���� ���� �Ǵ�
			if(table[j] == EMPTY || table[j] == DELETED) { // ���� ����
				table[j] = key;
				
				return true;
			}else {
				// �̹� �ִ� �й��̸� ���� ����
				if(table[j] == key) {
					break;
				}
				i++;
			}
		}
		
		return false; // ���̺��� �� �� ������ false ����
	}
	// �ؽ����̺� key ���� �˻��Ͽ� �ε����� ����, �˻� ���н� -1 ����
	private int search(int key) {
		int i = 0;
		
		while(true) {
			int j = hash(i, key);
			
			if(table[j] == EMPTY || i == m) {
				break;
			}
			
			if(table[j] == key) {
				return j;
			}else {
				i++;
			}
		}

		return -1;
	}
	// �ؽ����̺��� key ���� �˻��ϰ� �˻� ���� ���θ� ����
	public boolean contains(int key) {
		int index = search(key);
		
		return (index >= 0); // ���ǿ� �´� boolean ���� ����
	}
	// �ؽ����̺��� key ���� �����ϰ� ���� ���� ���θ� ����
	public boolean remove(int key) {
		int index = search(key);
		
		if(index == -1) { // �������� �ʴ� �й��̸� ���� ����
			return false;
		}else {
			// ���� ����
			table[index] = DELETED;
			
			return true;
		}
	}
	// �ؽ����̺��� ������ Ȯ���ϱ� ���� �ؽ����̺��� ������ ��� ���
	public void print() {
		System.out.println("�ؽ����̺� ����");
		for(int i = 0; i < m; i++) {
			if(table[i] == EMPTY) {
				System.out.println("[" + i + "] ");
			}else if(table[i] == DELETED) {
				System.out.println("[" + i + "] DELETED");
			}else {
				System.out.println("[" + i + "] " + table[i]);
			}
		}
	}
	
	// ������ ��� �ؽ� �Լ�
	private int hash(int x) {
		return x % m;
	}
	// ���� ����
	private int hash(int i, int x) {
		return (hash(x) + i) % m;
	}
}