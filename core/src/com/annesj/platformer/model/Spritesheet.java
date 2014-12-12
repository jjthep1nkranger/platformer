package com.annesj.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));//allows us to access the image in assests folder and changing it into a texture

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);//it splits the regions up and sets them in the 2d array

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

    public Animation createAnimation(int startFrame,int lastFrame, float animationSpeed){
        int counter = (lastFrame +1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];// stores the animations

        for(int index = lastFrame; index >= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];
        }
        
        return new Animation(animationSpeed, animationFrames);
    }

    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY){
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for(int index = 0; index <= frameCount -1; index++){
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);

        }

        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
    }
}
