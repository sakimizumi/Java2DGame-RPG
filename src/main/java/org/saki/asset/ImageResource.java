package org.saki.asset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageResource extends Resource {

    final String RESOURCE_FLOOR = "image/";
    public BufferedImage CUR_HAND;
    public BufferedImage SHEET_PLAYER;

    public ImageResource(){
        CUR_HAND = getImageResource("cur.png");
        SHEET_PLAYER = getImageResource("character/character1.png");
    }

    public BufferedImage getImageResource(String file){
        String path = RESOURCE_FLOOR + file;
        try {
            return ImageIO.read(getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
