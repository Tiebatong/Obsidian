// Wrapper for java.awt.Color so that we do not have to write "java.awt.Color" everywhere and can introduce import statements later
public class Color extends java.awt.Color {
    public Color(int r, int g, int b) {
        super(r, g, b);
    }
    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }
    public Color(int rgb) {
        super(rgb);
    }
    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }
    
    // as defined in https://github.com/srisatish/openjdk/blob/master/jdk/src/share/classes/java/awt/Color.java
    public final static Color white = new Color(255, 255, 255);
    public final static Color WHITE = white;
    public final static Color lightGray = new Color(192, 192, 192);
    public final static Color LIGHT_GRAY = lightGray;
    public final static Color gray = new Color(128, 128, 128);
    public final static Color GRAY = gray;
    public final static Color darkGray = new Color(64, 64, 64);
    public final static Color DARK_GRAY = darkGray;
    public final static Color black = new Color(0, 0, 0);
    public final static Color BLACK = black;
    public final static Color red = new Color(255, 0, 0);
    public final static Color RED = red;
    public final static Color pink = new Color(255, 175, 175);
    public final static Color PINK = pink;
    public final static Color orange = new Color(255, 200, 0);
    public final static Color ORANGE = orange;
    public final static Color yellow = new Color(255, 255, 0);
    public final static Color YELLOW = yellow;
    public final static Color green = new Color(0, 255, 0);
    public final static Color GREEN = green;
    public final static Color magenta = new Color(255, 0, 255);
    public final static Color MAGENTA = magenta;
    public final static Color cyan = new Color(0, 255, 255);
    public final static Color CYAN = cyan;
    public final static Color blue = new Color(0, 0, 255);
    public final static Color BLUE = blue;
}
