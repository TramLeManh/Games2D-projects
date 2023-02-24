package tiles;


import main.GamePanel;
import main.keyControl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import java.awt.Color;

public class TilesMangaer extends Tiles {
    GamePanel gp;
    keyControl keyBoard;
    public Tiles[] tile;
    public int mapTileNumber[][];

    public TilesMangaer(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[20];
        mapTileNumber = new int[gp.maxWorldCol][gp.maxWorldRow];
        getImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/map/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            int col = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNumber[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getImage() {
        try {
            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResource("/picture/tiles/grass.png"));

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResource("/picture/tiles/wall.png"));
            tile[1].collision =true;

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResource("/picture/tiles/water.png"));
            tile[2].collision =true;

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResource("/picture/tiles/earth.png"));
            
            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResource("/picture/tiles/tree.png"));
            tile[4].collision = true;
            
            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResource("/picture/tiles/sand.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g2) {
        // g2.drawImage(tiles[0].image,0,0,gp.tileSize,gp.tileSize,);
        int worldCol = 0;
        int worldRow = 0;
        int x = 0;
        int y = 0;
        int tileNumber = mapTileNumber[worldCol][worldRow];
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            tileNumber = mapTileNumber[worldCol][worldRow];
            int worldX = worldCol*gp.tileSize;
            int worldY = worldRow*gp.tileSize;
            int screenX = worldX -gp.player.worldX + gp.player.screenX;
            int screenY = worldY -gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNumber].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
