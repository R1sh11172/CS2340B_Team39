package com.example.cs2340b_team39.Model;

import android.media.Image;

public class Player {
    private String name;
    private Image avatar;
    private double health;
    private double difficulty;
    // private Weapon equipped;
    // private Ability ability;
    private Score score;
    private int characterId;
    private int speed;
    private float playerX;
    private float playerY;
    private static volatile Player player;
    private PlayerMovement move;
    private Player(String name, int characterId, double difficulty) {
        this.name = name;
        //this.avatar = avatar;
        this.health = (100 - difficulty * 25);
        this.difficulty = difficulty;
        this.characterId = characterId;
        this.score = new Score();
        this.move = new PlayerMovement();
        this.speed = (int) (30 / (difficulty + 1));
    }

    /*
     *
     * Name: getPlayer()
     * @return the instance of the player
     */
    public static Player getPlayer(String name, int characterId, double difficulty) {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player(name, characterId, difficulty);
                }
            }
        }
        return player;
    }
    //Move dir: 0 is up, 1 is right, 2 is down, 3 is left
    public void moveDir(int dir) {
        switch (dir) {
        case 0:
            move.moveUp(speed);
            break;
        case 1:
            move.moveRight(speed);
            break;
        case 2:
            move.moveDown(speed);
            break;
        case 3:
            move.moveLeft(speed);
            break;

        default:
            break;
        }
    }
    public static Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }
    public Image getAvatar() {
        return avatar;
    }

    public double getHealth() {
        return health;
    }

    public double getDifficulty() {
        return difficulty;
    }
    public Score getScore() {
        return score;
    }
    public void resetPlayer() {
        player = null;
    }
    public float getPlayerX() {
        return playerX;
    }
    public float getPlayerY() {
        return playerY;
    }
    public void setPlayerX(float x) {
        playerX = x;
    }
    public void setPlayerY(float y) {
        playerY = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public PlayerMovement getPlayerMovement() {
        return move;
    }
}