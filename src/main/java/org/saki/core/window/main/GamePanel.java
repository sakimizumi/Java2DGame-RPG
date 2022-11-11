package org.saki.core.window.main;

import org.saki.core.StateMachine;
import org.saki.game.Const;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {


    public void init() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(Const.WIDTH, Const.HEIGHT));
        this.setFocusable(true);
        stateMachine = new StateMachine();
        this.addKeyListener(stateMachine.keyHandler);

    }

    Thread thread;
    StateMachine stateMachine;

    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / Const.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (thread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                stateMachine.Update();
                this.repaint();
                delta--;
            }

        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        stateMachine.Render(g);
    }
}
