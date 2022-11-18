package org.saki.core.tile;

import org.saki.Main;
import org.saki.core.gui.SpriteSheet;
import org.saki.core.widget.IView;
import org.saki.core.window.main.GamePanel;
import org.saki.game.Const;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

public class TileManager implements IView {
    private final GamePanel panel;
    private Map map;
    private Tile[] tiles;
    private SpriteSheet tileSheet;
    public TileManager(GamePanel panel) {
        this.panel = panel;
        BufferedImage imageSheet = Const.imageResource.SHEET_TILES;
        tileSheet = new SpriteSheet.SpriteSheetBuilder(imageSheet).setSpriteSize(32,32).col(8).row(112).build();
    }

    public void loadMap(String MapName){
        this.map = new Map(MapName);
        int col = map.getWidth();
        int row = map.getHeight();
        int layer = map.getLayer();
        this.tiles = new Tile[col * row * layer];
        for(int index = 0; index < this.tiles.length ;index++){
            byte mapTitle = map.getMapData()[index];
            tiles[index] = new Tile(tileSheet.getImage(mapTitle));
        }
    }

    @Override
    public void Render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        int col = map.getWidth();
        int row = map.getHeight();
        int layer = map.getLayer();
        for(int l = 1; l <= layer ; l++){
            for(int i = 0; i < col ;i++){
                for(int j = 0; j < row; j++){
                    int posX = i * Const.BLOCK_SIZE;
                    int posY = j * Const.BLOCK_SIZE;
                    Tile tile = tiles[i + j];
                    if(tile != null){
                        graphics2D.drawImage(tile.image,posX,posY,Const.BLOCK_SIZE,Const.BLOCK_SIZE,null);
                    }
                }
            }
        }
    }

    @Override
    public void Update() {

    }
}
