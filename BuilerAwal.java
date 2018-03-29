public class PraktikumBuilder{
	private final Asisten a1,a2;
	private final Praktikan p1,p2,p3,p4;
	private final int[] map;
	
	public static class Builder{
		private Asisten a1,a2;
		priavte Praktikan p1p1,p2,p3,p4;
		private int[] map;
		
		public Builder a1(Asisten a1){
			this.a1 = a1;
			return this;
		}
		
		public Builder a2(Asisten a2){
			this.a2 = a2;
			return this;
		}
		
		public Builder p1(Praktikan p1){
			this.p1 = p1;
			return this;
		}
		
		public Builder p2(Praktikan p2){
			this.p2 = p2;
			return this;
		}
		
		public Builder p3(Praktikan p3){
			this.p3 = p3;
			return this;
		}
		
		public Builder p4(Praktikan p4){
			this.p4 = p4;
			return this;
		}
		
		public Builder map(int[] map){
			this.map = map;
			return this;
		}
		
		public PraktikumBuilder build(){
			return new PraktikumBuilder(this);
		}
	}
	
	private PraktikumBuilder(Builder b){
		this.a1 = b.a1;
		this.a2 = b.a2;
		this.p1 = b.p1;
		this.p2 = b.p2;
		this.p3 = b.p3;
		this.p4 = b.p4;
		this.map = b.map;
	}
}
