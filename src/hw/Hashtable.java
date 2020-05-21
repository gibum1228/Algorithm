/*
 * 파일명: Hashtable.java
 * 작성자: 김기범
 * 작성일: 2020.05.08.
 * 내용: 학번을 저장하는 해시테이블. 충돌 해결기법은 선형 조사, 해시 함수는 나누기 방법
 */
package hw;

public class Hashtable {
	private int[] table; // 해시테이블
	private int m; // 해시테이블 크기
	private static final int EMPTY = -1; // 비어있는 자리임을 나타내는 값
	private static final int DELETED = -2; // 삭제된 자리임을 나타내는 값
	
	// 생성자
	public Hashtable() {}
	// 크기가 size인 해시테이블을 생성
	public Hashtable(int size) {
		this.table = new int [size];
		this.m = size;
		for(int i = 0; i < size; i++) {
			table[i] = EMPTY;
		}
	}
	
	// 해시테이블에 key 값을 삽입하고 삽입 성공 여부를 리턴
	public boolean put(int key) {
		int i = 0;
		
		while(i != m) {
			int j = hash(i, key);
			
			// 삽입 여부 판단
			if(table[j] == EMPTY || table[j] == DELETED) { // 삽입 성공
				table[j] = key;
				
				return true;
			}else {
				// 이미 있는 학번이면 삽입 실패
				if(table[j] == key) {
					break;
				}
				i++;
			}
		}
		
		return false; // 테이블이 꽉 차 있으면 false 리턴
	}
	// 해시테이블에 key 값을 검색하여 인덱스를 리턴, 검색 실패시 -1 리턴
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
	// 해시테이블에서 key 값을 검색하고 검색 성공 여부를 리턴
	public boolean contains(int key) {
		int index = search(key);
		
		return (index >= 0); // 조건에 맞는 boolean 값을 리턴
	}
	// 해시테이블에서 key 값을 삭제하고 삭제 성공 여부를 리턴
	public boolean remove(int key) {
		int index = search(key);
		
		if(index == -1) { // 존재하지 않는 학번이면 삭제 실패
			return false;
		}else {
			// 삭제 성공
			table[index] = DELETED;
			
			return true;
		}
	}
	// 해시테이블의 구현을 확인하기 위해 해시테이블의 구조를 모두 출력
	public void print() {
		System.out.println("해시테이블 내용");
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
	
	// 나누기 방법 해시 함수
	private int hash(int x) {
		return x % m;
	}
	// 선형 조사
	private int hash(int i, int x) {
		return (hash(x) + i) % m;
	}
}