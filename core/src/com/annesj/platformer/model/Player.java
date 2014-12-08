package com.annesj.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;//a point for x and y positioning
    public Texture spriteSheet;//creates object for spritesheet

    public TextureRegion[] spriteFrames;//

    public Player() {
        position = new Vector2(2, 2);//positions the player in the bottom right corner of the screen
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));//allows us to access the image in assests folder and changing it into a texture

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70,100);//it splits the regions up and sets them in the 2d array

        int counter = 0;//
        for(int row = 0; row < spriteSheetFrames.length; row++){
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;//adds one to the counter each time
            }
        }

        spriteFrames = new TextureRegion[counter];//initializes the value so we can store the sprites

        counter = 0;
        for(TextureRegion[] row : spriteSheetFrames){
            for(TextureRegion sprite : row){
                spriteFrames[counter++] = sprite;
            }

        }

    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(spriteFrames[11], position.x, position.y, 70 * (1/70f), 100 * (1/70f));}//the function for drawing the player


    public void update(float deltaTime){
        position.x+= deltaTime;//moves the player to the right slowly

    }
}
