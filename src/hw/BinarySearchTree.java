/*
 * ���ϸ�: BinarySearchTree.java
 * �ۼ���: ����
 * �ۼ���: 2020.04.30.
 * ����: binary search tree�� ������ �����ϱ�
 */
package hw;

import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MyBinarySearchTree testTree = new MyBinarySearchTree();
		String s;
		System.out.println("hw6_1: ����\n");
		
		// ���α׷� ���� �ȳ���
		while(true) {
			System.out.println("1:���� 2:�˻� 3:���� 4:��ü��ȸ 5:����"); // 5�� �Է¹����� ����
			int oper = sc.nextInt();
			sc.nextLine();

			switch(oper) {
			case 1:
				System.out.print("������ ���̵� �Է��ϼ���: ");
				s = sc.nextLine();
				if(testTree.add(s)) {
					System.out.println("���� ����.");
				}else {
					System.out.println("���� ����.");
				}
				break;
			case 2:
				System.out.print("�˻��� ���̵� �Է��ϼ���: ");
				s = sc.nextLine();
				if(testTree.contains(s)) {
					System.out.println("�˻� ����.");
				}else {
					System.out.println("�˻� ����.");
				}
				break;
			case 3:
				System.out.print("������ ���̵� �Է��ϼ���: ");
				s = sc.nextLine();
				if(testTree.remove(s)) {
					System.out.println("���� ����.");
				}else {
					System.out.println("���� ����.");
				}
				break;
			case 4:
				System.out.println("���̵� ����: " + testTree.size());
				System.out.print("���̵� ����Ʈ: ");
				testTree.print();
				System.out.println();
				break;
			}
			
			if(oper == 5) {
				break;
			}
		}
		
		sc.close();
	}
}

class MyBinarySearchTree {
	// �ʵ�
	private Node root = new Node();
	private int countID = 0;
	
	// Ʈ���� ����� ���̵� ��� ���
	public void print() {
		inorder(root);
		System.out.println();
	}
	// Ʈ���� ����� ���̵� ������ ����
	public int size() {
		return countID;
	}
	// Ʈ���� ���̵� �����ϴ��� ���θ� �˻�
	public boolean contains(String id) {
		Node t = root;
		
		// ��Ʈ ��尡 ������� �˻� ����
		if(root.key == null) {
			return false;
		}
		
		while(true) {
			// �� ���� �˻� ����
			if(t == null) {
				return false;
			}
			
			// ��带 Ž���ϴ� ����
			if(id.compareTo(t.key) < 0) {
				t = t.left;
			}else if(id.compareTo(t.key) > 0) {
				t = t.right;
			}else {
				return true;
			}
		}
	}
	// Ʈ���� ���̵� ����
	public boolean add(String id) {
		Node t = root;
		Node newNode = new Node(id);
		
		// ��Ʈ ��尡 ������� ��� ����
		if(t.key == null) {
			root = newNode;
			countID++;
			return true;
		}else {
			Node p = null; // �θ� ����ϱ� ���� ����
			Node tmp = t;
			while(tmp != null) { // ������ ��� ��ġ tmp�� ����
				p = tmp;
				if(id.compareTo(tmp.key) < 0) {
					tmp = tmp.left;
				}else {
					tmp = tmp.right;
				}
			}
			// �θ� ��� p�� key���� id�� ���� ��� ������ �� �Ǵ�
			if(id.compareTo(p.key) < 0) {
				p.left = newNode;
				countID++;
				return true;
			}else if(id.compareTo(p.key) > 0){
				p.right = newNode;
				countID++;
				return true;
			}else {
				// �θ� ���� ���� ���̹Ƿ� ���� key ���� �� ���� ����
				return false;
			}
		}
	}
	// ��� �����ϴ� �޼ҵ�
	public boolean remove(String id) {
		Node t = root;
		Node p = root;
		boolean leftChild = true; // ��� ���⿡ ���� ��带 �־���� �ϴ��� �Ǵ�
		
		// �������� �ʴ� ���̵�� ���� ����
		if(!contains(id)) {
			return false;
		}
		
		// ������ id�� ��ġ�� ã��
		while(id.compareTo(t.key) != 0) {
			p = t;
			
			if(id.compareTo(t.key) < 0) {
				t = t.left;
				leftChild = true;
			}else {
				t = t.right;
				leftChild = false;
			}
		}
		
		while(true) {
			if(t.left == null && t.right == null) { // case 1: �ڽ��� ���� ���
				if(t == root) {
					root = null;
				}else if(leftChild) {
					p.left = null;
				}else {
					p.right = null;
				}

				countID--;
				return true;
			}else if(t.left != null && t.right == null) { // case 2: ���� �ڽĸ� �ִ� ���
				if(t == root) {
					root = t.left;
				}else if(leftChild) {
					p.left = t.left;
				}else {
					p.right = t.left;
				}
				
				countID--;
				return true;
			}else if(t.left == null && t.right != null) { // case 2: ������ �ڽĸ� �ִ� ���
				if(t == root) {
					root = t.right;
				}else if(leftChild) {
					p.left = t.right;
				}else {
					p.right = t.right;
				}
				
				countID--;
				return true;
			}else { // case 3: �ڽ��� �� �� �ִ� ���
				Node tmp = null;
				Node tmpP = null;
				Node minNode = t.right;
				while(minNode != null) { // �����ʿ��� �ּ� �� ��� ã��
					tmpP = tmp;
					tmp = minNode;
					minNode = minNode.left;
				}
				if(tmp != t.right) { // �ּҰ� ���� �����Ϸ��� ��尡 ���� ������
					tmpP.left = tmp.right; // �ּҰ� ����� �������� �ּҰ� ��� �θ��� �������� ����
					tmp.right = t.right; 
				}
				
				Node tmp2 = tmp;
				if(t == root) {
					root = tmp2;
				}else if(leftChild){
					p.left = tmp2;
				}else {
					p.right = tmp2;
				}
				tmp2.left = t.left;
				
				countID--;
				return true;
			}
		}
	}
	// �߼��� ��ȸ�ϸ� Ű ���� ���
	private void inorder(Node t) {
		if(t != null) {
			inorder(t.left);
			if(t.key == null) {
				
			}else {
				System.out.print(t.key + " ");
			}
			inorder(t.right);
		}
	}
	// Ʈ�� ������ �����ϴ� ��� Ŭ����
	private class Node {
		//�ʵ�
		String key;
		Node left;
		Node right;
		
		// ������
		public Node() {
			this.left = null;
			this.right = null;
		}
		public Node(String id) {
			this.key = id;
			this.left = null;
			this.right = null;
		}
	}
}