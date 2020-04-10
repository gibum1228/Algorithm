/*
 * 파일명: ShapeHeap.java
 * 작성자: 김기범
 * 작성일: 2020.04.10.
 * 내용: 힙 자료구조를 배열로 표현할 때, n개의 자료를 배열 인덱스 0~n-1에 저장하도록 프로그램을 만들기
 */
package hw;

import java.util.Scanner;

public class ShapeHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_6: 김기범\n");
		System.out.print("원 갯수 입력: ");
		int cCount = sc.nextInt();
		System.out.print("삼각형 갯수 입력: ");
		int tCount = sc.nextInt();
		
		ShapeH[] shapeList = new ShapeH [cCount + tCount];
		
		System.out.println("\n" + cCount + "개의 원 정보(반지름)를 입력하세요:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new CircleH(r);
		}
		
		System.out.println("\n" + tCount + "개의 삼각형 정보(밑변과 높이)를 입력하세요:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new TriangleH(w, h);
		}
		
		SortServiceH.heapSort(shapeList, shapeList.length - 1);
		System.out.println("\n힙 정렬 결과 " + shapeList.length + "개의 도형 정보와 면적 =");
		for(int k = shapeList.length - 1; k >= 0; k--) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

class SortServiceH { // 정렬 관련 기능을 모아둔 서비스
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

interface ShapeH { // 도형 인터페이스
	double getArea();
}

class CircleH implements ShapeH { // 원 클래스
	
	private double radius; // 반지름
	
	public CircleH() {} // 기본 생성자
	public CircleH(double r) {
		this.radius = r;
	}
	
	public double getRadius() { // 반지름 호출
		return this.radius;
	}
	
	public void setRadius(double r) { // 반지름 재설정
		this.radius = r;
	}
	
	public double getArea() { // 면적 구하기 메소드
		return (3.14 * this.radius * this.radius);
	}
	
	public String toString() { // toString() 오버라이딩
		return "원 반지름=" + this.radius + " 면적=" + getArea();
	}
	
}

class TriangleH implements ShapeH {
	
	private double width; // 밑변
	private double height; // 높이
	
	public TriangleH() {} // 기본 생성자
	public TriangleH(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	public double getWidth() { // 필드 호출
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
	
	public void setWidth(double w) { // 필드 재설정
		this.width = w;
	}
	public void setHeight(double h) {
		this.height = h;
	}
	
	public double getArea() { // 면적 구하기 메소드
		return (this.width * this.height) / 2.0;
	}	
	
	public String toString() { // toString() 오버라이딩
		return "삼각형 밑변=" + this.width + " 높이=" + this.height + " 면적=" + getArea(); 
	}
}