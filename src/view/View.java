package view;

import javax.swing.*;
import java.awt.*;
import model.Tile;

public class View extends JPanel {


    private static final int TILE_SIZE = 82;
    private static final int RESERVE = 20;
    private static final int SPACE_VALUE = 70;
    private static final Color BACKGROUND_COLOR = new Color(0x37474f);
    private static final String FONT_NAME = "Arial";
    private static final String FONT_NUMBERS = "Open Sans";
    private static final String MSG_WELCOME = "Welcome! Have Fun!";
    private Tile[] tiles;

    private static int defineOffset(int offset) {
        return RESERVE + offset * (RESERVE + TILE_SIZE);
    }

    public void drawTile(Graphics g2, Tile tile, int x, int y) {

        // Rendering images
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        // Making title message
        g.setColor(new Color(0xffffff));
        g.setFont(new Font(FONT_NAME, Font.ITALIC, 30));
        g.drawString(MSG_WELCOME, 60,50);


        // Making the tile
        int xOffset = defineOffset(x);
        int yOffset = defineOffset(y) + SPACE_VALUE;
        g.setColor(tile.getTileBG());
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 30, 30);

        // making number on the tile
        final int number = tile.getValue();
        final int size = number < 1024 ? 32 : 26;
        final Font font = new Font(FONT_NUMBERS, Font.ITALIC, size);

        g.setFont(font);
        String s = String.valueOf(number);
        final FontMetrics fm = getFontMetrics(font);
        final int w = fm.stringWidth(s);
        final int h = (int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

        g.setColor(new Color(0x212121));
        if (number != 0)
            g.drawString(s, xOffset + (TILE_SIZE - w) / 2 - 2, yOffset + (TILE_SIZE - h) / 2 - 2);

    }

}
