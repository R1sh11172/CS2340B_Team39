package com.example.cs2340b_team39;

import android.content.Intent;
import android.widget.ImageView;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.cs2340b_team39.Model.Player;
import com.example.cs2340b_team39.Model.PlayerMovement;
import com.example.cs2340b_team39.View.ActiveSub;
import com.example.cs2340b_team39.View.ConfigActivity;
import com.example.cs2340b_team39.View.GameActivity;
import com.example.cs2340b_team39.ViewModel.ViewModel;

public class S3UnitTests {
    @Test
    public void moveRightEasyDiff() {
        Player p = Player.getPlayer("Josh", 0, 0);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(1);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 130, 1);
        p.resetPlayer();
    }
    @Test
    public void moveUpEasyDiff() {
        Player p = Player.getPlayer("Josh", 0, 0);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(0);
        assertEquals(p.getPlayerY(), 70, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.resetPlayer();
    }
    @Test
    public void moveDownMediumDifficulty() {
        Player p = Player.getPlayer("player", 0, 1);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(2);
        assertEquals(p.getPlayerY(), 115, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.resetPlayer();
    }
    @Test
    public void moveLeftHardDifficulty() {
        Player p = Player.getPlayer("player", 0, 2);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(3);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 90, 1);
        p.resetPlayer();
    }
    @Test
    public void moveRightHardDifficulty() {
        Player p = Player.getPlayer("divya", 0, 2);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(3);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 110, 1);
        p.resetPlayer();
    }
    @Test
    public void moveUpHardDifficulty() {
        Player p = Player.getPlayer("divya2", 0, 2);
        PlayerMovement.setTestCase(true);
        ActiveSub.setG1Active(true);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(0);
        assertEquals(p.getPlayerY(), 90, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.resetPlayer();
    }
}
