/*
 * ���ϸ�: DirectedGraph.java
 * �ۼ���: ����
 * �ۼ���: 2020.06.08.
 * ����: ���� �׷����� ���� ����Ʈ�� ǥ���ϱ� ���� ����
 */
package hw;

public class DirectedGraph {

	private Node[] list; // ���� ����Ʈ�� ����Ű�� ����
	private int n; // ���� ��
	private boolean[] visited; // �湮 ���� �Ǵ�
	Node r = new Node(); // ���� ���� ��� ���� ���� ����Ʈ
	
	
	// ������
	public DirectedGraph() { };
	public DirectedGraph(int size) {
		this.n = size;
		list = new Node [size];
		visited = new boolean [size];
		
		for(int i = 0; i < n; i++) {
			list[i] = new Node();
		}
	}
	
	// ���� �߰� �޼ҵ�
	public void addEdge(int v1, int v2) {
		if(v1 < 0 || v1 > n - 1) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <" + v1 + ", " + v2 + ">");
		}else if(v2 < 0 || v2 > n-1) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <" + v1 + ", " + v2 + ">");
		}else if(v1 == v2) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�. <" + v1 + ", " + v2 + ">");
		}else {
			Node tmp = list[v1];
			Node newNode = new Node(v2);
			
			if(tmp.vertex == -1) {
				list[v1] = newNode; // !!!��Ʈ(���)���ٰ� �� ��� �� �ֱ� + �̰� ���� �߿��� �κ�(ù ���� �κ�) -> t = newNode;�� �߱� ������ ��尡 ����� ���� �� ��
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
	// ��� Ȯ�� �޼ҵ�
	public void printAdjacencyList() {
		for(int i = 0; i < n; i++) {
			Node t = list[i];
			
			System.out.print("���� " + i + "�� ������ ���� =");
			
			while(t != null) {
				if(t.vertex == -1) { // vertex ���� -1�̸� ������ ���� ������ �Ǵ�
					break;
				}
				
				System.out.print(" " + t.vertex);
				t = t.next;
			}
			
			System.out.println();
		}
	}
	// ���� ���� ���� 2
	public void TSTwo() {
		for(int i = 0; i < n; i++) { // ��� �湮���� �������� �ʱ�ȭ
			visited[i] = false;
		}
		for(int j = 0; j < n; j++) { // �湮 ���� ���� �������κ��� ���� �켱 Ž�� ����
			if(visited[j] == false) {
				DFS_TS(j);
			}
		}
	}
	// DFS
	public void DFS_TS(int v){
		visited[v] = true; // �湮 �������� üũ
		Node x = list[v]; // ���� ��Ŀ�� �Ǿ��ִ� ��� x
		
		while(x != null) { // ���� ��尡 ������ ����
			if(x.vertex == -1) { // ����� ��尡 ������ ����
				break;
			}
			
			if(visited[x.vertex] == false) { // ���� ��带 �湮�ߴ��� �˻�
				DFS_TS(x.vertex);
			}
			
			x = x.next;
		}
		
		Node newNode = new Node(v);
		if(r.vertex == -1) { // ���� ����Ʈ R�� ����
			r = newNode;
		}else {
			Node p = r;
			
			r = newNode;
			r.next = p;
		}
	}
	// ���� ���� ���
	public void printTS() {
		TSTwo(); // ���� ���� �����
		
		Node t = r;
		
		System.out.print("���� ���� ���:");
		while(t != null) {
			System.out.print(" " + t.vertex);
			
			t = t.next;
		}
	}
	
	// ��� Ŭ����
	private class Node {
		int vertex; // ���� ��ȣ
		Node next; // ���� ��带 ����Ű�� next
		
		// ������
		public Node() { // ù ����� �� Ȯ���ϱ� ����
			this.vertex = -1; // ��� ��� �ʱⰪ -1
			this.next = null;
		}
		public Node(int v2) {
			this.vertex = v2;
			this.next = null;
		}
		
	}
}