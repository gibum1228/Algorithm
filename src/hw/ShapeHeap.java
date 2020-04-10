/*
 * ���ϸ�: ShapeHeap.java
 * �ۼ���: ����
 * �ۼ���: 2020.04.10.
 * ����: �� �ڷᱸ���� �迭�� ǥ���� ��, n���� �ڷḦ �迭 �ε��� 0~n-1�� �����ϵ��� ���α׷��� �����
 */
package hw;

import java.util.Scanner;

public class ShapeHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_6: ����\n");
		System.out.print("�� ���� �Է�: ");
		int cCount = sc.nextInt();
		System.out.print("�ﰢ�� ���� �Է�: ");
		int tCount = sc.nextInt();
		
		ShapeH[] shapeList = new ShapeH [cCount + tCount];
		
		System.out.println("\n" + cCount + "���� �� ����(������)�� �Է��ϼ���:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new CircleH(r);
		}
		
		System.out.println("\n" + tCount + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new TriangleH(w, h);
		}
		
		SortServiceH.heapSort(shapeList, shapeList.length - 1);
		System.out.println("\n�� ���� ��� " + shapeList.length + "���� ���� ������ ���� =");
		for(int k = shapeList.length - 1; k >= 0; k--) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

class SortServiceH { // ���� ���� ����� ��Ƶ� ����
	public static void buildHeap(ShapeH[] A, int n) {
		for(int i = n / 2; i >= 0; i--) {
			heapify(A, i, n);
		}
	}
	
	public static void heapify(ShapeH[] A, int i, int n) {
		int small;
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		
		if(right <= n) {
			if(A[left].getArea() < A[right].getArea()) {
				small = left;
			}else {
				small = right;
			}
		}else if(left <= n) {
			small = left;
		}else {
			small = i;
		}
		
		if(A[small].getArea() < A[i].getArea()) {
			ShapeH tmp = A[i];
			A[i] = A[small];
			A[small] = tmp;
			heapify(A, small, n);
		}
	}
	
	public static void heapSort(ShapeH[] A, int n) {
		buildHeap(A, n);		
		System.out.println();
		for(int i = n; i > 0; i--) {
			ShapeH tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;
			heapify(A, 0, i-1);
		}
	}
}

interface ShapeH { // ���� �������̽�
	double getArea();
}

class CircleH implements ShapeH { // �� Ŭ����
	
	private double radius; // ������
	
	public CircleH() {} // �⺻ ������
	public CircleH(double r) {
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

class TriangleH implements ShapeH {
	
	private double width; // �غ�
	private double height; // ����
	
	public TriangleH() {} // �⺻ ������
	public TriangleH(double w, double h) {
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