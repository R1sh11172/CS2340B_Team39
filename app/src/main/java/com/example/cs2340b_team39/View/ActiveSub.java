package com.example.cs2340b_team39.View;

import android.view.View;
import android.widget.ImageView;

import com.example.cs2340b_team39.Model.Player;

public class ActiveSub implements SubPlayerPos {
    private static boolean G1Active;
    private static boolean G2Active;
    private static boolean G3Active;
    private static ImageView player;
    private static Player p;
    public static void updatePlayerPos() {
        if (G1Active) {
            player = GameActivity.getSprite();
        } else if (G2Active) {
            player = GameActivityMap2.getSprite();
        } else if (G3Active) {
            player = GameActivityMap3.getSprite();
        } else {
            return;
        }
//        player.setX(GameActivity.getWidth() / 3);
//        player.setY(GameActivity.getHeight() / 5);
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
    public static ImageView getPlayerImage() {
        return player;
    }
    public static void initializePlayer() {
        if (G1Active) {
            player = GameActivity.getSprite();
        } else if (G2Active) {
            player = GameActivityMap2.getSprite();
        } else if (G3Active) {
            player = GameActivityMap3.getSprite();
        } else {
            return;
        }
        if (player != null) {
            player.setX(GameActivity.getWidth() / 10);
            player.setY(GameActivity.getHeight() / 2);
            Player.getPlayer().setPlayerX(GameActivity.getWidth() / 10);
            Player.getPlayer().setPlayerY(GameActivity.getHeight() / 2);
            player.setAdjustViewBounds(true);
            player.setMaxHeight(64);
            player.setMaxWidth(64);
        } else {
            //Movement test case only
            p.setPlayerX(100);
            p.setPlayerY(100);
        }
    }
    public static void setPlayer(Player player1) {
        p = player1;
    }
}
