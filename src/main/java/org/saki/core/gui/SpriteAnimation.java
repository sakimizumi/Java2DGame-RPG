package org.saki.core.gui;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class SpriteAnimation {
    private String name;
    private List<BufferedImage> frames = new LinkedList<>();
    public String getName(){
        return name;
    }

    public SpriteAnimation(String name,BufferedImage... images){
        this.name = name;
        this.frames.addAll(List.of(images));
    }

    public SpriteAnimation addFrame(BufferedImage image){
        frames.add(image);
        return this;
    }
    public BufferedImage getFrame(int index){
        if(index < frames.size()){
            return frames.get(index);
        }
        return null;
    }
}
