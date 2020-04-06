/*
 * ���ϸ�: StudentSelectionSort.java
 * �ۼ���: ����
 * �ۼ���: 2020.03.30.
 * ����: ���� ������ �̿��� �л� ������ ������������ �����ϱ�
 */
package hw;

import java.util.Scanner;

public class StudentSelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw3_2: ����\n");
		System.out.print("�л� �� �Է�: ");
		int count = sc.nextInt();
		StudentN[] studentList = new StudentN [count];
		StudentN tmp = new StudentN(); // ��ȯ�ϱ� ���� ��ü
		int min; // �ּڰ��� �ִ� �ε����� ��� ���� ����
		
		System.out.println("\n" + count + "���� �л� ������ �Է��ϼ���:");
		for(int i = 0; i < count; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new StudentN(name, sNum, grade);
		}
		
		for(int j = 0; j < count - 1; j++) {
			min = j; // ���� ���� ���� �ּҰ����� ����
			for(int k = j + 1; k < count; k++) { // ������ ���� �̸��� �ε��� ���ϱ�(�ּҰ� ���ϱ�)
				if(studentList[min].getName().compareTo(studentList[k].getName()) >= 0) {
					min = k;
				}
			}
			tmp = studentList[j]; // ������������ ����(������)
			studentList[j] = studentList[min];
			studentList[min] = tmp;
		}
		
		System.out.println("\n���� �������� ��� =");
		for(int l = 0; l < count; l++) {
			studentList[l].print();
		}
		
		sc.close();
	}

}

class StudentN{
	private String name; // �̸�
	private int sNum; // �й�
	private double grade; // ����
	
	//������
	public StudentN() {
	}
	public StudentN(String n, int num, double g) {
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