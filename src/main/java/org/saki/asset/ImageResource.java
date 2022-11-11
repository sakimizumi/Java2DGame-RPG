package org.saki.asset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageResource extends Resource {

    final String RESOURCE_FLOOR = "image/";
    public Image CUR_HAND;


    public ImageResource(){
        CUR_HAND = getImageResource("cur.png");
    }

    public Image getImageResource(String file){
        String path = RESOURCE_FLOOR + file;
        try {
            return ImageIO.read(getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
