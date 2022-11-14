package org.saki.core.data;

import org.saki.core.gui.SpriteAnimation;
import org.saki.core.gui.SpriteAnimationGroup;
import org.saki.core.gui.SpriteSheet;
import org.saki.core.KeyHandler;
import org.saki.core.widget.IView;
import org.saki.game.Const;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements IView {

    private final SpriteSheet spriteSheet;
    private SpriteAnimationGroup animationGroup;
    private final KeyHandler keyHandler;
    private final int speed = 16;
    private int posX = 100,posY = 100;
    public Player(KeyHandler keyHandler) {
        this.tag = "player";
        this.keyHandler = keyHandler;
        BufferedImage image = Const.imageResource.SHEET_PLAYER;
        spriteSheet = new SpriteSheet.SpriteSheetBuilder(image).col(3).row(4).build();

        initAnimation();
    }

    private void initAnimation() {
        animationGroup = new SpriteAnimationGroup();
        SpriteAnimation spriteAnimation = new SpriteAnimation("idle",spriteSheet.getImage(0));
    }


    @Override
    public void Render(Graphics g) {
        spriteSheet.getSprite(0).Render(g);
    }

    @Override
    public void Update() {
        positionUpdate();
    }

    private void positionUpdate() {
        if(keyHandler.getButton_UP()){
            posY -= speed;
        }else if(keyHandler.getButton_DOWN()){
            posY += speed;
        }
        if(keyHandler.getButton_LEFT()){
            posX -= speed;
        }else if (keyHandler.getButton_RIGHT()){
            posX += speed;
        }
        spriteSheet.getSprite(0).setPos(posX,posY);
    }
}
