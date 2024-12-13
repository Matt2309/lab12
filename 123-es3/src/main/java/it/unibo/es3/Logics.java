package it.unibo.es3;

import java.util.List;

/**
 *
 * @author mattiamularoni
 */
public interface Logics {
    /**
	 * @return the intial random cells
	 */
    List<Pair<Integer,Integer>> getInitialCells(int n);
}
