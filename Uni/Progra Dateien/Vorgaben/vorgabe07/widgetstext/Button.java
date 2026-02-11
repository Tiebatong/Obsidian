class Button extends Widget {
    private String text;
    
    Button(String text) {
        this.text = text;
    }
    
    @Override
    int getHeight() {
        return 29;
    }

    @Override
    int getWidth() {
        return 10 * text.length();
    }
    
    @Override
    void draw(int xOffset, int yOffset) {
        StdDraw.setPenRadius(StdDraw.getPenRadius() * 2);
        
        StdDraw.setPenColor(isEnabled() ? StdDraw.GRAY : StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(xOffset + getWidth() / 2, yOffset - getHeight() / 2, getWidth() / 2, getHeight() / 2);
        StdDraw.setPenColor(isEnabled() ? StdDraw.LIGHT_GRAY : StdDraw.WHITE);
        StdDraw.line(xOffset + 2, yOffset - 1, xOffset + getWidth() - 1, yOffset - 1);
        StdDraw.line(xOffset + 1, yOffset - 1, xOffset + 1, yOffset - getHeight() + 3);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.line(xOffset + 1, yOffset - getHeight() + 2, xOffset + getWidth() - 1, yOffset - getHeight() + 2);
        StdDraw.line(xOffset + getWidth() - 1, yOffset - 1, xOffset + getWidth() - 1, yOffset - getHeight() + 2);
        StdDraw.setPenColor(isEnabled() ? StdDraw.BLACK : StdDraw.GRAY);
        StdDraw.text(xOffset + getWidth() / 2, yOffset - getHeight() / 2, text);
        
        StdDraw.setPenRadius(); // reset pen radius
    }
    
    @Override
    public String toString() {
        return "Button" + super.toString() + "[" + text + "]";
    }
}
