public class PraktikumBuilder{
	private Builder b;
	
	public static class Builder{
		private Asisten a1,a2;
		private Praktikan p1,p2,p3,p4;
		private int[] map;
		
		public void setA1(Asisten a1){
			this.a1 = a1;
		}
		
		public void setA2(Asisten a2){
			this.a2 = a2;
		}
		
		public void setP1(Praktikan p1){
			this.p1 = p1;
		}
		
		public void setP2(Praktikan p2){
			this.p2 = p2;
		}
		
		public void setP3(Praktikan p3){
			this.p3 = p3;

		}
		
		public void setP4(Praktikan p4){
			this.p4 = p4;
		}
		
		public void setMap(int[] map){
			this.map = map;
		}
		
	}
	
	public PraktikumBuilder(Builder b){
		this.b = new Builder ();
	}
	
	public void buildA1 () {
		Asisten a1 = new Asisten(0,0);
		b.setA1(a1);
	}
	
	public void buildA2 () {
		Asisten a2 = new Asisten(4,0);
		b.setA2(a2);
	}
	
	public void buildP1 () {
		Praktikan p1 = new Praktikan();
		b.setP1(p1);
	}
	
	public void buildP2 () {
		Praktikan p2 = new Praktikan();
		b.setP2(p2);
	}
	
	public void buildP3 () {
		Praktikan p3 = new Praktikan();
		b.setP3(p3);
	}
	
	public void buildP4 () {
		Praktikan p4 = new Praktikan();
		b.setP4(p4);
	}
	
	public Builder getBuilder() {
		return this.b;
	}
	
	public void BuildWorld () {
		this.buildA1();
		this.buildA2();
		this.buildP1();
		this.buildP2();
		this.buildP3();
		this.buildP4();
	}
}



