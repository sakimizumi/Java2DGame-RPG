package org.saki.core.tile;

import org.saki.core.window.main.GamePanel;

public class TileManager {
    private final GamePanel panel;
    Tile[] tiles;

    public TileManager(GamePanel panel) {
        this.panel = panel;
        this.tiles = new Tile[10];
    }

    public void loadMap(String mapString){

    }
}
