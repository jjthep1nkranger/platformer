package com.annesj.platformer.view;

import com.annesj.platformer.controller.CameraController;
import com.annesj.platformer.controller.InputController;
import com.annesj.platformer.controller.LevelController;
import com.annesj.platformer.controller.PlayerController;
import com.annesj.platformer.controller.SoundController;
import com.annesj.platformer.model.InputControl;
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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen {



    public GameScreen() {
        SoundController.initializeController();
        LevelController.initializeController();
        CameraController.initializeController();
        PlayerController.initializeController();
        InputController.initializeController();
    }

    @Override
    public void render(float delta)     {
        Gdx.gl.glClearColor(.3019607843f,1f,.34901960784f,1f);//sets the color of your clear
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//clears the screen using the color youve chosen

        LevelController.update(delta);
        CameraController.update();
        PlayerController.update(delta);
        LevelController.draw();
        }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
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
