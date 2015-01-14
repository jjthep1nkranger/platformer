package com.annesj.platformer.model;

import com.annesj.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import java.util.HashMap;

public class Sprite {

    public Body physicsBody;
    public Vector2 position;//a point for x and y positioning
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    protected float stateTime;// time of the state
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height){
        this.position = position;//positions the player in the bottom right corner of the screen
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width ,height);
    }//the function for drawing the player


    public void update(float deltaTime){
        stateTime += deltaTime;

    }
}
