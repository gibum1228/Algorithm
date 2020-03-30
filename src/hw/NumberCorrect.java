/*
 * 파일명: NumberCorrect.java
 * 작성자: 김기범
 * 작성일: 2020.03.26.
 * 내용: 알고리즘 과제 1이며 사용자에게 정수값을 입력받아 주어진 정수 배열과 얼마나 가까운 가를 점수로 출력한다.
 */
package hw;

import java.util.Scanner;

public class NumberCorrect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int intList[] = {-30, -15, 1, 40, 50, 200, 315, 800, 900, 12345}; // 정수 배열
		System.out.println("hw0_1 : 김기범");
		System.out.println("숫자 맞추기 프로그램입니다.");
		System.out.print("하나의 정수값을 입력하세요 : ");
		int inputN = sc.nextInt();
		int score = 100; // 점수
		
		for(int i = 0; i < intList.length; i++) {
			if(inputN == intList[i]) { // 정수 배열에 입력받은 정수값과 동일할 경우 100점
				break;
			}else if(i == 0){ // 입력 받은 값이 -30보다 작을 경우
				if(inputN < intList[i]) {
					score = score - (intList[0] - inputN);
					break;
				}
			}else if(i == (intList.length - 1) && inputN > intList[i]){ // 입력 받은 값이 12345보다 클 경우
				score = score - (inputN - intList[i]);
				break;
			}else {
				if(inputN < intList[i]) { // 가까운 수를 찾고 점수를 계산
					if(inputN - intList[i-1] < intList[i] - inputN) { // 왼쪽 정수값과 더 가까울 경우
						score = score - (inputN - intList[i-1]);
					}else {
						score = score - (intList[i] - inputN); // 오른쪽 정수값과 더 가까울 경우
					}
					break;
				}
			}
		}
		
		if(score < 0) { // 100 이상 차이나면 0점
			score = 0;
		}
		
		System.out.println("점수 = " + score);
		
		sc.close();
	}

}
