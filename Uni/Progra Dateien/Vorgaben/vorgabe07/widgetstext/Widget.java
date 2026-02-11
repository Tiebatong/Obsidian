/**
 * A widget is a user interface element.
 * Widgets may contain other widgets as children.
 */
abstract class Widget {
    private boolean enabled = true;
    
    Widget() {
        System.out.println("new widget constructed");
    }
    
    /**
     * Disables or enables this widget. Disabled widgets are drawn gray-ish.
     */
    void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     * Returns whether this widget is enabled.
     */
    boolean isEnabled() {
        return enabled;
    }
    
    /**
     * String representation of this widget.
     * Subclasses should override this method sensibly.
     */
    @Override
    public String toString() {
        String stringRepresentation = "(" + getWidth() + "×" + getHeight() + ")";
        if(enabled) {
            return stringRepresentation;
        }
        return stringRepresentation + "{disabled}";
    }

    /**
     * Returns the height of the widget, i.e. the horizontal space needed to draw this widget.
     */
    abstract int getHeight();

    /**
     * Returns the width of the widget, i.e. the vertical space needed to draw this widget.
     */
    abstract int getWidth();
    
    /**
     * Draws this widget.
     * draw() must not assume a certain default pen color, but can assume the default pen radius.
     * @param xOffset: Indicates how many pixels away from the left border of the window this widget should be drawn.
     * @param yOffset: Indicates how many pixels below the top border of the window this widget should be drawn. Remember that 0 is at the bottom of the window, i.e. yOffset is typically > 0.
     */
    abstract void draw(int xOffset, int yOffset);
}
