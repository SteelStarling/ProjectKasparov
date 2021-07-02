package com.mygdx.projectkasparov;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    private final ProjectKasparov game;

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera cam;


    private final int boardSize = 8; //size of the board
    private final int tileSize = 200; //size of the tile in pixels


    private final Texture chessPiecesBase = new Texture(Gdx.files.internal("ChessTileSet.png")); //create Texture of pieces
    private final TextureRegion[][] chessPieces = TextureRegion.split(chessPiecesBase, 200, 200); //split texture into actual pieces

//    private enum PieceColor {
//        //enum fields
//        WHITE(true), BLACK(false);
//
//        private boolean isWhite;
//
//        PieceColor(final boolean isWhite){
//            this.isWhite = isWhite;
//        }
//
//        boolean getWhite(){
//            return this.isWhite;
//        }
//    }
//
//    private enum PieceType {
//        KING("king", 0), QUEEN("queen", 1), ROOK("rook", 2), KNIGHT("knight", 3), BISHOP("bishop", 4), PAWN("pawn", 5);
//
//        private String typeName;
//        private int typeNum;
//
//        PieceType(final String typeName, final int typeNum){
//            this.typeName = typeName;
//            this.typeNum = typeNum;
//        }
//
//        String getTypeName(){
//            return this.typeName;
//        }
//
//        int getTypeNum(){
//            return this.typeNum;
//        }
//    }
//
//    private enum PieceMoves {
//
//    }
//
//    private enum Piece {
//        //enum fields
//        K_W(PieceType.KING, PieceColor.WHITE, "K"),
//        Q_W(PieceType.QUEEN, PieceColor.WHITE, "Q"),
//        R_W(PieceType.ROOK, PieceColor.WHITE, "R"),
//        N_W(PieceType.KNIGHT, PieceColor.WHITE, "N"),
//        B_W(PieceType.BISHOP, PieceColor.WHITE, "B"),
//        P_W(PieceType.PAWN, PieceColor.WHITE, "P"),
//        K_B(PieceType.KING, PieceColor.BLACK, "k"),
//        Q_B(PieceType.QUEEN, PieceColor.BLACK, "q"),
//        R_B(PieceType.ROOK, PieceColor.BLACK, "r"),
//        N_B(PieceType.KNIGHT, PieceColor.BLACK, "n"),
//        B_B(PieceType.BISHOP, PieceColor.BLACK, "b"),
//        P_B(PieceType.PAWN, PieceColor.BLACK, "p");
//
//        private PieceType type;
//        private PieceColor color;
//        private String fenChar;
//
//        Piece(final PieceType type, final PieceColor color, final String fenChar){
//            this.type = type;
//            this.color = color;
//            this.fenChar = fenChar;
//        }
//
//        PieceType getType(){
//            return this.type;
//        }
//
//        PieceColor getColor(){
//            return this.color;
//        }
//
//        String getFenChar(){
//            return this.fenChar;
//        }
//    }

    private final String whiteColor = "#F0DAB5FF"; //color for white tiles
    private final String blackColor = "#B58763FF"; //color for black tiles
    private final String whiteSelectedColor = "#798B60FF"; //color for white tiles when selected by the player
    private final String blackSelectedColor = "#5B6337FF"; //color for black tiles when selected by the player

    private final TextureRegion whiteSpaceTexture = hexStringToTextureRegion(200, 200, whiteColor);
    private final TextureRegion blackSpaceTexture = hexStringToTextureRegion(200, 200, blackColor);
    private final TextureRegion whiteSelectedSpaceTexture = hexStringToTextureRegion(200, 200, whiteSelectedColor);
    private final TextureRegion blackSelectedSpaceTexture = hexStringToTextureRegion(200, 200, blackSelectedColor);

    private final StaticTiledMapTile whiteTile = new StaticTiledMapTile(whiteSpaceTexture);
    private final StaticTiledMapTile blackTile = new StaticTiledMapTile(blackSpaceTexture);
    private final StaticTiledMapTile whiteSelectedTile = new StaticTiledMapTile(whiteSelectedSpaceTexture);
    private final StaticTiledMapTile blackSelectedTile = new StaticTiledMapTile(blackSelectedSpaceTexture);


    public GameScreen(final ProjectKasparov game){
        this.game = game;

        map = new TiledMap(); //TiledMap maps
        MapLayers layers = map.getLayers(); //get layers from map

        TiledMapTileLayer layer = new TiledMapTileLayer(boardSize, boardSize, tileSize, tileSize); //create layer of correct board size
        //loop through and fill layer
        for(int x = 0; x < boardSize; x++){
            for(int y = 0; y < boardSize; y++){
                int boardPosition = y + x; //get position on board for even/odd check
                Cell cell = new Cell(); //get cell
                if(boardPosition % 2 == 0) { //if even, black
                    cell.setTile(new StaticTiledMapTile(blackTile));
                }
                else{ //if odd, white
                    cell.setTile(new StaticTiledMapTile(whiteTile));
                }
                layer.setCell(x, y, cell); //add cell to layer
            }
        }
        layers.add(layer); //add layer to layers

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1600, 1600);
        cam.update();

        renderer = new OrthogonalTiledMapRenderer(map);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta){
        ScreenUtils.clear(0,0,0.2f,1);

        cam.update();
        game.batch.setProjectionMatrix(cam.combined);

        renderer.setView(cam);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    /**
     * Turn Hex String into a TextureRegion of specified width and height
     * @param width  width in pixels for the TextureRegion
     * @param height  height in pixels for the TextureRegion
     * @param hexString  Hex String (formatted "#RRGGBBAA") for the TextureRegion
     * @return  newly created TextureRegion of specified size and color
     */
    private TextureRegion hexStringToTextureRegion(int width, int height, String hexString){
        Pixmap pix = new Pixmap(width, height, Pixmap.Format.RGBA8888); //create Pixmap of correct size
        pix.setColor(Color.rgba8888(Color.valueOf(hexString))); //set color of Pixmap
        pix.fill();
        return new TextureRegion(new Texture(pix)); //create TextureRegion from Pixmap
    }
}
