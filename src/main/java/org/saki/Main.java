package org.saki;

import org.saki.core.window.main.GameWindow;
import org.saki.game.Const;

public class Main {
    public static void main(String[] args) {
        Const.load();
        GameWindow window = new GameWindow();
        window.init(args);
        window.start();
    }
}