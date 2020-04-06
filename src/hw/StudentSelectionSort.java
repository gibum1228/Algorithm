/*
 * 파일명: StudentSelectionSort.java
 * 작성자: 김기범
 * 작성일: 2020.03.30.
 * 내용: 선택 정렬을 이용해 학생 성명을 오름차순으로 정렬하기
 */
package hw;

import java.util.Scanner;

public class StudentSelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw3_2: 김기범\n");
		System.out.print("학생 수 입력: ");
		int count = sc.nextInt();
		StudentN[] studentList = new StudentN [count];
		StudentN tmp = new StudentN(); // 교환하기 위한 객체
		int min; // 최솟값이 있는 인덱스를 담기 위한 변수
		
		System.out.println("\n" + count + "명의 학생 정보를 입력하세요:");
		for(int i = 0; i < count; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new StudentN(name, sNum, grade);
		}
		
		for(int j = 0; j < count - 1; j++) {
			min = j; // 제일 왼쪽 값을 최소값으로 지정
			for(int k = j + 1; k < count; k++) { // 순번이 빠른 이름의 인덱스 구하기(최소값 구하기)
				if(studentList[min].getName().compareTo(studentList[k].getName()) >= 0) {
					min = k;
				}
			}
			tmp = studentList[j]; // 오름차순으로 정렬(스왑핑)
			studentList[j] = studentList[min];
			studentList[min] = tmp;
		}
		
		System.out.println("\n성명 오름차순 결과 =");
		for(int l = 0; l < count; l++) {
			studentList[l].print();
		}
		
		sc.close();
	}

}

class StudentN{
	private String name; // 이름
	private int sNum; // 학번
	private double grade; // 성적
	
	//생성자
	public StudentN() {
	}
	public StudentN(String n, int num, double g) {
		this.name = n;
		this.sNum = num;
		this.grade = g;
	}
	
	// 필드 호출하는 메소드
	public String getName() {
		return name;
	}
	public int getSNum() {
		return sNum;
	}
	public double getGrade() {
		return grade;
	}
	
	//예외적으로 필드 값 변경하는 메소드
	public void setName(String n) {
		this.name = n;
	}
	public void setSNum(int num) {
		this.sNum = num;
	}
	public void setGrade(double g) {
		this.grade = g;
	}
	
	public void print() { // 이름 학번 성적 순으로 출력
		System.out.println(this.name + " " + this.sNum + " " + this.grade);
	}
}