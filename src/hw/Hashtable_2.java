/*
 * ���ϸ�: Hashtable_2.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.14.
 * ����: <�й�, ����> �����͸� ��� �ؽ� ���̺�, �浹 �ذ� ����� ü�̴�, �ؽ� �Լ��� ������ ��� 
 */
package hw;

public class Hashtable_2 {
	private Node[] table; // �ؽ� ���̺�
	private int m; // �ؽ� ���̺� ũ��
	private static final int HEAD = -1; // ��� ��� key
	
	// ������
	public Hashtable_2() {
	}
	public Hashtable_2(int size) { // ��� �ε��� ��ŸƮ ���� �ʱ�ȭ
		table = new Node[size];
		m = size;

		for (int i = 0; i < m; i++) {
			table[i] = new Node(HEAD);
		}
	}

	// �ؽ����̺� key ���� �����ϰ� ���� ���� ���θ� ����
	public boolean put(int key, int grade) {
		int index = hash(key);
		Node newNode = new Node(key, grade);
		Node t = table[index];
		
		while(true) {
			if(t.getKey() == key) { // �̹� �ִ� �й��̸� ���� ����
				t.setGrade(grade);
				
				return true;
			}else if(t.getRight() == null) { // ���ο� �й�-���� ����
				t.setRight(newNode);
				
				return true;
			}else { // ���Ḯ��Ʈ�� �� �� ã��
				t = t.getRight();
			}
		}
	}

	// �й��� �Ű������� �޾� ������ ����
	public int get(int key) {
		int index = hash(key);
		Node t = table[index];
		
		while(true) {
			if(t == null) { // ���� �й��� �˻��� ���
				return -1;
			}
			
			if(t.getKey() == key) { // �й��� �´� ������ ����
				return t.getGrade();
			}else {
				t = t.getRight();
			}
		}
	}

	// �ؽ����̺��� key ���� �����ϰ� ���� ���� ���θ� ����
	public boolean remove(int key) {
		int index = hash(key);
		Node t = table[index];
		Node p = t; // �� ��带 ����ϱ� ���� ���(�θ� ���?)
		
		while(true) {
			if(t == null) { // ���� �й��̸� ���� ����
				return false;
			}
			
			if(t.getKey() == key) { // ������ �й��� ã������
				p.setRight(t.getRight()); // ������ �й� ������ right�� ������ �й��� right�� ���� -> t�� �����
				
				return true;
			}else { // ������ �й� ã��
				p = t;
				t = t.getRight();
			}
		}
	}

	// �ؽ����̺��� ������ Ȯ���ϱ� ���� �ؽ����̺��� ������ ��� ���
	public void print() {
		System.out.println("�ؽ����̺� ����");

		for(int i = 0; i < m; i++) {
			Node t = table[i];
			System.out.print("[" + i + "] ");
			
			while(t != null) { // ���� ��尡 null�̸� ���� ����
				if(t.getKey() == HEAD) { // ��� ����� ��� �� ĭ
				}else { 
					System.out.print("<" + t.getKey() + "-" + t.getGrade() + "> "); // <�л�-����>���� ���
				}
				
				t = t.getRight();
			}
			
			System.out.println();
		}
	}

	// ������ ��� �ؽ� �Լ�
	private int hash(int x) {
		return x % m;
	}
}

class Node {
	private int key; // �й�(key)
	private int grade; // ����
	private Node right; // ������ ���

	// ������
	public Node() {
		this.right = null;
	}

	// ��� ���
	public Node(int key) {
		this.key = key;
		this.right = null;
	}

	// ������ ���
	public Node(int key, int grade) {
		this.key = key;
		this.grade = grade;
		this.right = null;
	}

	// get �޼ҵ�
	public int getKey() {
		return this.key;
	}
	public int getGrade() {
		return this.grade;
	}
	public Node getRight() {
		return this.right;
	}
	// set �޼ҵ�
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setRight(Node t) {
		this.right = t;
	}

}