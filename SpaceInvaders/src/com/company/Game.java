package com.company;

import com.company.Control.KeyAdapter;
import com.company.GameMode.GameMode;
import com.company.GameMode.MenuMode;
import com.company.Objects.ObjectSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private final ObjectSheet objectSheet;
    boolean run = false;
    ObjectList objectList;
    EnemyList enemyList;
    private KeyAdapter keyAdapter;
    private Thread thread;


    public Game() {
        objectSheet = new ObjectSheet();
        objectList = new ObjectList();
        enemyList = new EnemyList();
        Window window = new Window(this);
        window.game.start();
        MenuMode menu = new MenuMode(enemyList, objectList, objectSheet, this);
        GameMode.setActualMode(menu);
        keyAdapter = new KeyAdapter(objectList, objectSheet, enemyList);
        addKeyListener(keyAdapter);


    }

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void run() {
        int FPS = 60; // update per sec
        double ns = 1000000000 / FPS; // per pic
        double d = 0;
        double time = 0;
        double now;
        double lastTiime = System.nanoTime();


        while (run) {
            now = System.nanoTime();
            d += (now - lastTiime) / ns;
            time += now - lastTiime;

            lastTiime = now;

            while (d >= 1) {
                update();
                render();
                d--;
            }
            if (time >= 1000000000) time = 0;
        }
        stop();

    }


    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if (GameMode.getActualMode() != null) {
            GameMode.getActualMode().render(g);
        }


        g.dispose();
        bs.show();

    }

    public void update() {
        if (GameMode.getActualMode() != null) {
            GameMode.getActualMode().update();
        }
    }

    public synchronized void start() {

        if (!run) {
            run = true;
            thread = new Thread(this); // this Game class
            thread.start();
        } else return;

    }

    public synchronized void stop() {
        if (run) {
            run = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else return;
    }

    public KeyAdapter getKeyAdapter() {
        return keyAdapter;
    }

    public void setKeyAdapter(KeyAdapter keyAdapter) {
        this.keyAdapter = keyAdapter;
    }
}
