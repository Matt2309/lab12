package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mattiamularoni
 */
public class LogicsImpl implements Logics{

    final private int width;
    public LogicsImpl(int width){
        this.width = width;
    }

    @Override
    public List<Pair<Integer,Integer>> getInitialCells(int n) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair<>((int) (Math.random() * width), (int) (Math.random() * width)));
        }
        return list;
    }

}
