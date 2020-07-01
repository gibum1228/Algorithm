/*
 * 파일명: DirectedGraphTest.java
 * 작성자: 김기범
 * 작성일: 2020.06.08.
 * 내용: 방향 그래프를 인접 리스트로 표현하기
 */
package hw;

import java.util.Scanner;

public class DirectedGraphTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("hw10_1 : 김기범\n");
		System.out.print("정점 수 입력: ");
		int v = sc.nextInt(); // 정점 수
		DirectedGraph dG = new DirectedGraph(v); // 크기 v의 인접 리스트 생성
		System.out.print("간선 수 입력: ");
		int e = sc.nextInt(); // 간선 수
		System.out.println();
		
		System.out.println(e + "개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for(int i = 1; i <= e; i++) {
			System.out.print("간선" + i + " 입력: ");
			
			int v1 = sc.nextInt(); // 정점 번호 2개
			int v2 = sc.nextInt(); 
			
			dG.addEdge(v1, v2);
		}
		
		System.out.println();
		dG.printAdjacencyList();
		
		sc.close();
	}

}
