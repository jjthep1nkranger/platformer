package com.annesj.platformer.controller;

import com.annesj.platformer.model.InputControl;
import com.annesj.platformer.model.Spritesheet;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class InputController {
    private static Spritesheet spriteSheet;
    private static InputControl left;

    public static void initializeController(){
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);
        left = new InputControl(new Vector2(0,0), spriteSheet.spriteFrames[0], "left");
    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();

        spriteBatch.end();
    }
}
