package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    private static final long SEED = 123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * 
     * @param tiles
     */
    public static void addHexagon(int s, int startx, int starty, TETile[][] hexagon) {
        int x0 = startx;
        int y0 = starty;
        int endx = startx + s;
        int endy = starty - s;

        hexagon[x0][y0] = randomTile();
        for (int y = starty; y > endy; y -= 1) {
            for (int x = startx; x < endx; x += 1) {
                hexagon[x][y] = hexagon[x0][y0];
            }
            startx -= 1;
            endx += 1;
        }

        for (int y = (starty - s); y > (starty - 2 * s); y -= 1) {
            for (int x = (startx + 1) ; x < (endx - 1); x += 1) {
                hexagon[x][y] = hexagon[x0][y0];
            }
            startx += 1;
            endx -= 1;
        }

    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.TREE;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.GRASS;
            case 3: return Tileset.MOUNTAIN;
            case 4: return Tileset.SAND;
            default: return Tileset.WATER;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] hexagon = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                hexagon[x][y] = Tileset.NOTHING;
            }
        }
        // adds a hexagon of side length s to a given position in the world
        int s = 3;
        int startxx = 3;
        int startyy = 23;
        addHexagon(s, startxx, startyy, hexagon);
        addHexagon(s, startxx, startyy - 2 * s, hexagon);
        addHexagon(s, startxx, startyy - 4 * s, hexagon);
        addHexagon(s, startxx + (2 * s -1), startyy - 5 * s, hexagon);
        addHexagon(s, startxx + (2 * s -1), startyy - 3 * s, hexagon);
        addHexagon(s, startxx + (2 * s -1), startyy - 1 * s, hexagon);
        addHexagon(s, startxx + (2 * s -1), startyy + 1 * s, hexagon);
        addHexagon(s, startxx + 2 * (2 * s - 1), startyy + 2 * s, hexagon);
        addHexagon(s, startxx + 2 * (2 * s - 1), startyy, hexagon);
        addHexagon(s, startxx + 2 * (2 * s - 1), startyy - 2 * s, hexagon);
        addHexagon(s, startxx + 2 * (2 * s - 1), startyy - 4 * s, hexagon);
        addHexagon(s, startxx + 2 * (2 * s - 1), startyy - 6 * s, hexagon);
        addHexagon(s, startxx + 3 * (2 * s - 1), startyy - 5 * s, hexagon);
        addHexagon(s, startxx + 3 * (2 * s - 1), startyy - 3 * s, hexagon);
        addHexagon(s, startxx + 3 * (2 * s - 1), startyy - 1 * s, hexagon);
        addHexagon(s, startxx + 3 * (2 * s - 1), startyy + 1 * s, hexagon);
        addHexagon(s, startxx + 4 * (2 * s - 1), startyy, hexagon);
        addHexagon(s, startxx + 4 * (2 * s - 1), startyy - 2 * s, hexagon);
        addHexagon(s, startxx + 4 * (2 * s - 1), startyy - 4 * s, hexagon);
        // draws the world to the screen
        ter.renderFrame(hexagon);
    }
}
