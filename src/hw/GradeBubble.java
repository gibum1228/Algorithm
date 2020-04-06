/*
 * ���ϸ�: GradeBubble.java
 * �ۼ���: ����
 * �ۼ���: 2020.03.30.
 * ����: ������ ���� ���ķ� ������������ ����϶�
 */
package hw;

import java.util.Scanner;

public class GradeBubble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw3_3: ����\n");
		System.out.print("�л� �� �Է�: ");
		int count = sc.nextInt();
		StudentG[] studentList = new StudentG [count];
		StudentG tmp = new StudentG(); // ������ ���� ��ü
		
		System.out.println("\n" + count + "���� �л� ������ �Է��ϼ���:");
		for(int i = 0; i < count; i++) {
			String name = sc.next();
			int sNum = sc.nextInt();
			double grade = sc.nextDouble();
			
			studentList[i] = new StudentG(name, sNum, grade);
		}
		
		System.out.println("\n���� �������� ���� ��� =");
		for(int j = 0; j < studentList.length - 1; j++) {
			for(int k = 0; k < studentList.length - j - 1; k++) {
				if(studentList[k].getGrade() < studentList[k+1].getGrade()) { // ������ �������� ������������ ����
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
	private String name; // �̸�
	private int sNum; // �й�
	private double grade; // ����
	
	//������
	public StudentG() {
	}
	public StudentG(String n, int num, double g) {
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