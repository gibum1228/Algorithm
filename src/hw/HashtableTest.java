/*
 * 파일명: HashtableTest.java
 * 작성자: 김기범
 * 작성일: 2020.05.08.
 * 내용: 해시테이블을 사용하여 학번을 관리하는 프로그램
 */
package hw;

import java.util.Scanner;

public class HashtableTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw7_1: 김기범\n");
		// 해시테이블 크기 입력
		System.out.print("해시테이블 크기 입력: ");
		int size = sc.nextInt();
		// 해시테이블 생성
		Hashtable studentTable = new Hashtable(size);
		
		// 실행문
		int op = 0;
		int sNum;
		do {
			System.out.print("\n1:삽입 2:검색 3:삭제 4:테이블 출력 5:종료 ---> ");
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				System.out.print("삽입할 학번(정수값)을 입력하세요: ");
				sNum = sc.nextInt();
				
				if(studentTable.put(sNum)) {
					System.out.println(sNum + " 삽입 성공");
				}else {
					System.out.println(sNum + " 삽입 실패");
				}
				
				break;
			case 2:
				System.out.print("검색할 학번(정수값)을 입력하세요: ");
				sNum = sc.nextInt();
				
				if(studentTable.contains(sNum)) {
					System.out.println(sNum + " 학생을 찾았습니다.");
				}else {
					System.out.println(sNum + " 학생을 찾을 수 없습니다.");
				}
				
				break;
			case 3:
				System.out.print("삭제할 학번(정수값)을 입력하세요: ");
				sNum = sc.nextInt();
				
				if(studentTable.remove(sNum)) {
					System.out.println(sNum + " 삭제 성공");
				}else {
					System.out.println(sNum + " 삭제 실패");
				}
				
				break;
			case 4:
				studentTable.print();
				
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				
				break;
			default:
				System.out.println("메뉴 번호가 잘못되었습니다. 다시 입력하세요.");
			}
		}while(op != 5);
		
		sc.close();
	}

}
