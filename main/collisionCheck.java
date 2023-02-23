package main;

import entity.Entity;

public class collisionCheck {
    GamePanel gp;
    public collisionCheck(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX+entity.solidArea.x;
        int entityRightWorldX = entity.worldX+entity.solidArea.x+entity.solidArea.width;
        int entityTopWorldY = entity.worldY+entity.solidArea.y;
        int entityBottomWorldY = entity.worldY+entity.solidArea.y+entity.solidArea.height; 
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        int tileNum1, tileNum2;
        if(entity.direction == "up"){
            entityTopRow =(entityTopWorldY-entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityTopRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
        if(entity.direction == "down"){
            entityBottomRow =(entityBottomWorldY+entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
        if(entity.direction == "left"){
            entityLeftCol =(entityLeftWorldX-entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityLeftCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityLeftCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }}
        if(entity.direction == "right"){
            entityRightCol =(entityRightWorldX+entity.speed)/gp.tileSize;
            tileNum1 = gp.tilesM.mapTileNumber[entityRightCol][entityTopRow];
            tileNum2 = gp.tilesM.mapTileNumber[entityRightCol][entityBottomRow];
            if(gp.tilesM.tile[tileNum1].collision== true|| gp.tilesM.tile[tileNum2].collision== true){
                entity.collisionEnabled = true;
            }
        }
    }    
}

