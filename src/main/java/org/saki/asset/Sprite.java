package org.saki.asset;


import org.saki.core.widget.IView;

import javax.swing.text.View;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite implements IView {
    private BufferedImage image;

    public Sprite(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void Render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(this.image,getStartX() - (getWidth() / 2),getStartY() - (getHeight() / 2),getWidth(),getHeight(),null);
    }

    @Override
    public void Update() {

    }


}
