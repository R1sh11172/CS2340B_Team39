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
        //assertEquals(p, null);
        ActiveSub.setPlayer(p);
        ActiveSub.initializePlayer();
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 100, 1);
        p.moveDir(1);
        assertEquals(p.getPlayerY(), 100, 1);
        assertEquals(p.getPlayerX(), 130, 1);
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
        assertEquals(p.getPlayerY(), 70, 1);
        assertEquals(p.getPlayerX(), 100, 1);
    }
}
