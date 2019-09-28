package domains;

/**
 * Top abstract value class.
 *
 * It represents the TOP value for all the abstract values, hence
 * it's implemented with a singleton pattern and can be instantiated
 * using the method getInstance.
 */
public class TopAV extends AbstractValue {

	/** The only instance of TopAV */
	private static TopAV ilSoloEUnico = new TopAV();

	private TopAV(){
		//ntd
	}

	/**
	 * Return the only instance of TopAV.
	 */
	public static TopAV getInstance(){
		return ilSoloEUnico;
	}

	public boolean equals(AbstractValue av) {
		return this == av;
	}
}
