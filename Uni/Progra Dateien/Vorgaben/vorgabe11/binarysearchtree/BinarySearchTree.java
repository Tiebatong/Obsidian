class BinarySearchTree {

    private class BinaryNode {
        private int element;
        private BinaryNode left;
        private BinaryNode right;

        private BinaryNode(int element) {
            this.element = element;
        }
    }

    private BinaryNode root;

    void insert(int newNumber) {
        // Sonderfall: leerer Baum
        if (root == null) {
            root = new BinaryNode(newNumber);
            return;
        }

        BinaryNode parent = null;
        BinaryNode child = root;
        while (child != null) {
            parent = child;
            if (newNumber == child.element) {
                // Zahl bereits im Baum vorhanden
                return;
            } else if (newNumber < child.element) {
                child = child.left;
            } else {
                child = child.right;
            }
        }

        if (newNumber < parent.element) {
            parent.left = new BinaryNode(newNumber);
        } else {
            parent.right = new BinaryNode(newNumber);
        }
    }

}
