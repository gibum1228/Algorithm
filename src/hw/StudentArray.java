/*
 * ���ϸ�: StudentArray.java
 * �ۼ���: ����
 * �ۼ���: 2020.03.30.
 * ����: �л� Ŭ������ �迭�� �л� ������ �Է��� �л� ��ü ��� ������ �ְ� ������ ���� �л��� �̸��� ����ϱ�
 */
package hw;

import java.util.Scanner;

public class StudentArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw3_1: ����\n");
		System.out.print("�л� �� �Է�: ");
		int size = sc.nextInt(); // �л� �� �Է� �ޱ�
		double average = 0.0; // ��� ����
		Student[] studentList = new Student [size]; // ��ü �迭
		
		System.out.println("\n" + size + "���� �л� ������ �Է��ϼ���:");
		for(int i = 0; i < size; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new Student(name, sNum, grade);
		}
		
		// �л� ��� ���ϱ�
		for(int k = 0; k < size; k++) {
			average = average + studentList[k].getGrade();
		}
		System.out.println("\n���� ��� = " + average/size);
		
		// �ְ��� �л� �̸� ���
		int maxIndex = 0;
		for(int l = 1; l < size; l++) {
			if(studentList[maxIndex].getGrade() < studentList[l].getGrade()) { // �ְ����� ���� �л��� �ε��� ���ϱ�
				maxIndex = l;
			}
		}
		System.out.println("\n���� �л� ���� = " + studentList[maxIndex].getName());
		
		sc.close();
	}
}


class Student{
	private String name; // �̸�
	private int sNum; // �й�
	private double grade; // ����
	
	//������
	public Student() {
	}
	public Student(String n, int num, double g) {
		this.name = n;
		this.sNum = num;
		this.grade = g;
	}
	
	// �ʵ� ȣ���ϴ� �޼ҵ�
	public String getName() {
		return name;
	}
	public int getSNum() {
		return sNum;
	}
	public double getGrade() {
		return grade;
	}
	
	//���������� �ʵ� �� �����ϴ� �޼ҵ�
	public void setName(String n) {
		this.name = n;
	}
	public void setSNum(int num) {
		this.sNum = num;
	}
	public void setGrade(double g) {
		this.grade = g;
	}
	
	public void print() { // �̸� �й� ���� ������ ���
		System.out.println(this.name + " " + this.sNum + " " + this.grade);
	}
}