package org.saki.core.stage;

import org.saki.core.IState;
import org.saki.core.window.main.GamePanel;

import java.awt.*;

public class MainState implements IState {
    private GamePanel panel;
    public MainState(GamePanel panel){
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
