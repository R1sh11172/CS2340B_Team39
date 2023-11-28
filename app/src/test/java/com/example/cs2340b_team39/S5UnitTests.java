package com.example.cs2340b_team39;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.Enemy1;
import com.example.cs2340b_team39.Model.Enemy4;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.PowerUp;
import com.example.cs2340b_team39.Model.PowerUpFreeze;
import com.example.cs2340b_team39.Model.PowerUpHealth;
import com.example.cs2340b_team39.Model.PowerUpSpeed;

public class S5UnitTests {
    @Test
    public void speedPowerupEasy() {
        Player p = Player.getPlayer("Test", 0, 0);
        PowerUp speed = new PowerUpSpeed(null);
        speed.applyPowerUp(Player.getPlayer());
        assertEquals(40, Player.getPlayer().getSpeed());
        p.resetPlayer();
    }

    @Test
    public void speedPowerupMedium() {
        Player p = Player.getPlayer("Test", 0, 1);
        PowerUp speed = new PowerUpSpeed(null);
        speed.applyPowerUp(Player.getPlayer());
        assertEquals(25, Player.getPlayer().getSpeed());
        p.resetPlayer();
    }

    @Test
    public void speedPowerupHard() {
        Player p = Player.getPlayer("Test", 0, 2);
        PowerUp speed = new PowerUpSpeed(null);
        speed.applyPowerUp(Player.getPlayer());
        assertEquals(20, Player.getPlayer().getSpeed());
        p.resetPlayer();
    }

    @Test
    public void freezePowerupEnemy1() {
        PowerUp freeze = new PowerUpFreeze(null);
        CollisionSub.getCollision();
        Enemy enemy1 = new Enemy1(null);
        CollisionSub.getCollision().addEnemy(enemy1);
        assertEquals(false, enemy1.getFreeze());
        freeze.applyPowerUp(Player.getPlayer());
        assertEquals(true, enemy1.getFreeze());
    }

    @Test
    public void freezePowerupEnemy2() {
        PowerUp freeze = new PowerUpFreeze(null);
        CollisionSub.getCollision();
        Enemy enemy1 = new Enemy1(null);
        CollisionSub.getCollision().addEnemy(enemy1);
        assertEquals(false, enemy1.getFreeze());
        freeze.applyPowerUp(Player.getPlayer());
        assertEquals(true, enemy1.getFreeze());
    }

    @Test
    public void freezePowerupEnemy3() {
        PowerUp freeze = new PowerUpFreeze(null);
        CollisionSub.getCollision();
        Enemy enemy1 = new Enemy1(null);
        CollisionSub.getCollision().addEnemy(enemy1);
        assertEquals(false, enemy1.getFreeze());
        freeze.applyPowerUp(Player.getPlayer());
        assertEquals(true, enemy1.getFreeze());
    }
    @Test
    public void freezePowerupEnemy4() {
        PowerUp freeze = new PowerUpFreeze(null);
        CollisionSub.getCollision();
        Enemy4 enemy4 = new Enemy4(null);
        CollisionSub.getCollision().addEnemy(enemy4);
        assertEquals(false, enemy4.getFreeze());
        freeze.applyPowerUp(Player.getPlayer());
        assertEquals(true, enemy4.getFreeze());
    }

    @Test
    public void healthPowerupEasy() {
        Player p = Player.getPlayer("Test", 0, 0);
        PowerUp health = new PowerUpHealth(null);
        health.applyPowerUp(Player.getPlayer());
        assertEquals(120.0, Player.getPlayer().getHealth(), 0.5);
        p.resetPlayer();
    }

    @Test
    public void healthPowerupMedium() {
        Player p = Player.getPlayer("Test", 1, 1);
        PowerUp health = new PowerUpHealth(null);
        health.applyPowerUp(Player.getPlayer());
        assertEquals(95.0, Player.getPlayer().getHealth(), 0.5);
        p.resetPlayer();
    }
    @Test


}
