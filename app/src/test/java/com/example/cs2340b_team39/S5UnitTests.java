package com.example.cs2340b_team39;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.Enemy1;
import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.PowerUp;
import com.example.cs2340b_team39.Model.PowerUpFreeze;
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
}
