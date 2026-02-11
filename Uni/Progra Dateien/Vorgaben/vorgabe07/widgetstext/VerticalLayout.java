/**
 * A VerticalLayout contains several widgets which are drawn underneath each other.
 */
class VerticalLayout extends Layout {
    /**
     * The width of a vertical layout is the maximum width of its children widgets.
     */
    @Override
    int getWidth() {
        int maxWidth = 0;
        for(int i = 0; i < numberOfWidgets(); i++) {
            maxWidth = Math.max(maxWidth, widgetAt(i).getWidth());
        }
        return maxWidth;
    }
    
    /**
     * The height of a vertical layout is the sum of the heights of its children widgets.
     */
    @Override
    int getHeight() {
        int totalHeight = 0;
        for(int i = 0; i < numberOfWidgets(); i++) {
            totalHeight += widgetAt(i).getHeight();
        }
        return totalHeight;
    }
    
    @Override
    void draw(int xOffset, int yOffset) {
        for(int i = 0; i < numberOfWidgets(); i++) {
            widgetAt(i).draw(xOffset, yOffset);
            yOffset -= widgetAt(i).getHeight();
        }
    }
    
    @Override
    public String toString() {
        return "Vertical" + super.toString();
    }
}
