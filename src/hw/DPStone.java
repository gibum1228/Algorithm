/*
 * 파일명: DPStone.java
 * 작성자: 김기범
 * 작성일: 2020.05.22.
 * 내용: 돌 놓기 문제를 동적 프로그래밍으로 구현하기
 */
package hw;

public class DPStone {

	public static void main(String[] args) {
		System.out.println("hw8_2: 김기범\n");
		
		int n = (int)(Math.random() * 100) + 1; // 크기를 난수로 구하기
		
		int[][] a = new int [n + 1][4]; // 3 x n이지만, 밑에 메소드와 일관성을 위해 n x 3으로 정의
		
		for(int i = 1; i < n + 1; i++) { // 난수로 초기화
			for(int j = 1; j < 4; j++) {
				a[i][j] = (int)(Math.random() * 500) + 1;
			}
		}
		
		int[][] w = makeP(n, a);
		
		System.out.println("결과: " + pebble(n, w));
	}

	// 사용자가 만든 3 x n인 a 배열을 패턴값을 기준으로 만들기
	static int [][] makeP(int n, int[][] a){
		int[][] w = new int [n + 1][5]; // 패턴값을 담고 있는 리스트 w
		
		for(int i = 1; i < n+1; i++) {
			for(int p = 1; p < 5; p++) {
				if(p == 4) { // 패턴4의 값을 구하기 위해 1, 3 번째 값들을 더함
					w[i][p] = a[i][1] + a[i][3];
				}else { // 1, 2, 3은 그대로 값을 받아 옴
					w[i][p] = a[i][p];
				}
			}
		}
		
		return w;
	}
	
	// 최종 합 구하는 메소드
	static int pebble(int n, int[][] w) {
		int[][] peb = new int [n+1][5]; // 패턴 별로 돌의 합 구하기
		
		// 시작점 초기화
		for(int p = 1; p < 5; p++) {
			peb[1][p] = w[1][p];
		}
		
		// 열 별로 패턴에 알맞는 값 구하기
		for(int i = 2; i < n + 1; i++) {
			for(int p = 1; p < 5; p++) {
				switch(p) { // 패턴 규칙에 맞게 값 넣기
				case 1: // 패턴 1일 경우 2, 3을 비교
					if(peb[i-1][2] > peb[i-1][3]) { 
						peb[i][p] = peb[i-1][2] + w[i][p];
					}else {
						peb[i][p] = peb[i-1][3] + w[i][p];
					}
					
					break;
					
				case 2: // 패턴 2일 경우 1, 3, 4를 비교
					int max = peb[i-1][1];
					for(int j = 3; j < 5; j++) {
						if(max < peb[i-1][j]) {
							max = peb[i-1][j];
						}
					}
					
					peb[i][p] = max + w[i][p];
					
					break;
					
				case 3: // 패턴 3일 경우 1, 2을 비교
					if(peb[i-1][1] > peb[i-1][2]) {
						peb[i][p] = peb[i-1][1] + w[i][p];
					}else {
						peb[i][p] = peb[i-1][2] + w[i][p];
					}
					
					break;
					
				case 4: // 패턴 4일 경우 2
					peb[i][p] = peb[i-1][2] + w[i][p];
					
					break;
				}
			}
		}
		
		// 마지막 돌이 놓인 곳들의 최대 합
		int result = peb[n][1];
		for(int j = 2; j < 5; j++) {
			if(result < peb[n][j]) {
				result = peb[n][j];
			}
		}
		
		return result;
	}
}
