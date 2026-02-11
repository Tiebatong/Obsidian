public interface KeyboardListener {
    /**
    The listener interface for receiving key presses.

    The class that is interested in processing a key being pressed can implement this interface.
    You can add a KeyboardListener l to a Draw instance d by calling d.addKeyboardListener(l).
    
    @param c character which has been typed
     */
    public void keyTyped(char c);
}
