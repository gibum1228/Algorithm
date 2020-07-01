/*
 * 파일명: DirectedGraph.java
 * 작성자: 김기범
 * 작성일: 2020.06.08.
 * 내용: 방향 그래프를 인접 리스트를 표현하기 위한 구조
 */
package hw;

public class DirectedGraph {

	private Node[] list; // 인접 리스트를 가리키는 변수
	private int n; // 정점 수
	private boolean[] visited; // 방문 여부 판단
	Node r = new Node(); // 위상 정렬 결과 담을 연결 리스트
	
	
	// 생성자
	public DirectedGraph() { };
	public DirectedGraph(int size) {
		this.n = size;
		list = new Node [size];
		visited = new boolean [size];
		
		for(int i = 0; i < n; i++) {
			list[i] = new Node();
		}
	}
	
	// 간선 추가 메소드
	public void addEdge(int v1, int v2) {
		if(v1 < 0 || v1 > n - 1) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <" + v1 + ", " + v2 + ">");
		}else if(v2 < 0 || v2 > n-1) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <" + v1 + ", " + v2 + ">");
		}else if(v1 == v2) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다. <" + v1 + ", " + v2 + ">");
		}else {
			Node tmp = list[v1];
			Node newNode = new Node(v2);
			
			if(tmp.vertex == -1) {
				list[v1] = newNode; // !!!루트(헤드)에다가 뉴 노드 값 넣기 + 이게 가장 중요한 부분(첫 단추 부분) -> t = newNode;로 했기 때문에 노드가 제대로 연결 안 됨
			}else {
				Node p = tmp;
				
				while(tmp != null) {
					p = tmp;
					tmp = tmp.next;
				}
				
				p.next = newNode;
			}
		}
	}
	// 출력 확인 메소드
	public void printAdjacencyList() {
		for(int i = 0; i < n; i++) {
			Node t = list[i];
			
			System.out.print("정점 " + i + "에 인접한 정점 =");
			
			while(t != null) {
				if(t.vertex == -1) { // vertex 값이 -1이면 간선이 없는 것으로 판단
					break;
				}
				
				System.out.print(" " + t.vertex);
				t = t.next;
			}
			
			System.out.println();
		}
	}
	// 위상 정렬 버전 2
	public void TSTwo() {
		for(int i = 0; i < n; i++) { // 모두 방문하지 않음으로 초기화
			visited[i] = false;
		}
		for(int j = 0; j < n; j++) { // 방문 하지 않은 정점으로부터 깊이 우선 탐색 시작
			if(visited[j] == false) {
				DFS_TS(j);
			}
		}
	}
	// DFS
	public void DFS_TS(int v){
		visited[v] = true; // 방문 했음으로 체크
		Node x = list[v]; // 현재 포커싱 되어있는 노드 x
		
		while(x != null) { // 다음 노드가 없으면 종료
			if(x.vertex == -1) { // 연결된 노드가 없으면 종료
				break;
			}
			
			if(visited[x.vertex] == false) { // 현재 노드를 방문했는지 검사
				DFS_TS(x.vertex);
			}
			
			x = x.next;
		}
		
		Node newNode = new Node(v);
		if(r.vertex == -1) { // 연결 리스트 R에 삽입
			r = newNode;
		}else {
			Node p = r;
			
			r = newNode;
			r.next = p;
		}
	}
	// 위상 정렬 출력
	public void printTS() {
		TSTwo(); // 위상 순서 만들기
		
		Node t = r;
		
		System.out.print("위상 정렬 결과:");
		while(t != null) {
			System.out.print(" " + t.vertex);
			
			t = t.next;
		}
	}
	
	// 노드 클래스
	private class Node {
		int vertex; // 정점 번호
		Node next; // 다음 노드를 가리키는 next
		
		// 생성자
		public Node() { // 첫 노드인 걸 확인하기 위해
			this.vertex = -1; // 헤드 노드 초기값 -1
			this.next = null;
		}
		public Node(int v2) {
			this.vertex = v2;
			this.next = null;
		}
		
	}
}