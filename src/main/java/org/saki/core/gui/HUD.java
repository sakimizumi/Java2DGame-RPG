package org.saki.core.gui;

import org.saki.core.widget.IView;
import org.saki.game.Const;

import java.awt.*;

public class HUD implements IView {

    private int TIP_DURATION = 0;
    private boolean showTip = false;
    private int count_tip = 0;
    private String text_tip = "";

    public void showTip(String text){
       this.showTip(text,0);
    }
    public void showTip(String text,int duration){
        text_tip = text;
        TIP_DURATION = duration;
        showTip = true;
    }



    /**
     *  Impl IView
     */
    @Override
    public void Render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        if(showTip){
            graphics2D.drawString(text_tip,Const.DEFAULT_TIP_POS_X,Const.DEFAULT_TIP_POS_Y);
        }
    }

    @Override
    public void Update() {
        if(showTip && ((count_tip++ / Const.FPS)  >= TIP_DURATION)) {
            showTip = false;
        }
    }

}
