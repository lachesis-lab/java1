package ru.lachesis.lesson8;

import javax.swing.*;
import java.awt.*;

public class Cell {
    private int x;
    private int y;
    JButton button;
    private boolean isBomb;
    private boolean isOpen;

    public Cell(int x,int y,JButton button, boolean isBomb){
        this.x=x;
        this.y=y;
        this.button=button;

        this.isBomb=isBomb;
        this.isOpen=false;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public JButton getButton(){
        return button;
    }
    public boolean getBomb(){
        return isBomb;
    }
    public boolean getOpen(){
        return isOpen;
    }
    public void setOpen(){
        isOpen=true;
    }
    public void open(String text){

        float fontHeight = button.getHeight()-2*Math.max(button.getInsets().top,button.getInsets().left)-2.F;
        button.setFont(button.getFont().deriveFont(fontHeight));
        button.setForeground(Color.BLACK);
        if (isOpen) return;
        isOpen=true;
        if (isBomb) {
            button.setText("\u2620");

        } else   button.setText(text);
    }
    public void mark(){
        if (isOpen) return;
        float fontHeight = button.getHeight()-2*Math.max(button.getInsets().top,button.getInsets().left)-2.F;
        button.setFont(button.getFont().deriveFont(fontHeight));
        if (button.getText().isEmpty()) {
            button.setText("\u2620");
            button.setForeground(Color.GRAY);
        } else {
            button.setText("");
            button.setForeground(Color.BLACK);

        }
    }
    public void setjButtonText(String text){
        button.setText(text);
    }
}
