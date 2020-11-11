package com.company.Objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObjectSheet {

    final static int width = 30, height = 30;

    static public BufferedImage sheet = loadSheet("SpaceInvaders-main/SpaceInvaders/resources/ss2.png");
    static public BufferedImage enemy;
    static public BufferedImage player;
    static public BufferedImage playerShoot;
    static public BufferedImage enemyShoot;
    static public BufferedImage boom;

    public ObjectSheet() {
        enemy = sheet.getSubimage(0, 0, width, height);
        playerShoot = sheet.getSubimage(width, 31, width, height);
        enemyShoot = sheet.getSubimage(width * 2, 31, width, height);
        player = sheet.getSubimage(0, 31, width, height);
        boom = sheet.getSubimage(width * 3, 31, width, height);
    }


    public static BufferedImage loadSheet(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error with loading image");
        }
        return null;
    }
}
