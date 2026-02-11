class UnderlinedLabel extends Label {
    UnderlinedLabel(String text) {
        super(text);
    }
    
    @Override
    void draw(int xOffset, int yOffset) {
        super.draw(xOffset, yOffset);
        StdDraw.line(xOffset, yOffset - getHeight() + 2, xOffset + getWidth(), yOffset - getHeight() + 2);
    }
    
    @Override
    public String toString() {
        return "Underlined" + super.toString();
    }
}
