package com.annesj.platformer.model;

import com.annesj.platformer.controller.LevelController;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Bodies {
    public static void createBody(MapObject mapObject){
        String bodyType = mapObject.getProperties().get("type").toString();

        if (bodyType.equalsIgnoreCase("solid")){
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(rectangleObject.getRectangle().x* LevelController.UNIT_SCALE, rectangleObject.getRectangle().y* LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameworld.createBody(bodyDefinition);

            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
                    rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2,
                    new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
                            rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2), 0);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }
    }
}
