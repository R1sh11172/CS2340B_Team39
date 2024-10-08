package com.example.cs2340b_team39;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cs2340b_team39.Model.CollisionSub;
import com.example.cs2340b_team39.Model.Enemy;
import com.example.cs2340b_team39.Model.Enemy1;
import com.example.cs2340b_team39.Model.Enemy2;
import com.example.cs2340b_team39.Model.Enemy3;
import com.example.cs2340b_team39.Model.EnemyMovement;
import com.example.cs2340b_team39.Model.Player;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class S4UnitTests {
    @Before
    public void initPlayer() {
        Player p = Player.getPlayer();
    }
    @Test
    public void clearCollisionTest() {
        //Player p = Player.getPlayer();
        CollisionSub.getCollision().addEnemy(new Enemy1(null));
        CollisionSub.getCollision().addEnemy(new Enemy2(null));
        CollisionSub.getCollision().clearCollisions();
        Object[] enemies = CollisionSub.getCollision().getEnemies().toArray();
        assertArrayEquals(new Enemy[0], enemies);
    }
    @Test
    public void moveEnemy1Up() {
        Enemy1 e1 = new Enemy1(null);
        e1.setMovement(new EnemyMovement(e1));
        e1.initMovement();
        e1.getMovement().setTestCase(true);
        double x = e1.getX();
        double y = e1.getY();
        e1.move(0);
        assertEquals(x, e1.getX(), .1);
        assertEquals(y - 40, e1.getY() - e1.getSpeed(), .1);
    }

    @Test
    public void moveEnemy1Right() {
        Enemy1 e1 = new Enemy1(null);
        e1.setMovement(new EnemyMovement(e1));
        e1.initMovement();
        e1.getMovement().setTestCase(true);
        double x = e1.getX();
        double y = e1.getY();
        e1.move(1);
        assertEquals(x + 40, e1.getX() + e1.getSpeed(), .1);
        assertEquals(y, e1.getY(), .1);
    }

    @Test
    public void moveEnemy1Down() {
        Enemy1 e1 = new Enemy1(null);
        e1.setMovement(new EnemyMovement(e1));
        e1.initMovement();
        e1.getMovement().setTestCase(true);
        double x = e1.getX();
        double y = e1.getY();
        e1.move(2);
        assertEquals(x, e1.getX(), .1);
        assertEquals(y + 40, e1.getY() + e1.getSpeed(), .1);
    }

    @Test
    public void moveEnemy1Left() {
        Enemy1 e1 = new Enemy1(null);
        e1.setMovement(new EnemyMovement(e1));
        e1.initMovement();
        e1.getMovement().setTestCase(true);
        double x = e1.getX();
        double y = e1.getY();
        e1.move(3);
        assertEquals(x - 40, e1.getX() - e1.getSpeed(), .1);
        assertEquals(y, e1.getY(), .1);
    }

    @Test
    public void moveEnemy2Up() {
        Enemy2 e2 = new Enemy2(null);
        e2.setMovement(new EnemyMovement(e2));
        e2.initMovement();
        e2.getMovement().setTestCase(true);
        double x = e2.getX();
        double y = e2.getY();
        e2.move(0);
        assertEquals(x, e2.getX(), .1);
        assertEquals(y - 80, e2.getY() - e2.getSpeed(), .1);
    }

    @Test
    public void moveEnemy2Down() {
        Enemy2 e2 = new Enemy2(null);
        e2.setMovement(new EnemyMovement(e2));
        e2.initMovement();
        e2.getMovement().setTestCase(true);
        double x = e2.getX();
        double y = e2.getY();
        e2.move(2);
        assertEquals(x, e2.getX(), .1);
        assertEquals(y + 80, e2.getY() + e2.getSpeed(), .1);
    }
    @Test
    public void moveEnemy2Right() {
        Enemy2 e2 = new Enemy2(null);
        e2.setMovement(new EnemyMovement(e2));
        e2.initMovement();
        e2.getMovement().setTestCase(true);
        double x = e2.getX();
        double y = e2.getY();
        e2.move(1);
        assertEquals(x + 80, e2.getX() + e2.getSpeed(), .1);
        assertEquals(y, e2.getY(), .1);
    }

    @Test
    public void moveEnemy2Left() {
        Enemy2 e2 = new Enemy2(null);
        e2.setMovement(new EnemyMovement(e2));
        e2.initMovement();
        e2.getMovement().setTestCase(true);
        double x = e2.getX();
        double y = e2.getY();
        e2.move(3);
        assertEquals(x - 80, e2.getX() - e2.getSpeed(), .1);
        assertEquals(y, e2.getY(), .1);
    }

    @Test
    public void enemy3Movement() {
        Enemy3 e3 = new Enemy3(null);
        e3.setMovement(new EnemyMovement(e3));
        e3.initMovement();
        e3.getMovement().setTestCase(true);
        double x = e3.getX();
        double y = e3.getY();
        e3.move(3);
        assertEquals(x - 40, e3.getX() - e3.getSpeed(), .1);
        assertEquals(y, e3.getY(), .1);
    }





}
