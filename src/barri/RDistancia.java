package barri;


public abstract class RDistancia extends RestriccioBarris implements RMax, REspai{

	protected Espai e;
	int dist;
	boolean max;

	public RDistancia(int ID, int d, boolean m, Espai e) {
		super(ID);
		dist = d;
		max = m;
		this.e = e;

	}

	protected int dist(int x1, int y1, int x2, int y2) {
		int x, y;
		x = x1 - x2;
		if (x < 0)
			x = x * (-1);
		y = y1 - y2;
		if (y < 0)
			y = y * (-1);

		// int d = (int)Math.sqrt(x*x + y*y);
		int d = (x + y);
		return d;
	}

	protected double distd(int x1, int y1, int x2, int y2) {
		int x, y;
		x = x1 - x2;
		// if (x < 0) x = x*(-1);
		y = y1 - y2;
		// if (y < 0) y = y*(-1);

		double d = Math.sqrt(x * x + y * y);
		return d;
	}
	
	
	public int ConsultarDist() {
		return dist;
	}
	
	public void ModificarDist(int d) {
		dist = d;
	}
	
	public boolean EsMax() {
		return max;
	}
	
	public void CanviaMax(boolean m) {
		max = m;
	}
	
	public void AssignaEspai(Espai e) {
		this.e = e;
	}
	


}
