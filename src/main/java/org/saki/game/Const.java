package org.saki.game;

import org.saki.asset.ImageResource;
import org.saki.asset.SoundResource;

public class Const {
    public static final int ROW = 20;
    public static final int COL = 30;
    public static final int BLOCK_SIZE = 32;
    public static final int WIDTH =  COL * BLOCK_SIZE;
    public static final int HEIGHT = ROW * BLOCK_SIZE;
    public static final int FPS = 60;
    public static final String GAME_NAME = "RPG 2D";

    public static final int DEFAULT_TIP_DURATION = 4;
    public static final int DEFAULT_TIP_POS_X = Const.BLOCK_SIZE * 4;
    public static final int DEFAULT_TIP_POS_Y = Const.BLOCK_SIZE * 4;
    public static ImageResource imageResource;
    public static SoundResource soundResource;
    public static void load() {
        imageResource = new ImageResource();
        soundResource = new SoundResource();
    }
}
