package com.annesj.platformer.model;

import com.annesj.platformer.controller.LevelController;
import com.annesj.platformer.view.GameScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.util.HashMap;

public class Player extends Sprite {

    public Player(Vector2 position, int width, int height){
        super(position, width, height);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsBody = LevelController.gameworld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2, this.height / 2, new Vector2(this.width / 2, this.height / 2), 0);

        PolygonShape sensorShape = new PolygonShape();
        sensorShape.setAsBox(this.width / 2, this.height / 4, new Vector2(this.width / 2, 0), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        FixtureDef fixtureDefinitionSensor = new FixtureDef();
        fixtureDefinitionSensor.shape = sensorShape;

        physicsBody.createFixture(fixtureDefinition);
        physicsBody.createFixture(fixtureDefinitionSensor);
        rectangleShape.dispose();
        sensorShape.dispose();

        animations.put("standRight", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("jumpRight", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("idleRight", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("hurtRight", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("swimRight", spriteSheet.createAnimation(7, 8, 0.1f));
        animations.put("walkRight", spriteSheet.createAnimation(9, 10, 0.1f));
        animations.put("climbRight", spriteSheet.createAnimation(1, 2, 0.1f));
        animations.put("duckRight", spriteSheet.createAnimation(3, 3, 0.1f));

        animations.put("standLeft", spriteSheet.flipAnimation(animations.get("standRight"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("climbLeft", spriteSheet.flipAnimation(animations.get("climbRight"), true, false));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));

        currentAnimation ="walkLeft";
    }

    public void draw(Batch spriteBatch){
       super.draw(spriteBatch);
    }


    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
