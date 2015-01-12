package com.annesj.platformer.controller;

import com.annesj.platformer.model.Player;
import com.badlogic.gdx.graphics.g2d.Batch;

public class PlayerController {

    public static Player player;

    public static void initializeController(){
        player = new Player(70, 100);//creates the player object

    }

     public static void update(float deltaTime){
         player.update(deltaTime);
     }

    public static void draw(Batch spriteBatch){
        player.draw(spriteBatch);//draws the player in the window
    }
}
