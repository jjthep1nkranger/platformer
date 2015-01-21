package com.annesj.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.Map;

public class Level {
    public TiledMap map;//sets the object for the map

    public Level(String mapPath){
        map = new TmxMapLoader() .load(mapPath);//the connecter to the online sit that loads the map
    }

    public MapLayer getMapLayer(String layerName){
        return map.getLayers().get(layerName);
    }

    public MapObjects getLayerObjects(MapLayer mapLayer){
    return mapLayer.getObjects();
    }
}
