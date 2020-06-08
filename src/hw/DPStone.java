/*
 * ���ϸ�: DPStone.java
 * �ۼ���: ����
 * �ۼ���: 2020.05.22.
 * ����: �� ���� ������ ���� ���α׷������� �����ϱ�
 */
package hw;

public class DPStone {

	public static void main(String[] args) {
		System.out.println("hw8_2: ����\n");
		
		int n = (int)(Math.random() * 100) + 1; // ũ�⸦ ������ ���ϱ�
		
		int[][] a = new int [n + 1][4]; // 3 x n������, �ؿ� �޼ҵ�� �ϰ����� ���� n x 3���� ����
		
		for(int i = 1; i < n + 1; i++) { // ������ �ʱ�ȭ
			for(int j = 1; j < 4; j++) {
				a[i][j] = (int)(Math.random() * 500) + 1;
			}
		}
		
		int[][] w = makeP(n, a);
		
		System.out.println("���: " + pebble(n, w));
	}

	// ����ڰ� ���� 3 x n�� a �迭�� ���ϰ��� �������� �����
	static int [][] makeP(int n, int[][] a){
		int[][] w = new int [n + 1][5]; // ���ϰ��� ��� �ִ� ����Ʈ w
		
		for(int i = 1; i < n+1; i++) {
			for(int p = 1; p < 5; p++) {
				if(p == 4) { // ����4�� ���� ���ϱ� ���� 1, 3 ��° ������ ����
					w[i][p] = a[i][1] + a[i][3];
				}else { // 1, 2, 3�� �״�� ���� �޾� ��
					w[i][p] = a[i][p];
				}
			}
		}
		
		return w;
	}
	
	// ���� �� ���ϴ� �޼ҵ�
	static int pebble(int n, int[][] w) {
		int[][] peb = new int [n+1][5]; // ���� ���� ���� �� ���ϱ�
		
		// ������ �ʱ�ȭ
		for(int p = 1; p < 5; p++) {
			peb[1][p] = w[1][p];
		}
		
		// �� ���� ���Ͽ� �˸´� �� ���ϱ�
		for(int i = 2; i < n + 1; i++) {
			for(int p = 1; p < 5; p++) {
				switch(p) { // ���� ��Ģ�� �°� �� �ֱ�
				case 1: // ���� 1�� ��� 2, 3�� ��
					if(peb[i-1][2] > peb[i-1][3]) { 
						peb[i][p] = peb[i-1][2] + w[i][p];
					}else {
						peb[i][p] = peb[i-1][3] + w[i][p];
					}
					
					break;
					
				case 2: // ���� 2�� ��� 1, 3, 4�� ��
					int max = peb[i-1][1];
					for(int j = 3; j < 5; j++) {
						if(max < peb[i-1][j]) {
							max = peb[i-1][j];
						}
					}
					
					peb[i][p] = max + w[i][p];
					
					break;
					
				case 3: // ���� 3�� ��� 1, 2�� ��
					if(peb[i-1][1] > peb[i-1][2]) {
						peb[i][p] = peb[i-1][1] + w[i][p];
					}else {
						peb[i][p] = peb[i-1][2] + w[i][p];
					}
					
					break;
					
				case 4: // ���� 4�� ��� 2
					peb[i][p] = peb[i-1][2] + w[i][p];
					
					break;
				}
			}
		}
		
		// ������ ���� ���� ������ �ִ� ��
		int result = peb[n][1];
		for(int j = 2; j < 5; j++) {
			if(result < peb[n][j]) {
				result = peb[n][j];
			}
		}
		
		return result;
	}
}
