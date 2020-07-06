/*
 * 파일명: BoyerMooreHospoolTest.java
 * 작성자: 김기범
 * 작성일: 2020.06.20.
 * 내용: 보이어-무어-호스풀 알고리즘 수행
 */
package hw;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BoyerMooreHorspoolTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw12_1: 김기범");
		System.out.print("패턴 입력: ");
		String[] pArray = sc.next().split(""); // 패턴
		System.out.print("텍스트 입력: ");
		String[] tArray = sc.next().split(""); // 텍스트
		Map<String, Integer> jump = new HashMap<>(); // 점프 테이블
		jump = computeJump(pArray, jump);
		
		BoyerMooreHorspool(tArray, pArray, jump); // 알고리즘 작동
		
		sc.close();
	}
	
	static Map<String, Integer> computeJump(String[] p, Map<String, Integer> jump){ // 점프 테이블 초기화
		int m = p.length;
		
		jump.put(p[m-1], m); // 마지막 요소는 m만큼 점프
		
		for(int i = 0; i < m-1; i++) { // m-1 ~ 1까지 순차적으로 초기화
			jump.put(p[i], m-1-i);
		}
		
		return jump;
	}
	
	static void BoyerMooreHorspool(String[] t, String[] p, Map<String, Integer> jump) {
		int n = t.length; // 텍스트 길이
		int m = p.length; // 패턴 길이
		int index = m - 1;
		int jumpCount = 0; // 점프 수
		String matchIndex = ""; // 매칭 위치
		
		for(int i = 0; i <= n-m+1; i += index) {
			if(i == n-m+1) { // 매칭 시작 위치가 텍스트 마지막 요소라면
				break;
			}
			boolean matching = true; // 매칭 판단
			index = m;
			
			for(int j = m-1; j >= 0; j--) {
				if(t[i+j].compareTo(p[j]) != 0) { // 요소가 같지 않다면
					String nowString = t[i+j];
					Integer jumping = jump.get(nowString);
					
					if(jumping == null) { // 기타면 m만큼 점프
						index = m;
					}else {
						index = jumping; // 아니면 점프 테이블만큼 점프
					}
					
					matching = false;
					break;					
				}
			}
			
			if(matching) { // 매칭 성공이면 매칭 위치 추가
				matchIndex += i;
			}
			
			if(i + index <= n-m+1) { // 점프가 가능하면 점프 수 ++
				jumpCount++;
			}
		}

		// 매칭 위치 출력
		System.out.print("매칭 위치 =");
		if(matchIndex.compareTo("") != 0) {
			for(int i = 0; i < matchIndex.length(); i++) {
				System.out.print(" " + matchIndex.charAt(i));
			}
		}
		System.out.println();
		
		// 점프 수 출력
		System.out.print("점프 수 = " + jumpCount);
	}
}
