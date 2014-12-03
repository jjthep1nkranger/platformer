package com.annesj.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;//a point for x and y positioning
    public Texture spriteSheet;//creates object for spritesheet

    public Player() {
        position = new Vector2(0, 0);//positions the player in the bottom right corner of the screen
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));//allows us to access the image in assests folder and changing it into a texture
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteSheet, 0, 0, 70, 100);}//the function for drawing the player

    public void update(float deltaTime){

    }
}
