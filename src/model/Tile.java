package model;

import java.awt.*;

public class Tile {

    public  int value;

    public Tile() {
        this(0);
    }

    public Tile(int num) {
        value = num;
    }

    public boolean isEmpty() {
        return value == 0;
    }


    public Color getTileBG() {
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
                return new Color(0xdd2c00);
            default:
                return new Color(0xfffde7);
        }

    }

    public int getValue() {
        return value;
    }
}
