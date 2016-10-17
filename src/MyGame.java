import javax.swing.*;
import java.awt.*;

public class MyGame extends JPanel {

    private static final Color BG_COLOR = new Color(0x37474f);
    private static final String FONT_NAME = "Arial";
    private static final int TILE_SIZE = 82;
    private static final int TILES_MARGIN = 20;
    private Tile[] tiles;

    @Override
    public void paint(Graphics g) {
        tiles = new Tile[4 * 4];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile();
            tiles[i].value =(int)Math.pow((double)2,(double)i);
        }
        super.paint(g);
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                drawTile(g, tiles[x + y * 4], x, y);
            }
        }

    }

    private void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);

        g.setColor(new Color(0xffffff));
        String welcome = "Welcome! Have Fun!";
        g.setFont(new Font(FONT_NAME, Font.ITALIC, 30));
        g.drawString(welcome, 60,50);

        int value = tile.value;

        int xOffset = offsetCoors(x);
        int yOffset = offsetCoors(y) + 70;
        g.setColor(tile.getBackground());
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 30, 30);

        g.setColor(getForeground());
        final int size = value < 100 ? 36 : value < 1000 ? 32 : 24;
        final Font font = new Font("Open Sans", Font.ITALIC, size);
        g.setFont(font);

        String s = String.valueOf(value);
        final FontMetrics fm = getFontMetrics(font);

        final int w = fm.stringWidth(s);
        final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

        if (value != 0)
            g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);

    }

    private static int offsetCoors(int arg) {
        return arg * (TILES_MARGIN + TILE_SIZE) + TILES_MARGIN ;
    }

    static class Tile {
        int value;

        public Tile() {
            this(0);
        }

        public Tile(int num) {
            value = num;
        }

        public boolean isEmpty() {
            return value == 0;
        }


        public Color getBackground() {
            switch (value) {
                case 2:
                    return new Color(0xfff9c4);
                case 4:
                    return new Color(0xfff59d);
                case 8:
                    return new Color(0xfff176);
                case 16:
                    return new Color(0xffee58);
                case 32:
                    return new Color(0xffeb3b);
                case 64:
                    return new Color(0xfdd835);
                case 128:
                    return new Color(0xfbc02d);
                case 256:
                    return new Color(0xf9a825);
                case 512:
                    return new Color(0xf57f17);
                case 1024:
                    return new Color(0xff6d00);
                case 2048:
                    return new Color(0xe65100);
                case 4096:
                    return new Color(0xff3d00);
                case 8192:
                    return new Color(0xd50000);
                default:
                    return new Color(0xfffde7);
            }

        }
    }


    public static void main(String[] args) {
        JFrame game = new JFrame();
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(428, 568);
        game.setResizable(false);
        game.add(new MyGame());
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

}
