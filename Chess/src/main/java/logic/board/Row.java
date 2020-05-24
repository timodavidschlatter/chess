package logic.board;

import javafx.scene.paint.Color;

public class Row {

    private String numbering;
    private Tile[] tiles;
    private final int numOfTiles;

    public Row(String numbering) {
        this.numbering = numbering;
        this.numOfTiles = 8;
        this.tiles = new Tile[numOfTiles];
        createTiles();
    }

    private void createTiles() {
        for(int i = 0; i < numOfTiles; i++) {
            Color c = i % 2 == 0 ? Color.BLACK : Color.WHITE; //TODO
            Tile t = new Tile(c, numbering);
            tiles[i] = t;
        }
    }

}
