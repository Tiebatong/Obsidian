/**
 * A window is the top-level user interface element which displays a single widget.
 */
class Window {
    private final Widget widget;
    
    Window(Widget widget) {
        this.widget = widget;
    }
    
    void draw() {
        StdDraw.setCanvasSize(widget.getWidth(), widget.getHeight());
        StdDraw.setXscale(0, widget.getWidth());
        StdDraw.setYscale(1, widget.getHeight());
        
        widget.draw(0, widget.getHeight());
    }
    
    @Override
    public String toString() {
        return "Window[\n" + widget.toString() + "\n]";
    }
}
