package com.example.cs2340b_team39.Model;

import java.util.ArrayList;
public class CollisionSub {
    private ArrayList<Enemy> enemies;
    private Player player;
    private static CollisionSub collisionSub;
    private CollisionSub() {
        enemies = new ArrayList<Enemy>();
    }
    public static CollisionSub getCollision() {
        if (collisionSub == null) {
            synchronized (Player.class) {
                if (collisionSub == null) {
                    collisionSub = new CollisionSub();
                }
            }
        }
        return collisionSub;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
