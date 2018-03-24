public class PraktikumBuilder {
	private String[][] w;
	private double[][] w2; //untuk pathfinding
	
	
	public PraktikumBuilder () {
		w = new String[5][5];
		for (int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 4; j++) { 
				w[i][j] = "0";
			}
		}
		
		w2 = new double[5][5];
		for (int k = 0; k < 5; k++){
			for (int l = 0; l < 5; l++){
				w2[k][l] = 1;
			}
		}
	}
	
	public double[][] getMap(){
		return w2;
	}
	
	public void Insert (int x, int y, int no) {
		w[x][y] = Integer.toString(no);
		w2[x][y] = 20;
	}
	
	public void moveLeft (int x, int y) {
		if (x > 1) {
			String temp = w[x][y];
			w[x][y] = w[x-1][y];
			w[x-1][y] = temp;
		}
	}
	
	public void moveRight (int x, int y) {
		if (x < 5) {
			String temp = w[x][y];
			w[x][y] = w[x+1][y];
			w[x+1][y] = temp;
		}
	}
				
	public void moveUp (int x, int y) {
		if (y > 1) {
			String temp = w[x][y];
			w[x][y] = w[x][y-1];
			w[x][y-1] = w[x][y];
		}
	}
	
	public void moveDown (int x, int y) {
		if (y < 5) {
			String temp = w[x][y];
			w[x][y] = w[x][y+1];
			w[x][y+1] = w[x][y];
		}
	}
	
	public void printRoom () {
		for (int j = 0; j <= 4; j++) {
			for(int i = 0; i <= 4; i++) { 
				System.out.print(w[i][j]);
			}
			System.out.println("");
		}
	}
}
