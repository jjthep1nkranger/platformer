package com.annesj.platformer.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader() .load("map/map.tmx");
        //the online thing
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //to callt hje lasss
        camera = new OrthographicCamera(14f, 14f);
    }

    @Override
    public void render(float delta) {
        camera.update();
        //updating the camera
        renderer.setView(camera);
        //sets where the camera is
        renderer.render();
        //sets render to start
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
