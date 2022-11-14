package org.saki.core;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean PRESS_UP = false;
    private boolean PRESS_DOWN = false;
    private boolean PRESS_LEFT = false;
    private boolean PRESS_RIGHT = false;
    private boolean PRESS_OK = false;

    private boolean PRESS_BACK = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_W -> PRESS_UP = true;
            case KeyEvent.VK_S -> PRESS_DOWN = true;
            case KeyEvent.VK_A -> PRESS_LEFT = true;
            case KeyEvent.VK_D -> PRESS_RIGHT = true;
            case KeyEvent.VK_ENTER -> PRESS_OK = true;
            case KeyEvent.VK_ESCAPE -> PRESS_BACK = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code){
            case KeyEvent.VK_W -> PRESS_UP = false;
            case KeyEvent.VK_S -> PRESS_DOWN = false;
            case KeyEvent.VK_A -> PRESS_LEFT = false;
            case KeyEvent.VK_D -> PRESS_RIGHT = false;
            case KeyEvent.VK_ENTER -> PRESS_OK = false;
            case KeyEvent.VK_ESCAPE -> PRESS_BACK = false;
        }
    }

    public boolean getButton_UP() {
        boolean temp = PRESS_UP;
        PRESS_UP = false;
        return temp;
    }

    public boolean getButton_DOWN() {
        boolean temp = PRESS_DOWN;
        PRESS_DOWN = false;
        return temp;
    }
    public boolean getButton_LEFT() {
        boolean temp = PRESS_LEFT;
        PRESS_LEFT = false;
        return temp;
    }
    public boolean getButton_RIGHT() {
        boolean temp = PRESS_RIGHT;
        PRESS_RIGHT = false;
        return temp;
    }
    public boolean getButton_OK() {
        boolean temp = PRESS_OK;
        PRESS_OK = false;
        return temp;
    }
    public boolean getButton_BACK() {
        boolean temp = PRESS_BACK;
        PRESS_BACK = false;
        return temp;
    }


    public boolean getButtonDown_UP() {
        return PRESS_UP;
    }

    public boolean getButtonDown_DOWN() {
        return PRESS_DOWN;
    }
    public boolean getButtonDown_LEFT() {
        return PRESS_LEFT;
    }
    public boolean getButtonDown_RIGHT() {
        return PRESS_RIGHT;
    }
    public boolean getButtonDown_OK() {
        return PRESS_OK;
    }
    public boolean getButtonDown_BACK() {
        return PRESS_BACK;
    }
}
