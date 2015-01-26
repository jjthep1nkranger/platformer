package com.annesj.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputcamera;

    public static float widthScale;
    public static float heightScale;

    public static void initializeController(){
        float width = Gdx.graphics.getWidth();//finds width of window for use in the game map
        float height = Gdx.graphics.getHeight();//fits thh game map to the window

        camera = new OrthographicCamera(14f, 14f * (height / width));//to initialize the camera
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f,0);//sets the view to half of what it is and center it

        inputcamera = new OrthographicCamera(14f, 14f * (height / width));
        inputcamera.position.set(inputcamera.viewportWidth / 2f, inputcamera.viewportHeight / 2f, 0);
        inputcamera.update();

    }

    public static void update(){
        camera.position.set(PlayerController.player.position.x, PlayerController.player.position.y, 0);
        camera.update();//updating the camera
    }
     public static void resize(int width, int height){
         camera.viewportWidth = 14f;
         camera.viewportHeight = 14f * height / width;
         camera.update();//sets the weight and hidth to the window when resizing

         inputcamera.viewportWidth = 14f;
         inputcamera.viewportHeight = 14f * height / width;
         inputcamera.position.set(inputcamera.viewportWidth / 2f, inputcamera.viewportHeight / 2f, 0);
         inputcamera.update();

         widthScale = width / inputcamera.viewportWidth * LevelController.UNIT_SCALE;
         heightScale = height / inputcamera.viewportHeight * LevelController.UNIT_SCALE;
     }

}
