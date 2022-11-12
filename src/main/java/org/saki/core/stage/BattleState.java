package org.saki.core.stage;

import org.saki.core.IState;
import org.saki.core.StateMachine;
import org.saki.core.window.main.GamePanel;

import java.awt.*;

/**
 * Battle State for Player to Battle with Monster or Npc
 */
public class BattleState implements IState {
    private GamePanel panel;
    public BattleState(GamePanel panel){
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
