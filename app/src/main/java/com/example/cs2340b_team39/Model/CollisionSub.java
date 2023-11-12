package com.example.cs2340b_team39.Model;

import com.example.cs2340b_team39.ViewModel.ViewModel;

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
    public void checkPECollision() {
        player = Player.getPlayer();
        for (int i = 0; i < enemies.size(); i++) {
            double enemyX = enemies.get(i).getX();
            double enemyY = enemies.get(i).getY();
            double playerX = player.getPlayerX();
            double playerY = player.getPlayerY();
            double enemySize = enemies.get(i).getSize();
            boolean collide = false;
            if (playerX >= enemyX && playerX <= enemyX + enemySize) {
                collide = true;
            }
            if (playerX + 16 >= enemyX && playerX + 16 <= enemyX + enemySize) {
                collide = true;
            }
            if (playerY >= enemyY && playerY <= enemyY + enemySize) {
                collide = true;
            }
            if ((playerY + 16) >= enemyY && (playerY + 16) <= (enemyY + enemySize)) {
                collide = true;
            }
            if (collide) {
                player.setHealth(player.getHealth() - enemies.get(i).getDamage());
                ViewModel.updateHealth();
            }
        }
    }
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }
}
