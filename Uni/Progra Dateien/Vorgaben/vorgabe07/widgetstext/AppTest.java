class AppTest {

    static void main() {
        
        VerticalLayout layout = new VerticalLayout();
        layout.add(new Label("Test"));
        
        System.out.println(layout.numberOfWidgets()); // Warum geht das ...
        
        Widget widget = layout;
        // System.out.println(widget.numberOfWidgets()); // ... aber das hier nicht?
    
    }

}
