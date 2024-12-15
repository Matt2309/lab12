package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mattiamularoni
 */
public class LogicsImpl implements Logics{

    final private int width;
    Random random;

    public LogicsImpl(int width){
        this.width = width;
        random = new Random();
    }

    @Override
    public List<Pair<Integer,Integer>> getInitialCells(int n) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Pair<>(random.nextInt(width), random.nextInt(width)));
        }
        return list;
    }

    @Override
    public List<Pair<Integer, Integer>> getCellsAround(Pair<Integer,Integer> cell) {
        System.out.println("Entering: "+cell.getX() + " " + cell.getY());
        List<Pair<Integer,Integer>> aroundCells = new ArrayList<>();
        for (int i = cell.getX()-1; i < cell.getX()+2; i++) {
            for (int j = cell.getY()-1; j < cell.getY()+2; j++) {
                aroundCells.add(new Pair<>(i, j));
            }
        }
        System.out.println("Eschering: ");
        aroundCells.forEach(a -> {
            System.out.println(a.getX() + " " + a.getY());
        });
        return aroundCells;
    }

}
