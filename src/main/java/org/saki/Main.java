package org.saki;

import org.saki.core.tile.Map;
import org.saki.core.window.main.GameWindow;
import org.saki.game.Const;

import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        Const.load();
        GameWindow window = new GameWindow();
        window.init(args);
        window.start();
//        Map map = new Map();
//        map.emptyMap("map2", (byte) 60, (byte) 40, (byte) 2);
//        map.fillLayer((byte) 1, (byte) 22);
//        map.saveMap();
    }
}