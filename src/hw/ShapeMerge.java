/*
 * 파일명: ShapeMerge.java
 * 작성자: 김기범
 * 작성일: 2020.04.10
 * 내용: 도형 객체 배열를 면적을 기준으로 오름차순으로 병합 정렬하기
 */
package hw;

import java.util.Scanner;

public class ShapeMerge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw4_5: 김기범\n");
		System.out.print("원 갯수 입력: ");
		int cCount = sc.nextInt();
		System.out.print("삼각형 갯수 입력: ");
		int tCount = sc.nextInt();
		
		ShapeA[] shapeList = new ShapeA [cCount + tCount];
		
		System.out.println("\n" + cCount + "개의 원 정보(반지름)를 입력하세요:");
		for(int i = 0; i < cCount; i++) {
			double r = sc.nextDouble();
			
			shapeList[i] = new CircleA(r);
		}
		
		System.out.println("\n" + tCount + "개의 삼각형 정보(밑변과 높이)를 입력하세요:");
		for(int j = cCount; j < shapeList.length; j++) {
			double w = sc.nextDouble();
			double h = sc.nextDouble();
			
			shapeList[j] = new TriangleA(w, h);
		}
		
		SortService.mergeSort(shapeList);
		System.out.println("\n병합 정렬 결과 " + shapeList.length + "개의 도형 정보와 면적 =");
		for(int k = 0; k < shapeList.length; k++) {
			System.out.println(shapeList[k].toString());
		}
		
		sc.close();
	}

}

class SortService { // 정렬 관련 기능을 모아둔 서비스
	public static void mergeSort(ShapeA[] A) { // 도형 배열을 매개변수로 받는 메소드
		mergeSort(A, 0, A.length-1);
	}
	public static void mergeSort(ShapeA[] A, int p, int r){ 
		if(p < r) {
			int q = (p + r) / 2; // 중간 지점 구하기
			mergeSort(A, p, q); // 앞부분 정렬
			mergeSort(A, q+1, r); // 뒷부분 정렬
			merge(A, p, q, r);
		}
	}
	public static void merge(ShapeA[] A, int p, int q, int r) { // 병합하는 메소드
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
		
		while(i <= q) { // 왼쪽 부분 배열이 남은 경우
			tmp[t++] = A[i++];
		}
		
		while(j <= r) { // 오른쪽 부분 배열이 남은 경우
			tmp[t++] = A[j++];
		}
		
		i = p;
		t = 0;
		while(i <= r) { // 복사
			A[i++] = tmp[t++];
		}
	}
}

interface ShapeA { // 도형 인터페이스
	double getArea();
}

class CircleA implements ShapeA { // 원 클래스
	
	private double radius; // 반지름
	
	public CircleA() {} // 기본 생성자
	public CircleA(double r) {
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

class TriangleA implements ShapeA {
	
	private double width; // 밑변
	private double height; // 높이
	
	public TriangleA() {} // 기본 생성자
	public TriangleA(double w, double h) {
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