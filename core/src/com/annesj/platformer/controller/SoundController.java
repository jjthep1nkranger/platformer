package com.annesj.platformer.controller;

import com.annesj.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.sun.media.jfxmedia.events.PlayerStateEvent;

public class SoundController {
    public static Sound sound;

    public static void initializeController(){
        sound = Gdx.audio.newSound(Gdx.files.internal("sound/Carmada - Carmalude.mp3"));

    }

    public static void play(String soundName){
        if (soundName.equalsIgnoreCase("music")){
            sound.play();
            sound.setLooping(0,true);        }
    }

}
