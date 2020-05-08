/*
 * 파일명: BinarySearchTree.java
 * 작성자: 김기범
 * 작성일: 2020.04.30.
 * 내용: binary search tree의 연산을 이해하기
 */
package hw;

import java.util.Scanner;

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MyBinarySearchTree testTree = new MyBinarySearchTree();
		String s;
		System.out.println("hw6_1: 김기범\n");
		
		// 프로그램 실행 안내문
		while(true) {
			System.out.println("1:삽입 2:검색 3:삭제 4:전체조회 5:종료"); // 5번 입력받으면 종료
			int oper = sc.nextInt();
			sc.nextLine();

			switch(oper) {
			case 1:
				System.out.print("삽입할 아이디를 입력하세요: ");
				s = sc.nextLine();
				if(testTree.add(s)) {
					System.out.println("삽입 성공.");
				}else {
					System.out.println("삽입 실패.");
				}
				break;
			case 2:
				System.out.print("검색할 아이디를 입력하세요: ");
				s = sc.nextLine();
				if(testTree.contains(s)) {
					System.out.println("검색 성공.");
				}else {
					System.out.println("검색 실패.");
				}
				break;
			case 3:
				System.out.print("삭제할 아이디를 입력하세요: ");
				s = sc.nextLine();
				if(testTree.remove(s)) {
					System.out.println("삭제 성공.");
				}else {
					System.out.println("삭제 실패.");
				}
				break;
			case 4:
				System.out.println("아이디 갯수: " + testTree.size());
				System.out.print("아이디 리스트: ");
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
	// 필드
	private Node root = new Node();
	private int countID = 0;
	
	// 트리에 저장된 아이디를 모두 출력
	public void print() {
		inorder(root);
		System.out.println();
	}
	// 트리에 저장된 아이디 갯수를 리턴
	public int size() {
		return countID;
	}
	// 트리에 아이디가 존재하는지 여부를 검사
	public boolean contains(String id) {
		Node t = root;
		
		// 루트 노드가 비었으면 검색 실패
		if(root.key == null) {
			return false;
		}
		
		while(true) {
			// 빈 노드면 검색 실패
			if(t == null) {
				return false;
			}
			
			// 노드를 탐색하는 과정
			if(id.compareTo(t.key) < 0) {
				t = t.left;
			}else if(id.compareTo(t.key) > 0) {
				t = t.right;
			}else {
				return true;
			}
		}
	}
	// 트리에 아이디를 삽입
	public boolean add(String id) {
		Node t = root;
		Node newNode = new Node(id);
		
		// 루트 노드가 비어있을 경우 저장
		if(t.key == null) {
			root = newNode;
			countID++;
			return true;
		}else {
			Node p = null; // 부모를 기억하기 위한 변수
			Node tmp = t;
			while(tmp != null) { // 저장할 노드 위치 tmp를 구함
				p = tmp;
				if(id.compareTo(tmp.key) < 0) {
					tmp = tmp.left;
				}else {
					tmp = tmp.right;
				}
			}
			// 부모 노드 p의 key값과 id를 비교해 어디에 저장할 지 판단
			if(id.compareTo(p.key) < 0) {
				p.left = newNode;
				countID++;
				return true;
			}else if(id.compareTo(p.key) > 0){
				p.right = newNode;
				countID++;
				return true;
			}else {
				// 부모 노드와 같은 값이므로 같은 key 값일 시 삽입 실패
				return false;
			}
		}
	}
	// 노드 삭제하는 메소드
	public boolean remove(String id) {
		Node t = root;
		Node p = root;
		boolean leftChild = true; // 어느 방향에 기존 노드를 넣어줘야 하는지 판단
		
		// 존재하지 않는 아이디면 삭제 실패
		if(!contains(id)) {
			return false;
		}
		
		// 삭제할 id의 위치를 찾기
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
			if(t.left == null && t.right == null) { // case 1: 자식이 없는 경우
				if(t == root) {
					root = null;
				}else if(leftChild) {
					p.left = null;
				}else {
					p.right = null;
				}

				countID--;
				return true;
			}else if(t.left != null && t.right == null) { // case 2: 왼쪽 자식만 있는 경우
				if(t == root) {
					root = t.left;
				}else if(leftChild) {
					p.left = t.left;
				}else {
					p.right = t.left;
				}
				
				countID--;
				return true;
			}else if(t.left == null && t.right != null) { // case 2: 오른쪽 자식만 있는 경우
				if(t == root) {
					root = t.right;
				}else if(leftChild) {
					p.left = t.right;
				}else {
					p.right = t.right;
				}
				
				countID--;
				return true;
			}else { // case 3: 자식이 둘 다 있는 경우
				Node tmp = null;
				Node tmpP = null;
				Node minNode = t.right;
				while(minNode != null) { // 오른쪽에서 최소 값 노드 찾음
					tmpP = tmp;
					tmp = minNode;
					minNode = minNode.left;
				}
				if(tmp != t.right) { // 최소값 노드와 삭제하려는 노드가 같지 않으면
					tmpP.left = tmp.right; // 최소값 노드의 오른쪽을 최소값 노드 부모의 왼쪽으로 변경
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
	// 중순위 순회하며 키 값을 출력
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
	// 트리 구조를 정의하는 노드 클래스
	private class Node {
		//필드
		String key;
		Node left;
		Node right;
		
		// 생성자
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