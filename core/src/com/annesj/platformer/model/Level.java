package com.annesj.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;//sets the object for the map

    public Level(String mapPath){
        map = new TmxMapLoader() .load(mapPath);//the connecter to the online sit that loads the map
    }
}
