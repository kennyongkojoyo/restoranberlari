public class Map{
	private Existence[][] map;
	private int rows;
	private int cols;
	
	public Map(int rows, int cols, Existence a, Existence border){
		this.rows = rows;
		this.cols = cols;
		map = new Existence[rows][cols];
		
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if ((i == 0) || (j == 0) || (i == rows - 1) || (j == cols - 1)){
					map[i][j] = border;
				}else{
					map[i][j] = a;
				}
			}
		}
	}
	
	public Existence[][] getMap(){
		return map;
	}
	
	public void insert(int x, int y, Existence tag){
		map[x][y] = tag;
	}
	
	public void moveLeft(int x, int y){
		Existence temp = map[x][y];
		map[x][y] = map[x][y-1];
		map[x][y-1] = temp;
	}
	
	public void moveRight(int x, int y){
		Existence temp = map[x][y];
		map[x][y] = map[x][y+1];
		map[x][y+1] = temp;
	}
	
	public void moveUp(int x, int y){
		Existence temp = map[x][y];
		map[x][y] = map[x-1][y];
		map[x-1][y] = temp;
	}
	
	public void moveDown(int x, int y){
		Existence temp = map[x][y];
		map[x][y] = map[x+1][y];
		map[x+1][y] = temp;
	}
	
	public void printRoom(){
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				System.out.print(map[i][j].getSomething().toString());
			}
			System.out.println("");
		}
	}
}

