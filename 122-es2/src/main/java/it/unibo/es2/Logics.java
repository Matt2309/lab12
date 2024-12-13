package it.unibo.es2;

public interface Logics {
	/**
	 * @return the *
	 */
	String setButton(Pair<Integer,Integer> location);

    /**
	 * @return true if column or row full
	 */
	boolean isToQuit();
}
