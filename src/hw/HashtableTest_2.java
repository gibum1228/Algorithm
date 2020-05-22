/*
 * 파일명: HashtableTest_2.java
 * 작성자: 김기범
 * 작성일: 2020.05.14.
 * 내용: <학생-성적>을 저장하는 해시 테이블을 이용하는 프로그램
 */
package hw;

import java.util.Scanner;

public class HashtableTest_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw7_2: 김기범\n");
		// 해시테이블 크기 입력
		System.out.print("해시테이블 크기 입력: ");
		int size = sc.nextInt();
		// 해시테이블 생성
		Hashtable_2 studentTable = new Hashtable_2(size);
		
		// 실행문
		int op = 0;
		int sNum;
		int grade;
		do {
			System.out.print("\n1:삽입 2:검색 3:삭제 4:테이블 출력 5:종료 ---> ");
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				System.out.print("삽입할 <학번(정수), 성적(정수)>을 입력하세요(<ex> 1 3): ");
				sNum = sc.nextInt();
				grade = sc.nextInt();
				
				if(studentTable.put(sNum, grade)) {
					System.out.println(sNum + " 학생의 성적 삽입 성공");
				}else {
					System.out.println(sNum + " 학생의 성적 삽입 실패");
				}
				
				break;
			case 2:
				System.out.print("성적이 궁금한 학생의 학번(정수값)을 입력하세요: ");
				sNum = sc.nextInt();
				
				System.out.println(sNum + "의 성적: " + studentTable.get(sNum));
				
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
