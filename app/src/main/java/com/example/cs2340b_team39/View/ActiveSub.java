package com.example.cs2340b_team39.View;

import android.widget.ImageView;

import com.example.cs2340b_team39.Model.Player;

public class ActiveSub implements SubPlayerPos {
    private static boolean G1Active;
    private static boolean G2Active;
    private static boolean G3Active;
    private static ImageView player;
    @Override
    public void updatePlayerPos() {
        if (G1Active) {
            player = GameActivity.getSprite();
        } else if (G2Active) {
            player = GameActivityMap2.getSprite();
        } else if (G3Active) {
            player = GameActivityMap3.getSprite();
        } else {
            return;
        }
        player.setX(Player.getPlayer().getPlayerX());
        player.setY(Player.getPlayer().getPlayerY());
    }
    public static void setG1Active(boolean active) {
        G1Active = active;
    }
    public static void setG2Active(boolean active) {
        G2Active = active;
    }
    public static void setG3Active(boolean active) {
        G3Active = active;
    }
    public static void setPlayerImage(ImageView p) {
        player = p;
    }
}
