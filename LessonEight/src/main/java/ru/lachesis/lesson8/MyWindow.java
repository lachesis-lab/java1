package ru.lachesis.lesson8;

import javax.management.monitor.MonitorSettingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame {
    private boolean isAlive = true;
    private final int size;
    private Cell[] cells;

    public MyWindow(final int SIZE) {
        this.size = SIZE;
        cells = new Cell[SIZE * SIZE];
        setBounds(300, 300, SIZE*70, SIZE*70);
        setTitle("Bombs and Death");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));
        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton jButton = new JButton();
                cells[i * SIZE + j] = new Cell(i, j, jButton, bombs[i][j]);
                int ii = i;
                int jj = j;
                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        if (SwingUtilities.isRightMouseButton(e)) {
                            cells[ii * SIZE + jj].mark();
                        }
                    }
                });
                jButton.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (cells[ii * SIZE + jj].getBomb()){
                        showBombs();
                        isAlive = false;
                        cells[ii * SIZE + jj].open("");
                    }
                    else
                        cells[ii * SIZE + jj].open(getCellsAround(cells[ii * SIZE + jj]) + "");
                });
                add(jButton);
            }
        }
//        pack();
        setVisible(true);

    }

    private void showBombs() {
        for (int i=0; i<cells.length;i++){
            if (cells[i].getBomb())  cells[i].open("");
        }
    }

    private int getCellsAround(Cell cell) {
        int count = 0;
        int minX = Math.max(0, cell.getX() - 1);
        int maxX = Math.min(size - 1, cell.getX() + 1);
        int minY = Math.max(0, cell.getY() - 1);
        int maxY = Math.min(size - 1, cell.getY() + 1);
        int k = 0;

        Cell[] cellsAround = new Cell[(maxX - minX + 1) * (maxY - minY + 1) - 1];
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (i == cell.getX() && j == cell.getY()) continue;
                else {
                    cellsAround[k++] = cells[i * size + j];
                    if (cells[i * size + j].getBomb()) count++;
                }
            }
        }
        cell.open(count + "");
        if (count == 0) {
            for (int i = 0; i < cellsAround.length; i++) {
                if (!cellsAround[i].getOpen()) {
                    count = getCellsAround(cellsAround[i]);
                    cellsAround[i].open(count + "");
                }
            }
        }

        return count;

    }

}
