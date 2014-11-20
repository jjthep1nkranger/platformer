package com.annesj.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
    public TiledMap map;
    //sets the object for the map
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader() .load("map/map.tmx");
        //the connecter to the online sit that loads the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //to call the class to render the map

        float width = Gdx.graphics.getWidth();
        //finds width of window for use in the game map
        float height = Gdx.graphics.getHeight();
        //fits thh game map to the window
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //to initialize the camera
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f,0);
        //sets the view to half of what it is and center it
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
