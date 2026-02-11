/**
 * A Layout has child widgets. How they are drawn depends on the concrete layout type and is defined in subclasses.
 */
abstract class Layout extends Widget {
    private final WidgetList widgets = new WidgetList();
    
    /**
     * Adds a new widget to this layout.
     * If the layout is currently disabled, the widget will be disabled.
     */
    void add(Widget widget) {
        widgets.add(widget);
        if(!isEnabled()) {
            widget.setEnabled(false);
        }
    }
    
    int numberOfWidgets() {
        return widgets.size();
    }
    
    Widget widgetAt(int index) {
        return widgets.get(index);
    }
    
    /**
     * Disabling/enabling a layout disables/enables all child widgets.
     */
    @Override
    void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        for(int i = 0; i < numberOfWidgets(); i++) {
            widgetAt(i).setEnabled(enabled);
        }
    }
    
    @Override
    public String toString() {
        String childrenString = "\n";
        for(int i = 0; i < numberOfWidgets(); i++) {
            childrenString += widgetAt(i).toString() + ",\n";
        }
        return "Layout" + super.toString() + "[" + childrenString + "]";
    }
}
