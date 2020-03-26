// 201814066 김기범
package hw;

import java.util.Scanner;

public class ArrayCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a[] = new int [100]; // 크기가 100인 두 정수 배열 생성
		int b[] = new int [100];
		int aSize = 100, bSize = 100; // 실제 입력 받은 배열 크기를 알기 위한 변수
		boolean same = false; // 두 원소를 비교했을 때 같으면 true, 같지 않으면 false
		System.out.println("hw0_2: 김기범");
		System.out.println("양의 정수 집합을 비교하는 프로그램입니다.");
		
		System.out.print("\n첫번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요: "); // 첫번째 배열 입력받기
		for(int i = 0; i < 100; i++) {
			int inputN = sc.nextInt();
			if(inputN <= 0) { // 양의 정수가 아닌 것을 입력 받았을 경우 입력 종료
				aSize = i;
				break;
			}else {
				a[i] = inputN;
			}
		}
		System.out.print("두번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요: "); // 두번째 배열 입력받기
		for(int j = 0; j < 100; j++) {
			int inputN = sc.nextInt();
			if(inputN <= 0) { // 양의 정수가 아닌 것을 입력 받았을 경우 입력 종료
				bSize = j;
				break;
			}else {
				b[j] = inputN;
			}
		}
		
		// 두 집합의 크기가 무조건 같다고는 명시가 되어 있지 않음
		if(aSize != bSize) { // 두 집합의 크기가 다를 경우
		}else {
			for(int k = 0; k < aSize; k++) { // 두 집합의 크기가 같을 경우 원소 비교
				same = false;
				for(int l = 0; l < bSize; l++) { // 두 집합의 원소를 하나 하나 비교하기
					if(a[k] == b[l]) { // 같으면 same을 true로 바꾸고 다음 원소를 기준으로 비교하기
						same = true;
						break;
					}
				}
				
				if(!(same)) { // 같은 원소가 없을 경우 반복문 종료
					break;
				}
			}
		}
		
		if(same) {
			System.out.println("두 집합은 같습니다.");
		}else {
			System.out.println("두 집합은 같지 않습니다.");
		}
		
		sc.close();
	}

}
