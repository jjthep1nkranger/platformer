package com.annesj.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;//sets the object for the map
    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameworld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        map = new TmxMapLoader() .load("map/map.tmx");//the connecter to the online sit that loads the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//to call the class to render the map

        gameworld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();//gets acsess to the spritebatch object
    }

    public static void draw(){
        spriteBatch.begin();//begins the spritebatch
        player.draw(spriteBatch);//draws the player in the window
        spriteBatch.end();//ends the spritebatch

        debugRenderer.render(gameworld, CameraController.camera.combined);
    }

    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);//sets where the camera is
        renderer.render();//sets render to start
        gameworld.step(1/60f, 1, 1);
    }
}
