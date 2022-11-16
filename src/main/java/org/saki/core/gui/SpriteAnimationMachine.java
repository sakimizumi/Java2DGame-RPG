package org.saki.core.gui;

import org.saki.core.widget.IView;
import org.saki.game.Const;

import java.awt.*;
import java.util.HashMap;

/**
 * SpriteAnimationGroup manage a group of Animation can't play at same time
 */
public class SpriteAnimationMachine implements IView {
    HashMap<String,SpriteAnimation> map = new HashMap<>();
    private int x;
    private int y;
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
        changeAnimPos();
    }
    public void add(SpriteAnimation animation) {
        map.put(animation.getName(),animation);
    }
    private String animName = "idle";
    private String oldAnimName = "idle";
    private int frameId = 0;
    private int count = 0;
    public void Change(String anim,boolean loop){
        if(!animName.equals(anim)){
            oldAnimName = animName;
            animName = anim;
            frameId = 0;
            changeAnimPos();
        }
    }
    private boolean isLoop = false;
    public void Change(String anim){
        this.Change(anim,false);
    }
    private void changeAnimPos(){
        SpriteAnimation animation = map.get(animName);
        if(animation != null){
            animation.setPos(x, y);
        }
    }
    @Override
    public void Render(Graphics g) {
        SpriteAnimation animation = map.get(animName);
        if(animation != null){
            animation.getFrame(frameId).Render(g);
        }else{
            animation = map.get(oldAnimName);
            animation.getFrame(0).Render(g);
        }
    }

    @Override
    public void Update() {
        if(count++ > Const.FPS / 8){
            frameId++;
            count = 0;
            SpriteAnimation animation = map.get(animName);
            if(animation != null && (animation.getFrameLength() - 1) < frameId){
                frameId = 0;
            }
        }

    }
}
