package com.annesj.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;//a point for x and y positioning
    public Animation animation;
    public Spritesheet spriteSheet;
    private float stateTime;// time of the state

    public Player() {
        position = new Vector2(2, 2);//positions the player in the bottom right corner of the screen
        spriteSheet = new Spritesheet("img/aliens.png", 70, 100);
        animation = spriteSheet.createAnimation(9, 10, 0.1f);
        animation = spriteSheet.flipAnimation(animation, true, false);
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));}//the function for drawing the player


    public void update(float deltaTime){
        stateTime += deltaTime;
        position.x+= deltaTime;//moves the player to the right slowly

    }
}
