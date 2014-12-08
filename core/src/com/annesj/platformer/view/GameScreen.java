package com.annesj.platformer.view;

import com.annesj.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
    public TiledMap map;//sets the object for the map
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public GameScreen() {
        map = new TmxMapLoader() .load("map/map.tmx");//the connecter to the online sit that loads the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//to call the class to render the map

        float width = Gdx.graphics.getWidth();//finds width of window for use in the game map
        float height = Gdx.graphics.getHeight();//fits thh game map to the window
        camera = new OrthographicCamera(14f, 14f * (height / width));//to initialize the camera
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f,0);//sets the view to half of what it is and center it

        spriteBatch = renderer.getSpriteBatch();//gets acsess to the spritebatch object
        player = new Player();//creates the player object
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3019607843f,1f,.34901960784f,1f);//sets the color of your clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//clears the screen using the color youve chosen

        camera.update();//updating the camera
        renderer.setView(camera);//sets where the camera is
        renderer.render();//sets render to start

        player.update(delta);
        spriteBatch.begin();//begins the spritebatch
        player.draw(spriteBatch);//draws the player in the window
        spriteBatch.end();//ends the spritebatch
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height / width;
        camera.update();//sets the weight and hidth to the window when resizing
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
