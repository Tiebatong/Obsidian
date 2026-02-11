public interface DragListener {
    /**
    The listener interface for receiving mouse drag events.

    The class that is interested in processing a mouse being dragged can implement this interface.
    You can add a DragListener l to a Draw instance d by calling d.addDragListener(l).
    
    @param x current x position of the mouse
    @param x current y position of the mouse
     */
    public void mouseDragged(double x, double y);
}
