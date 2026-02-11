/**
 * A HorizontalLayout contains several widgets which are drawn next to each other.
 */
class HorizontalLayout extends Layout {
    /**
     * The width of a horizontal layout is the sum of the widths of its children widgets.
     */
    @Override
    int getWidth() {
        int totalWidth = 0;
        for(int i = 0; i < numberOfWidgets(); i++) {
            totalWidth += widgetAt(i).getWidth();
        }
        return totalWidth;
    }
    
    /**
     * The height of a horizontal layout is the maximum of the heights of its children widgets.
     */
    @Override
    int getHeight() {
        int maxHeight = 0;
        for(int i = 0; i < numberOfWidgets(); i++) {
            maxHeight = Math.max(maxHeight, widgetAt(i).getHeight());
        }
        return maxHeight;
    }
    
    @Override
    void draw(int xOffset, int yOffset) {
        for(int i = 0; i < numberOfWidgets(); i++) {
            widgetAt(i).draw(xOffset, yOffset);
            xOffset += widgetAt(i).getWidth();
        }
    }
    
    @Override
    public String toString() {
        return "Horizontal" + super.toString();
    }
}
