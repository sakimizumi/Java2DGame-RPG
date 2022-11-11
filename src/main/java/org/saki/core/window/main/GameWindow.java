package org.saki.core.window.main;
import org.saki.game.Const;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    GamePanel panel = new GamePanel();
    public void init(String[] args){
        panel = new GamePanel();
        panel.init();
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setName(Const.GAME_NAME);
        this.setTitle(Const.GAME_NAME);
        this.setLocationRelativeTo(null);
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Const.imageResource.CUR_HAND,new Point(1,1),"HAND"));
        this.setVisible(true);
    }

    public void start(){
        panel.startGameThread();

    }
}
