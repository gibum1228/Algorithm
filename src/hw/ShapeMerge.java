/*
 * ���ϸ�: ShapeMerge.java
 * �ۼ���: ����
 * �ۼ���: 2020.04.10
 * ����: ���� ��ü �迭�� ������ �������� ������������ ���� �����ϱ�
 */
package hw;

import java.util.Scanner;

public class ShapeMerge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_5: ����\n");
		System.out.print("�� ���� �Է�: ");
		int cCount = sc.nextInt();
		System.out.print("�ﰢ�� ���� �Է�: ");
		int tCount = sc.nextInt();
		
		ShapeA[] shapeList = new ShapeA [cCount + tCount];
		
		System.out.println("\n" + cCount + "���� �� ����(������)�� �Է��ϼ���:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new CircleA(r);
		}
		
		System.out.println("\n" + tCount + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new TriangleA(w, h);
		}
		
		SortService.mergeSort(shapeList);
		System.out.println("\n���� ���� ��� " + shapeList.length + "���� ���� ������ ���� =");
		for(int k = 0; k < shapeList.length; k++) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

class SortService { // ���� ���� ����� ��Ƶ� ����
	public static void mergeSort(ShapeA[] A) { // ���� �迭�� �Ű������� �޴� �޼ҵ�
		mergeSort(A, 0, A.length-1);
	}
	public static void mergeSort(ShapeA[] A, int p, int r){ 
		if(p < r) {
			int q = (p + r) / 2; // �߰� ���� ���ϱ�
			mergeSort(A, p, q); // �պκ� ����
			mergeSort(A, q+1, r); // �޺κ� ����
			merge(A, p, q, r);
		}
	}
	public static void merge(ShapeA[] A, int p, int q, int r) { // �����ϴ� �޼ҵ�
		int i = p;
		int j = q + 1;
		int t = 0;
		
		ShapeA[] tmp = new ShapeA [A.length];
		
		while(i <= q && j <= r) {
			if(A[i].getArea() <= A[j].getArea()) {
				tmp[t++] = A[i++];
			}else {
				tmp[t++] = A[j++];
			}
		}
		
		while(i <= q) { // ���� �κ� �迭�� ���� ���
			tmp[t++] = A[i++];
		}
		
		while(j <= r) { // ������ �κ� �迭�� ���� ���
			tmp[t++] = A[j++];
		}
		
		i = p;
		t = 0;
		while(i <= r) { // ����
			A[i++] = tmp[t++];
		}
	}
}

interface ShapeA { // ���� �������̽�
	double getArea();
}

class CircleA implements ShapeA { // �� Ŭ����
	
	private double radius; // ������
	
	public CircleA() {} // �⺻ ������
	public CircleA(double r) {
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

class TriangleA implements ShapeA {
	
	private double width; // �غ�
	private double height; // ����
	
	public TriangleA() {} // �⺻ ������
	public TriangleA(double w, double h) {
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