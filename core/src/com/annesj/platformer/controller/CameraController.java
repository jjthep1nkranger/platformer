package com.annesj.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController(){
        float width = Gdx.graphics.getWidth();//finds width of window for use in the game map
        float height = Gdx.graphics.getHeight();//fits thh game map to the window

        camera = new OrthographicCamera(14f, 14f * (height / width));//to initialize the camera
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f,0);//sets the view to half of what it is and center it

    }

    public static void update(){
        camera.update();//updating the camera
    }
     public static void resize(int width, int height){
         camera.viewportWidth = 14f;
         camera.viewportHeight = 14f * height / width;
         camera.update();//sets the weight and hidth to the window when resizing
     }
}
