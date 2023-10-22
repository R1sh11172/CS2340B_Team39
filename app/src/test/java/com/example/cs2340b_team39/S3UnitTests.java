package com.example.cs2340b_team39;

import android.content.Intent;
import android.widget.ImageView;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.View.ActiveSub;
import com.example.cs2340b_team39.View.ConfigActivity;
import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class S3UnitTests {
    @Test
    public void moveRight() {
        Player p = Player.getPlayer("Josh", 0, 0);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(1);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 120, 1);
        p.resetPlayer();
    }
    @Test
    public void moveUp() {
        Player p = Player.getPlayer("Josh", 0, 0);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(0);
        assertEquals(p.getPlayerY(), 80, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.resetPlayer();
    }
    @Test
    public void moveDownMediumDifficulty() {
        Player p = Player.getPlayer("player", 0, 1);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(2);
        assertEquals(p.getPlayerY(), 110, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.resetPlayer();
    }
    @Test
    public void moveLeftHardDifficulty() {
        Player p = Player.getPlayer("player", 0, 2);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(3);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 94, 1);
        p.resetPlayer();
    }
}
