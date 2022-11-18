package org.saki.core.stage;

import org.saki.core.IState;
import org.saki.core.KeyHandler;
import org.saki.core.data.Player;
import org.saki.core.gui.HUD;
import org.saki.core.tile.TileManager;
import org.saki.core.window.main.GamePanel;

import java.awt.*;

public class MainState implements IState {
    private GamePanel panel;
    private TileManager tileManager;
    public MainState(GamePanel panel){
        this.panel = panel;
        this.player = new Player(panel.keyHandler);
        this.tileManager = new TileManager(panel);
    }

    HUD hud = new HUD();

    Player player;
    @Override
    public void Update() {
        tileManager.Update();
        player.Update();
        hud.Update();
    }

    @Override
    public void Render(Graphics g) {
        tileManager.Render(g);
        player.Render(g);
        hud.Render(g);
    }

    @Override
    public void OnEnter() {
        this.tileManager.loadMap("map2.map");
    }

    @Override
    public void OnExit() {

    }
}
