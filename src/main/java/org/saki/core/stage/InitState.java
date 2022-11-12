package org.saki.core.stage;

import org.saki.core.IState;
import org.saki.core.window.main.GamePanel;

import java.awt.*;

/**
 * This State show Logo and other Info
 */
public class InitState implements IState {

    private GamePanel panel;
    public InitState(GamePanel panel){
        this.panel = panel;
    }
    @Override
    public void Update() {

    }

    @Override
    public void Render(Graphics g) {

    }

    @Override
    public void OnEnter() {

    }

    @Override
    public void OnExit() {

    }
}
