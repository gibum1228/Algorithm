/*
 * 파일명: Hashtable_2.java
 * 작성자: 김기범
 * 작성일: 2020.05.14.
 * 내용: <학번, 성적> 데이터를 담는 해시 테이블, 충돌 해결 방법은 체이닝, 해시 함수는 나누기 방법 
 */
package hw;

public class Hashtable_2 {
	private Node[] table; // 해시 테이블
	private int m; // 해시 테이블 크기
	private static final int HEAD = -1; // 헤드 노드 key
	
	// 생성자
	public Hashtable_2() {
	}
	public Hashtable_2(int size) { // 모든 인덱스 스타트 노드로 초기화
		table = new Node[size];
		m = size;

		for (int i = 0; i < m; i++) {
			table[i] = new Node(HEAD);
		}
	}

	// 해시테이블에 key 값을 삽입하고 삽입 성공 여부를 리턴
	public boolean put(int key, int grade) {
		int index = hash(key);
		Node newNode = new Node(key, grade);
		Node t = table[index];
		
		while(true) {
			if(t.getKey() == key) { // 이미 있는 학번이면 성적 갱신
				t.setGrade(grade);
				
				return true;
			}else if(t.getRight() == null) { // 새로운 학번-성적 삽입
				t.setRight(newNode);
				
				return true;
			}else { // 연결리스트의 맨 뒤 찾기
				t = t.getRight();
			}
		}
	}

	// 학번을 매개변수로 받아 성적을 리턴
	public int get(int key) {
		int index = hash(key);
		Node t = table[index];
		
		while(true) {
			if(t == null) { // 없는 학번을 검색한 경우
				return -1;
			}
			
			if(t.getKey() == key) { // 학번에 맞는 성적을 리턴
				return t.getGrade();
			}else {
				t = t.getRight();
			}
		}
	}

	// 해시테이블에서 key 값을 삭제하고 삭제 성공 여부를 리턴
	public boolean remove(int key) {
		int index = hash(key);
		Node t = table[index];
		Node p = t; // 전 노드를 기억하기 위한 노드(부모 노드?)
		
		while(true) {
			if(t == null) { // 없는 학번이면 삭제 실패
				return false;
			}
			
			if(t.getKey() == key) { // 삭제할 학번을 찾았으면
				p.setRight(t.getRight()); // 삭제할 학번 왼쪽의 right를 삭제할 학번의 right과 연결 -> t는 사라짐
				
				return true;
			}else { // 삭제할 학번 찾기
				p = t;
				t = t.getRight();
			}
		}
	}

	// 해시테이블의 구현을 확인하기 위해 해시테이블의 구조를 모두 출력
	public void print() {
		System.out.println("해시테이블 내용");

		for(int i = 0; i < m; i++) {
			Node t = table[i];
			System.out.print("[" + i + "] ");
			
			while(t != null) { // 현재 노드가 null이면 실행 종료
				if(t.getKey() == HEAD) { // 헤드 노드일 경우 빈 칸
				}else { 
					System.out.print("<" + t.getKey() + "-" + t.getGrade() + "> "); // <학생-성적>으로 출력
				}
				
				t = t.getRight();
			}
			
			System.out.println();
		}
	}

	// 나누기 방법 해시 함수
	private int hash(int x) {
		return x % m;
	}
}

class Node {
	private int key; // 학번(key)
	private int grade; // 성적
	private Node right; // 오른쪽 노드

	// 생성자
	public Node() {
		this.right = null;
	}

	// 헤드 노드
	public Node(int key) {
		this.key = key;
		this.right = null;
	}

	// 데이터 노드
	public Node(int key, int grade) {
		this.key = key;
		this.grade = grade;
		this.right = null;
	}

	// get 메소드
	public int getKey() {
		return this.key;
	}
	public int getGrade() {
		return this.grade;
	}
	public Node getRight() {
		return this.right;
	}
	// set 메소드
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setRight(Node t) {
		this.right = t;
	}

}