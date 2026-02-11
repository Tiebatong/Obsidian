class Application {
    static void main() {
        Layout verticalLayout = new VerticalLayout();
        
        verticalLayout.add(new Label("Hello World!"));
        
        Layout labelLine = new HorizontalLayout();
        labelLine.add(new Label("This is some text."));
        Label disabledLabel = new Label("This is a disabled text.");
        disabledLabel.setEnabled(false);
        labelLine.add(disabledLabel);
        verticalLayout.add(labelLine);
        
        Layout disabledLabelLine = new HorizontalLayout();
        disabledLabelLine.add(new Label("This line …"));
        disabledLabelLine.add(new Label("… is disabled."));
        disabledLabelLine.setEnabled(false);
        verticalLayout.add(disabledLabelLine);
        
        Layout buttonLine = new HorizontalLayout();
        buttonLine.add(new Button("This is a button"));
        Button disabledButton = new Button("This is a disabled button");
        disabledButton.setEnabled(false);
        buttonLine.add(disabledButton);
        verticalLayout.add(buttonLine);
        
        Layout underlinedLine = new HorizontalLayout();
        underlinedLine.add(new UnderlinedLabel("Underlined text"));
        Label underlinedLabel = new UnderlinedLabel("Underlined text, disabled");
        underlinedLabel.setEnabled(false);
        underlinedLine.add(underlinedLabel);
        verticalLayout.add(underlinedLine);
        
        Window window = new Window(verticalLayout);
        window.draw();
        
        System.out.println(window.toString());
    }

}
