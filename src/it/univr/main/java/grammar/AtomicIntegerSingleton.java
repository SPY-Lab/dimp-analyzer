package grammar;

/**
 * Singleton class used to assign uniquely an integer ID to CFG nodes.
 */
public class AtomicIntegerSingleton {
	private static AtomicIntegerSingleton ilSoloEUnico;
	private int index;

	private AtomicIntegerSingleton() {
		this.index = 0;
	}

	public static AtomicIntegerSingleton getInstance(){
		if (ilSoloEUnico == null)
			ilSoloEUnico = new AtomicIntegerSingleton();
		return ilSoloEUnico;
	}

	/**
	 * Return current index and update its value.
	 * @return current indent
	 */
	public synchronized int getAndIncrement() {
		return index++;
	}
}
