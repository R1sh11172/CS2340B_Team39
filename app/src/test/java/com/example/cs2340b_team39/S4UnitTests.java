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
        e1.getMovement().testCase = true;
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
        e1.getMovement().testCase = true;
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
        e1.getMovement().testCase = true;
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
        e1.getMovement().testCase = true;
        double x = e1.getX();
        double y = e1.getY();
        e1.move(3);
        assertEquals(x - 40, e1.getX() - e1.getSpeed(), .1);
        assertEquals(y, e1.getY(), .1);
    }
}
