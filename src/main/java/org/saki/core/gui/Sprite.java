package org.saki.core.gui;


import org.saki.core.widget.IView;

import javax.swing.text.View;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite implements IView {
    private BufferedImage image;
    private int startX;
    private int startY;
    public BufferedImage getImage() {
        return image;
    }

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void Render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image,startX,startY,32,32,null);
    }

    @Override
    public void Update() {

    }
    public void setPos(int x,int y){
        this.startX = x;
        this.startY = y;
    }

}
