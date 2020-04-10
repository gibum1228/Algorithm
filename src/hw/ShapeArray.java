/*
 * ���ϸ�: ShapeArray.java
 * �ۼ���: ����
 * �ۼ���: 2020.04.10.
 * ����: 4���� �������̽�/Ŭ������ �̿��� ���� ��ü �迭�� �ٷ��
 */
package hw;

import java.util.Scanner;

public class ShapeArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_4: ����\n");
		System.out.print("�� ���� �Է�: ");
		int cCount = sc.nextInt();
		System.out.print("�ﰢ�� ���� �Է�: ");
		int tCount = sc.nextInt();
		
		Shape[] shapeList = new Shape [cCount + tCount];
		
		System.out.println("\n" + cCount + "���� �� ����(������)�� �Է��ϼ���:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new Circle(r);
		}
		
		System.out.println("\n" + tCount + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new Triangle(w, h);
		}
		
		System.out.println("\n" + shapeList.length + "���� ���� ������ ���� =");
		for(int k = 0; k < shapeList.length; k++) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

interface Shape { // ���� �������̽�
	double getArea();
}

class Circle implements Shape { // �� Ŭ����
	
	private double radius; // ������
	
	public Circle() {} // �⺻ ������
	public Circle(double r) {
		this.radius = r;
	}
	
	public double getRadius() { // ������ ȣ��
		return this.radius;
	}
	
	public void setRadius(double r) { // ������ �缳��
		this.radius = r;
	}
	
	public double getArea() { // ���� ���ϱ� �޼ҵ�
		return (3.14 * this.radius * this.radius);
	}
	
	public String toString() { // toString() �������̵�
		return "�� ������=" + this.radius + " ����=" + getArea();
	}
	
}

class Triangle implements Shape {
	
	private double width; // �غ�
	private double height; // ����
	
	public Triangle() {} // �⺻ ������
	public Triangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	public double getWidth() { // �ʵ� ȣ��
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	
	public void setWidth(double w) { // �ʵ� �缳��
		this.width = w;
	}
	public void setHeight(double h) {
		this.height = h;
	}
	
	public double getArea() { // ���� ���ϱ� �޼ҵ�
		return (this.width * this.height) / 2.0;
	}	
	
	public String toString() { // toString() �������̵�
		return "�ﰢ�� �غ�=" + this.width + " ����=" + this.height + " ����=" + getArea(); 
	}
}