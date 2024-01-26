package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    /*xBegin should be the left corner of the rectangular*/
    public void addHexagon(int size, TETile[][] world, TETile hexagon, int xBegin, int yBegin){// I thought need "a"
        drawHalfHex(size, world, hexagon, xBegin, yBegin + size, 1);
        drawHalfHex(size, world, hexagon, xBegin, yBegin + size - 1, -1);

    }

    /*If the sign is 1, the sequence should be from small to big
    If the sign is -1, the sequence should be from big to small
    The xBegin should be the middle of the left
    * */
    public void drawHalfHex(int size, TETile[][] world, TETile hexagon, int xBegin, int yBegin, int sign){
        // hexagon can be eliminated
        int x = xBegin;
        int y = yBegin;

        //sign is 1 or -1
        for(int j = 0; j<3; j++) {
            for (int i = j; i < 3 * size - 2 - j; i++) {
                world[i][y+sign*j]=Tileset.FLOWER;
            }
        }
    }



    public static void main(String[] args){
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT]; // need to initialize the 2-d arrays
        for(int x = 0; x< WIDTH; x++){
            for(int y = 0; y< HEIGHT; y++){
                world[x][y] = Tileset.NOTHING;
            }
        }
        //don't know what character is for
        TETile hex = new TETile('N',Color.red, Color.black, "red hextagons in black background");
        HexWorld hw = new HexWorld();
        hw.addHexagon(3, world,Tileset.FLOWER, 20, 20);

        // draws the world to the screen
        ter.renderFrame(world);
    }


}
