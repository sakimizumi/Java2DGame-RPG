package org.saki.core.data;

import org.saki.core.gui.SpriteAnimation;
import org.saki.core.gui.SpriteAnimationMachine;
import org.saki.core.gui.SpriteSheet;
import org.saki.core.KeyHandler;
import org.saki.core.widget.IView;
import org.saki.game.Const;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements IView {

    private final SpriteSheet spriteSheet;
    private SpriteAnimationMachine animationMachine;
    private final KeyHandler keyHandler;
    private final int speed = 2;
    private int posX = Const.WIDTH / 2 - Const.BLOCK_SIZE / 2,posY = Const.HEIGHT / 2 - Const.BLOCK_SIZE / 2;
    public Player(KeyHandler keyHandler) {
        this.tag = "player";
        this.keyHandler = keyHandler;
        BufferedImage image = Const.imageResource.SHEET_PLAYER;
        spriteSheet = new SpriteSheet.SpriteSheetBuilder(image).col(3).row(4).build();

        initAnimation();
    }

    private void initAnimation() {
        animationMachine = new SpriteAnimationMachine();
        SpriteAnimation animationWalkDown = new SpriteAnimation("down",spriteSheet.getSprite(1),spriteSheet.getSprite(0),spriteSheet.getSprite(1),spriteSheet.getSprite(2));
        SpriteAnimation animationWalkLeft = new SpriteAnimation("left",spriteSheet.getSprite(4),spriteSheet.getSprite(3),spriteSheet.getSprite(4),spriteSheet.getSprite(5));
        SpriteAnimation animationWalkRight = new SpriteAnimation("right",spriteSheet.getSprite(7),spriteSheet.getSprite(6),spriteSheet.getSprite(7),spriteSheet.getSprite(8));
        SpriteAnimation animationWalkUp = new SpriteAnimation("up",spriteSheet.getSprite(10),spriteSheet.getSprite(9),spriteSheet.getSprite(10),spriteSheet.getSprite(11));
        animationMachine.add(animationWalkUp);
        animationMachine.add(animationWalkDown);
        animationMachine.add(animationWalkRight);
        animationMachine.add(animationWalkLeft);
        animationMachine.setPos(posX,posY);
        animationMachine.Change("down");
    }


    @Override
    public void Render(Graphics g) {
        animationMachine.Render(g);
    }

    @Override
    public void Update() {
        positionUpdate();
        animationMachine.Update();
    }

    private void positionUpdate() {
        if(keyHandler.getButtonDown_UP()){
            posY -= speed;
            animationMachine.Change("up");
        }else if(keyHandler.getButtonDown_DOWN()){
            posY += speed;
            animationMachine.Change("down");
        }else if(keyHandler.getButtonDown_LEFT()){
            posX -= speed;
            animationMachine.Change("left");
        }else if (keyHandler.getButtonDown_RIGHT()){
            posX += speed;
            animationMachine.Change("right");
        }else{
            animationMachine.Change("idle");
        }

    }
}
