/*
 * 파일명: StudentArray.java
 * 작성자: 김기범
 * 작성일: 2020.03.30.
 * 내용: 학생 클래스로 배열에 학생 정보를 입력해 학생 전체 평균 점수와 최고 점수를 가진 학생의 이름을 출력하기
 */
package hw;

import java.util.Scanner;

public class StudentArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw3_1: 김기범\n");
		System.out.print("학생 수 입력: ");
		int size = sc.nextInt(); // 학생 수 입력 받기
		double average = 0.0; // 평균 점수
		Student[] studentList = new Student [size]; // 객체 배열
		
		System.out.println("\n" + size + "명의 학생 정보를 입력하세요:");
		for(int i = 0; i < size; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new Student(name, sNum, grade);
		}
		
		// 학생 평균 구하기
		for(int k = 0; k < size; k++) {
			average = average + studentList[k].getGrade();
		}
		System.out.println("\n성적 평균 = " + average/size);
		
		// 최고점 학생 이름 출력
		int maxIndex = 0;
		for(int l = 1; l < size; l++) {
			if(studentList[maxIndex].getGrade() < studentList[l].getGrade()) { // 최고점을 가진 학생의 인덱스 구하기
				maxIndex = l;
			}
		}
		System.out.println("\n수석 학생 성명 = " + studentList[maxIndex].getName());
		
		sc.close();
	}
}


class Student{
	private String name; // 이름
	private int sNum; // 학번
	private double grade; // 성적
	
	//생성자
	public Student() {
	}
	public Student(String n, int num, double g) {
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