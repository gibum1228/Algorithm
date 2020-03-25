// 201814066 김기범
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
			if(inputN == intList[i]) { // 같은 정수값이 있기 때문에 100점
				break;
			}else if(i == 0){ // 입력받은 값이 -30보다 작을 경우
				if(inputN < intList[i]) {
					score = score - (intList[0] - inputN);
					break;
				}
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
