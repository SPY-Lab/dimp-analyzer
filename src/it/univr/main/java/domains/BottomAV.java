package domains;

/**
 * Singleton class representing abstract value with bottom value.
 */
public class BottomAV extends AbstractValue {

	private static BottomAV ilSoloEUnico = new BottomAV();

	private BottomAV(){
		//ntd
	}

	public static BottomAV getInstance(){
		return ilSoloEUnico;
	}

	public boolean equals(Object av) {
		return this == av;
	}

	@Override
	public String toString() {
		return "BottomValue";
	}
}
