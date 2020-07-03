/*
 * 파일명: TopologicalSort.java
 * 작성자: 김기범
 * 작성일: 2020.06.08.
 * 내용: 위상 정렬 알고리즘 2 버전을 사용해 정렬하기
 */
package hw;

import java.util.Scanner;

public class TopologicalSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw10_2 : 김기범\n");
		
		System.out.println("위상 정렬을 수행합니다. DAG를 입력하세요.");
		System.out.print("정점 수 입력: ");
		int v = sc.nextInt(); // 정점 수 입력
		DirectedGraph dG = new DirectedGraph(v); // 그래프 생성
		System.out.print("간선 수 입력: ");
		int e = sc.nextInt(); // 간선 수 입력
		System.out.println();
		
		System.out.println(e + "개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for(int i = 1; i <= e; i++) {
			System.out.print("간선 " + i + " 입력: ");
			
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			dG.addEdge(v1, v2);
		}
		System.out.println();
		
		dG.printAdjacencyList(); // 그래프 결과 출력
		System.out.println();
		
		dG.printTS(); // 위상 순서 출력
		
		sc.close();
	}

}
