class Label extends Widget {
    private final String text;
    
    Label(String text) {
        this.text = text;
    }
    
    @Override
    int getHeight() {
        return 20;
    }

    @Override
    int getWidth() {
        return 8 * text.length();
    }
    
    @Override
    void draw(int xOffset, int yOffset) {
        StdDraw.setPenColor(isEnabled() ? StdDraw.BLACK : StdDraw.GRAY);
        StdDraw.textLeft(xOffset, yOffset - getHeight() / 2, text);
    }
    
    @Override
    public String toString() {
        return "Label"  + super.toString() + "[" + text + "]";
    }
}
