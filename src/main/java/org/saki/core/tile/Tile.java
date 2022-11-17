package org.saki.core.tile;

import org.saki.core.widget.IView;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile{
    public BufferedImage image;
    public boolean collision = false;
    public Tile(BufferedImage image){
        this.image = image;
    }

}
