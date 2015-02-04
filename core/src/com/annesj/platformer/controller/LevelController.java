package com.annesj.platformer.controller;

import com.annesj.platformer.model.Bodies;
import com.annesj.platformer.model.CollisionListener;
import com.annesj.platformer.model.InputControl;
import com.annesj.platformer.model.Level;
import com.annesj.platformer.model.Player;
import com.annesj.platformer.model.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;

    public static Batch spriteBatch;

    public static World gameworld;
    private static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        level = new Level("map/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);//to call the class to render the map

        gameworld = new World(new Vector2(0, -10), true);
        gameworld.setContactListener(new CollisionListener());
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();//gets acsess to the spritebatch object
        createLevelBodies();
    }

    public static void draw(){
        spriteBatch.setProjectionMatrix(CameraController.camera.combined);
        spriteBatch.begin();//begins the spritebatch
        PlayerController.draw(spriteBatch);
        spriteBatch.end();//ends the spritebatch

        spriteBatch.setProjectionMatrix(CameraController.inputcamera.combined);
        InputController.draw(spriteBatch);

        debugRenderer.render(gameworld, CameraController.camera.combined);
    }

    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);//sets where the camera is
        renderer.render();//sets render to start
        updateWorldBodies();
        gameworld.step(1/60f, 1, 1);
    }

    public static void updateWorldBodies(){
        worldBodies.clear();
        gameworld.getBodies(worldBodies);

        for (Body body : worldBodies){
            Sprite spriteBody = (Player)body.getUserData();

            if (spriteBody != null){
                spriteBody.position = body.getPosition();

            }

        }
    }

    private static void createLevelBodies(){
        MapObjects mapObjects = level.getLayerObjects(level.getMapLayer("collision"));

        for (MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);
        }
        mapObjects = level.getLayerObjects(level.getMapLayer("block"));

        for (MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);
        }
    }
}
