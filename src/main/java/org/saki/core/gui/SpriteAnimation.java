package org.saki.core.gui;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class SpriteAnimation {
    private String name;
    private List<Sprite> frames = new LinkedList<>();
    public String getName(){
        return name;
    }

    public SpriteAnimation(String name,Sprite... sprites){
        this.name = name;
        if(sprites.length > 0){
            this.frames.addAll(List.of(sprites));
        }
    }

    public SpriteAnimation addFrame(Sprite image){
        frames.add(image);
        return this;
    }
    public Sprite getFrame(int index){
        if(index < frames.size()){
            return frames.get(index);
        }
        return null;
    }

    public int getFrameLength() {
        return frames.size();
    }

    public void setPos(int x, int y) {
        this.frames.forEach(item->{
            item.setPos(x,y);
        });
    }
}
