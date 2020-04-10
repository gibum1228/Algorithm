/*
 * 파일명: ShapeArray.java
 * 작성자: 김기범
 * 작성일: 2020.04.10.
 * 내용: 4개의 인터페이스/클래스를 이용해 도형 객체 배열을 다루기
 */
package hw;

import java.util.Scanner;

public class ShapeArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_4: 김기범\n");
		System.out.print("원 갯수 입력: ");
		int cCount = sc.nextInt();
		System.out.print("삼각형 갯수 입력: ");
		int tCount = sc.nextInt();
		
		Shape[] shapeList = new Shape [cCount + tCount];
		
		System.out.println("\n" + cCount + "개의 원 정보(반지름)를 입력하세요:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new Circle(r);
		}
		
		System.out.println("\n" + tCount + "개의 삼각형 정보(밑변과 높이)를 입력하세요:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new Triangle(w, h);
		}
		
		System.out.println("\n" + shapeList.length + "개의 도형 정보와 면적 =");
		for(int k = 0; k < shapeList.length; k++) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

interface Shape { // 도형 인터페이스
	double getArea();
}

class Circle implements Shape { // 원 클래스
	
	private double radius; // 반지름
	
	public Circle() {} // 기본 생성자
	public Circle(double r) {
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

class Triangle implements Shape {
	
	private double width; // 밑변
	private double height; // 높이
	
	public Triangle() {} // 기본 생성자
	public Triangle(double w, double h) {
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