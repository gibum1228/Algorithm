/*
 * 파일명: GradeBubble.java
 * 작성자: 김기범
 * 작성일: 2020.03.30.
 * 내용: 성적을 버블 정렬로 내림차순으로 출력하라
 */
package hw;

import java.util.Scanner;

public class GradeBubble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw3_3: 김기범\n");
		System.out.print("학생 수 입력: ");
		int count = sc.nextInt();
		StudentG[] studentList = new StudentG [count];
		StudentG tmp = new StudentG(); // 스왑을 위한 객체
		
		System.out.println("\n" + count + "명의 학생 정보를 입력하세요:");
		for(int i = 0; i < count; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new StudentG(name, sNum, grade);
		}
		
		System.out.println("\n성적 내림차순 정렬 결과 =");
		for(int j = 0; j < studentList.length - 1; j++) {
			for(int k = 0; k < studentList.length - j - 1; k++) {
				if(studentList[k].getGrade() < studentList[k+1].getGrade()) { // 성적을 기준으로 내림차순으로 정렬
					tmp = studentList[k];
					studentList[k] = studentList[k+1];
					studentList[k+1] = tmp;
				}
			}
		}
		
		for(int l = 0; l < studentList.length; l++) {
			studentList[l].print();
		}
		
		sc.close();
	}

}

class StudentG{
	private String name; // 이름
	private int sNum; // 학번
	private double grade; // 성적
	
	//생성자
	public StudentG() {
	}
	public StudentG(String n, int num, double g) {
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