package com.annesj.platformer.controller;

import com.annesj.platformer.model.InputControl;
import com.annesj.platformer.model.Spritesheet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class InputController {
    private static ArrayList<InputControl> inputControls;
    private static Spritesheet spriteSheet;
    private static InputControl right;
    private static InputControl left;

    public static void initializeController(){
        inputControls = new ArrayList<InputControl>();
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);
        right = new InputControl(new Vector2(0,0), spriteSheet.spriteFrames[1], "right");
        left = new InputControl(new Vector2(0,0), spriteSheet.spriteFrames[1], "left");
        inputControls.add(right);
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        for (InputControl input : inputControls){
            input.draw(spriteBatch);
        }
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter(){
        return new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "right";
                }

                else if (keycode == Input.Keys.LEFT){
                    PlayerController.movementAction = "left";
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "";
                }

                else if (keycode == Input.Keys.LEFT){
                    PlayerController.movementAction = "";
                }
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for (InputControl input : inputControls) {
                    if (right.getBoundingBox().contains(screenX, screenY)) {
                        if (input.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "right";
                        }
                    }

                    else if (left.getBoundingBox().contains(screenX, screenY)) {
                        if (input.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "left";
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for (InputControl input : inputControls) {
                    if (right.getBoundingBox().contains(screenX, screenY)) {
                        if (input.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "";
                        }
                    }

                    else if (left.getBoundingBox().contains(screenX, screenY)) {
                        if (input.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "";
                        }
                    }
                }
                return true;
            }
        };
    }
}
