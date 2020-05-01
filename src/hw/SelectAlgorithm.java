/*
 * 파일명: SelectAlgorithm.java
 * 작성자: 김기범
 * 작성일: 2020.04.20.
 * 내용: 선택 알고리즘을 이용해 배열에서 중앙값인 정수를 찾는 프로그램
 */
package hw;

import java.util.Scanner;

public class SelectAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw5_1: 김기범\n");
		System.out.print("정수 갯수 입력: ");
		int size = sc.nextInt(); // 정수 갯수
		int[] numList = new int [size]; // size개의 배열 생성
		System.out.print(size + "개의 정수 입력: ");
		for(int i = 0; i < size; i++) {
			numList[i] = sc.nextInt();
		}
		
		int centerIndex; // 중앙값 인덱스
		if(size % 2 == 0) {
			centerIndex = size / 2;
		}else {
			centerIndex = size / 2 + 1;
		}
		
		System.out.println("중앙값: " + select(numList, 0, numList.length - 1, centerIndex));
		
		sc.close();
	}
	
	// 평균 선형 시간 선택 알고리즘
	static int select(int[] A, int p, int r, int i) {
		if(p == r) { // 배열 크기가 1일 경우
			return A[p];
		}
		int q = partition(A, p, r); // 배열 정렬의 기준 값
		int k = q - p + 1; // q가 몇 번째로 작은 원소인지를 구하기 위한 변수
		
		if(i < k) {
			return select(A, p, q-1, i); // 왼쪽 범위만 조사
		}else if(i == k) {
			return A[q]; // 기준값이 중앙값
		}else {
			return select(A, q+1, r, i-k); // 오른쪽 범위만 조사
		}
	}
	
	static int partition(int[] A, int p, int r) {
		int x = A[r]; // 기준 원소값
		int i = p - 1; // 기준 원소보다 작거나 같은 범위의 끝지점
		for(int j = p; j < r; j++) { // j는 정해지지 않은 원소의 시작점
			if(A[j] <= x) { // 현재 값이 기준 값보다 작거나 같으면
				int tmp = A[++i]; // 작거나 같은 범위 +1
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		
		// 기준 원소와 기준 원소보다 큰 범위에 있는 첫 원소와 교환
		int tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		
		// 기준 원소 인덱스 리턴
		return i + 1;
	}

}
