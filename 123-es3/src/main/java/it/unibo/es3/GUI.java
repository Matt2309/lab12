package it.unibo.es3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class GUI extends JFrame {
    private final Logics logic;
    private final static int INITIAL_CELLS = 3;
    private final List<Pair<Integer,Integer>> intiialCoordinates;
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();

    public GUI(int width) {
        logic = new LogicsImpl(width);
        intiialCoordinates = logic.getInitialCells(INITIAL_CELLS);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);
        
        
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                JButton jb = new JButton();
                for (Pair<Integer, Integer> coordinate : intiialCoordinates) {
                    if(i == coordinate.getX() && j == coordinate.getY()){
                        jb.setText("*");
                    }
                }
                panel.add(jb);
                cells.put(new Pair<>(i, j), jb);
            }
        }

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        // Associa il tasto 'W' a una azione chiamata "sayHello"
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "sayHello");

        // Definisci l'azione
        actionMap.put("sayHello", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pair<Integer, Integer>> initialStarKeys = cells.entrySet().stream()
                    .filter(entry -> "*".equals(entry.getValue().getText()))
                    .map(Map.Entry::getKey)
                    .toList();

                initialStarKeys.forEach(key -> {
                    logic.getCellsAround(key).forEach(cor -> {
                        if (cells.containsKey(cor)) {
                            cells.get(cor).setText("*");
                        }
                    });
                });
            }
        });
        this.setVisible(true);
    }
    
}