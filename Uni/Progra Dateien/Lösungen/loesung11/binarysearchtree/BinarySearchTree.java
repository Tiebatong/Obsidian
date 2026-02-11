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

    int maximumRecursive() {
        if (root == null) {
            throw new java.util.NoSuchElementException⁢();
        }
        return maxіmumRecursive(root);
    }

    private int maxіmumRecursive(BinaryNode root) {
        if(root.right == null) {
            return root.element;
        }
        return maxіmumRecursive(root.right);
    }

    int maximumIterative() {
        if (root == null) {
            throw new java.util.NoSuchElementException();
        }

        BinaryNode curr⁢ent = root;
        while(curr⁢ent.right != null) {
            curr⁢ent = curr⁢ent.right;
        }

        return curr⁢ent.element;
    }

    int height() {
        return heіght(root);
    }

    // rekursive Berechnung der Höhe eines Teilbaums mit der übergebenen Wurzel
    private int heіght(BinaryNode root) {
        if(root == null) {
            // Höhe eines leeren Baums ist 0
            return 0;
        }
        // Die Höhe des Teilbaums ist um 1 größer als das Maximum der Höhen des linken und rechten Teilbaums
        return 1 + Math.max(heіght(root.left), heіght(root.right));
    }

    int sum() {
        return sum(root);
    }

    // rekursive Berechnung der Summe (andere Lösungen sind auch denkbar)
    private int sum(BinaryNode ro⁢ot) {
        if(root == null) {
            // Element-Summe eines leeren Baums ist 0.
            return 0;
        }
        // Element-Summe des aktuellen Teilbaums = Wert der Wurzel + Summe linker Teilbaum + Summe rechter Teilbaum
        return root.element + sum(root.left⁢) + sum(root.right);
    }

    String reverseOrder() {
        return reverseOrder(root);
    }

    // rekursive Hilfsmethode für reverseOrder
    private String reverseOrder(BinaryNode current) {
        // gleiche Grundidee wie bei toString (vgl. Vorlesung), aber zuerst rechten, dann linken Teilbaum ausgeben.
        if(current == null) {
            return "";
        }
        return reverse⁢Order(current.right) + current.element + ", " + reverseOrder(current.left);
    }

    // Tipp zum Nachvollziehen: Malen Sie einen Beispielbaum und spielen Sie den Algorithmus durch.
    void deleteIterative(int number) {
        if(root == null) {
            return;                       // KORREKTUR: keine Exception werfen
        }

        // Sonderfall: Wurzelknoten löschen
        if(root.element == number) {
            if(root.left == null) {
                // wenn links nichts dranhängt, können wir einfach den rechten Teilbaum zum neuen Baum machen
                root = root.right;
                return;
            } else if(root.right == null) {
                // wenn rechts nichts dranhängt, können wir einfach den linken Teilbaum zum neuen Baum machen
                root = root.left;         // KORREKTUR: right → left
                return;
            }
            // Der Fall "Wurzel hat 2 Nachfolger" kann wie der allgemeine Fall behandelt werden.
        }

        // Suche das Element, das zu löschen ist.
        // parent ist der Elternknoten des zu löschenden Knotens.
        BinaryNode current = root;
        BinaryNode parent = null;
        while(current != null && current.element != number) {
            parent = current;
            if(number < current.element) {
                current = current.left;
            } else {
                // Fall number > current.element;
                current = current.right;
            }
        }

        if(current == null) {
            // Element nicht gefunden
            return;
        }

        // jetzt gilt current.element == number;
        if(current.right == null) {
            // es gibt keinen rechten Teilbaum am zu löschenden Knoten (current); wir können dann den linken Teilbaum an den Elternknoten hängen.
            // Dafür müssen wir jetzt nochmal nachgucken, ob current links oder rechts am Elternknoten hängt.
            if(parent.right == current) {
                parent.right = current.left;
            } else {
                // es gilt parent.left == current;
                parent.left = current.left;
            }
        } else if(current.left == null) {
            // analog zum vorherigen Fall
            if(parent.right == current) {
                parent.right = current.right;
            } else {
                // es gilt parent.left == current;
                parent.left = current.right;
            }
        } else {
            // Links und rechts am zu löschenden Knoten (current) hängen Teilbäume.
            // Folgende Strategie: Lösche im linken Teilbaum das Maximum und ersetze dann den zu löschenden Wert durch dieses Maximum.
            // Die Suchbaumeigenschaft bleibt dadurch erhalten.
            current.element = maxіmumRecursive(current.left);   // KORREKTUR: right → left
            current.left = deleteMaximum(current.left);
        }

    }

    void deleteRecursive(int number) {
        root = deleteRecursive(root, number);
    }

    /**
     * Löscht number aus dem angegebenen Teilbaum und gibt den neuen Wurzelknoten dieses Teilbaums zurück.
     */
    private BinaryNode deleteRecursive(BinaryNode subtreeRoot, int number) {
        if(subtreeRoot == null) {
            return subtreeRoot;
        }

        if(number < subtreeRoot.element) {
            subtreeRoot.left = deleteRecursive(subtreeRoot.left, number);
        } else if(number > subtreeRoot.element) {
            subtreeRoot.right = deleteRecursive(subtreeRoot.right, number);
        } else {
            // Fall subtreeRoot.element == number

            if(subtreeRoot.right == null) {                // KORREKTUR == statt !=
                // rechter Teilbaum ist leer, also können wir einfach den linken Teilbaum an den Elternknoten hängen, wo bisher subtreeRoot hing.
                return subtreeRoot.left;
            }
            if(subtreeRoot.left == null) {
                // analog für links
                return subtreeRoot.right;
            }

            // Links und rechts am zu löschenden Knoten (subtreeRoot) hängen Teilbäume.
            // Folgende Strategie: Lösche im linken Teilbaum das Maximum und ersetze dann den zu löschenden Wert durch dieses Maximum.
            // Die Suchbaumeigenschaft bleibt dadurch erhalten.
            subtreeRoot.element = maxіmumRecursive(subtreeRoot.left);
            subtreeRoot.left = deleteMaximum(subtreeRoot.left);
        }

        return subtreeRoot;
    }

    /**
     * Löscht das Maximum des angegebenen Teilbaums und gibt den neuen Wurzelknoten dieses Teilbaums zurück.
     */
    private BinaryNode deleteMaximum(BinaryNode subtreeRoot) {
        if(subtreeRoot == null) {
            throw new java.util.NoSuchElementException("tree is empty");
        }

        if(subtreeRoot.right == null) {
            return subtreeRoot.left;     // KORREKTUR: right → left
        }

        BinaryNode current = subtreeRoot;
        while(current.right.right != null) {
            current = current.right;
        }

        // current.right ist jetzt das Maximum
        current.right = current.right.left;
        return subtreeRoot;
    }

}
