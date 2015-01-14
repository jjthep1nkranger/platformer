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
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("stand", spriteSheet.createAnimation(0, 0, 0.1f));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("idle", spriteSheet.createAnimation(6, 6, 0.1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("swim", spriteSheet.createAnimation(7, 8, 0.1f));
        animations.put("walk", spriteSheet.createAnimation(9, 10, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.1f));
        animations.put("duck", spriteSheet.createAnimation(3, 3, 0.1f));

        animations.put("standLeft", spriteSheet.flipAnimation(animations.get("stand"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swim"), true, false));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("climbLeft", spriteSheet.flipAnimation(animations.get("climb"), true, false));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));

        currentAnimation ="walkLeft";
    }

    public void draw(Batch spriteBatch){
       super.draw(spriteBatch);
    }


    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
