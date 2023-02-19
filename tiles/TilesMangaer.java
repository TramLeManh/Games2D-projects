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
    Tiles[] tile;
    int mapTileNumber[][];

    public TilesMangaer(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[10];
        mapTileNumber = new int[gp.maxScreenCol][gp.maxScreenRow];
        getImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/map/map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            int col = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();
                while (col < gp.maxScreenCol) {
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNumber[col][row] = num;
                    col++;

                }
                if (col == gp.maxScreenCol) {
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
            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResource("/picture/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g2) {
        // g2.drawImage(tiles[0].image,0,0,gp.tileSize,gp.tileSize,);
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        int tileNumber = mapTileNumber[col][row];
        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            tileNumber = mapTileNumber[col][row];
            g2.drawImage(tile[tileNumber].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
