package barri;


public abstract class RDistancia extends RestriccioBarris implements RMax, REspai{

	protected Espai e;
	int dist;
	boolean max;

        /**
         * Crea una instancia de la restricció de distancia.
         * @param ID Identificador de la distancia.
         * @param d Distancia que aplicara la restricció.
         * @param m Indica si la distancia es mínima o màxima.
         * @param e Espai sobre el que s'aplicarà la restricció.
         */
	public RDistancia(int ID, int d, boolean m, Espai e) {
		super(ID);
		dist = d;
		max = m;
		this.e = e;

	}

        /**
         * Calcula la distancia entre dos coordenades.
         * @param x1 Coordenada X del primer element.
         * @param y1 Coordenada Y del primer element.
         * @param x2 Coordenada X del segon element.
         * @param y2 Coordenada Y del segon element.
         * @return La distancia entre les dos coordenades.
         */
	protected int dist(int x1, int y1, int x2, int y2) {
		int x, y;
		x = x1 - x2;
		if (x < 0)
			x = x * (-1);
		y = y1 - y2;
		if (y < 0)
			y = y * (-1);

		int d = (x + y);
		return d;
	}

        /**
         * Calcula la distancia entre dos coordenades.
         * @param x1 Coordenada X del primer element.
         * @param y1 Coordenada Y del primer element.
         * @param x2 Coordenada X del segon element.
         * @param y2 Coordenada Y del segon element.
         * @return La distancia entre les dos coordenades.
         */
	protected double distd(int x1, int y1, int x2, int y2) {
		int x, y;
		x = x1 - x2;
		y = y1 - y2;

		double d = Math.sqrt(x * x + y * y);
		return d;
	}
	
	/**
         * Consulta la distancia assignada a la restricció. 
         * @return La distancia assignada a la restricció.
         */
	public int ConsultarDist() {
		return dist;
	}
	
        /**
         * Modifica la distancia assignada a la restricció.
         * @param d Nova distancia assignada a la restricció.
         */
	public void ModificarDist(int d) {
		dist = d;
	}
	
        /**
         * Consulta si la distancia assignada es màxima o mínima.
         * @return Cert si la distancia assignada es màxima.
         */
	public boolean EsMax() {
		return max;
	}
	
        /**
         * Modifica si la distancia assignada es màxima o mínima.
         * @param m Indica si la distancia assignada es màxima o mínima.
         */
	public void CanviaMax(boolean m) {
		max = m;
	}
	
        /**
         * Assigna l'espai on s'aplicarà la restrició.
         * @param e Espai on s'aplicarà la restricció.
         */
	public void AssignaEspai(Espai e) {
		this.e = e;
	}
}
