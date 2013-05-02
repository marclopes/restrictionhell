package barri;

public class DriverCtrDomRestriccio {
	CtrDomRestriccio cr;

	public DriverCtrDomRestriccio() {
		cr = CtrDomRestriccio.ObteInstancia()
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DriverCtrDomRestriccio driv = new DriverCtrDomRestriccio();
		
		pr("Op");

	}
	
	
	
	
	private void pr(String s) {
		System.out.println(s);
	}
	

}
