package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mattiamularoni
 */
public class LogicsImpl implements Logics{
    
    final private int size;
    ArrayList<ArrayList<String>> grid;
    public LogicsImpl(int size) {
		this.size = size;
        grid = new ArrayList<>(size);
        List<String> tmp = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            tmp.add("");
        }
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>(tmp));
        }
	}

    @Override
    public String setButton(Pair<Integer,Integer> location) {
        grid.get(location.getX()).set(location.getY(), "*");
        return "*";
    }
    
    @Override
    public boolean isToQuit() {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tmp.clear();
            for (int j = 0; j < size; j++) {
                if(grid.get(j).stream().allMatch((a) -> a.equals("*"))) {
                    return true;
                }
                tmp.add(grid.get(j).get(i));
            }
            if(tmp.stream().allMatch((a) -> a.equals("*"))) {
                return true;
            }
        }
        return false;
    }
}
