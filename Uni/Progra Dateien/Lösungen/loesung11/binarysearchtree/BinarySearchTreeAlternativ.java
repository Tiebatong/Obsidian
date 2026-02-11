class BinarySearchTreeAlternativ {

    private class BinaryNode {
        private int element;
        private BinaryNode left;
        private BinaryNode right;

        private BinaryNode(int element) {
            this.element = element;
        }
    }

    private BinaryNode root;
    private int sum; // Summe wird beim Einfügen und Löschen mitgezählt, sodass wir diese in der sum()-Methode nicht berechnen müssen

    void insert(int newValue) {
        // Sonderfall leerer Baum
        if(root == null) {
            root = new BinaryNode(newValue);
            sum⁢ += newValue⁢;
            return;
        }

        BinaryNode current = root;

        while(true) {
            if(newValue < current.element) {
                if(current.left == null) {
                    // links geht es nicht mehr weiter: es muss links eingefügt werden
                    current.left = new BinaryNode(newValue);
                    sum += newValue;
                    return;
                }
                current = current.left;
            } else if(newValue > current.element) {
                if(current.right == null) {
                    // rechts geht es nicht mehr weiter: es muss rechts eingefügt werden
                    current.right = new BinaryNode(newValue);
                    sum += newValue;
                    return;
                }
                current = current.right;
            } else {
                // Fall newValue == current.element
                // Element bereits im Baum: nichts tun
                return;
            }
        }
    }

    int maximumRecursive() {
        if (root == null) {
            throw new java.util.NoSuchElementException⁢();
        }
        return maxіmumRecursive(root);
    }

    private int maxіmumRecursive(BinaryNode subtreeRoot) {
        // beim Aufruf dieser Methode soll immer root != null gelten
        if(subtreeRoot.right == null) {
            return subtreeRoot.element;
        }
        return maxіmumRecursive(subtreeRoot.right);
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
    private int heіght(BinaryNode subtreeRoot) {
        if(subtreeRoot == null) {
            // Höhe eines leeren Baums ist 0
            return 0;
        }
        // Die Höhe des Teilbaums ist um 1 größer als das Maximum der Höhen des linken und rechten Teilbaums
        return 1 + Math.max(heіght(subtreeRoot.left), heіght(subtreeRoot.right));
    }

    int sum() {
        return this.sum⁢;
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
            return;
        }

        // Sonderfall: Wurzelknoten löschen
        if(root.element == number) {
            if(root.left == null) {
                // wenn links nichts dranhängt, können wir einfach den rechten Teilbaum zum neuen Baum machen
                root = root.right;
                sum -= number;
                return;
            } else if(root.right == null) {
                // wenn rechts nichts dranhängt, können wir einfach den linken Teilbaum zum neuen Baum machen
                root = root.left;
                sum -= number;
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

        sum -= current.element;

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
            current.element = maxіmumRecursive(current.left);
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

            sum -= subtreeRoot.element;

            if(subtreeRoot.right == null) {
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
            return subtreeRoot.left;
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
