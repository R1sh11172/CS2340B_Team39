package com.example.cs2340b_team39.View;

import android.widget.ImageView;

import com.example.cs2340b_team39.Model.Player;

public class ActiveSub implements SubPlayerPos {
    private static boolean g1Active;
    private static boolean g2Active;
    private static boolean g3Active;
    private static ImageView player;
    private static Player p;
    public static void updatePlayerPos() {
        if (g1Active) {
            player = GameActivity.getSprite();
        } else if (g2Active) {
            player = GameActivityMap2.getSprite();
        } else if (g3Active) {
            player = GameActivityMap3.getSprite();
        } else {
            return;
        }
        player.setX(Player.getPlayer().getPlayerX());
        player.setY(Player.getPlayer().getPlayerY());
    }
    public static void setG1Active(boolean active) {
        g1Active = active;
    }
    public static void setG2Active(boolean active) {
        g2Active = active;
    }
    public static void setG3Active(boolean active) {
        g3Active = active;
    }
    public static boolean getG1Active() {
        return g1Active;
    }
    public static boolean getG2Active() {
        return g2Active;
    }
    public static boolean getG3Active() {
        return g3Active;
    }
    public static void setPlayerImage(ImageView p) {
        player = p;
    }
    public static ImageView getPlayerImage() {
        return player;
    }
    public static void initializePlayer() {
        if (g1Active) {
            player = GameActivity.getSprite();
        } else if (g2Active) {
            player = GameActivityMap2.getSprite();
        } else if (g3Active) {
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
