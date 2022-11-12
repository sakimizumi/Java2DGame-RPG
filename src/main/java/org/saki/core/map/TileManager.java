package org.saki.core.map;

import org.saki.core.window.main.GamePanel;
import org.saki.game.Const;

public class TileManager {
    private final GamePanel panel;
    Tile[] tiles;

    public TileManager(GamePanel panel) {
        this.panel = panel;
        this.tiles = new Tile[10];
    }

    public void loadMap(int mapId){

    }
}
