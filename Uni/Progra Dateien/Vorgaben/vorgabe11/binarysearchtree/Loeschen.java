// Tipp zum Nachvollziehen: Malen Sie einen Beispielbaum und spielen Sie den Algorithmus durch.
void deleteIterative(int number) {
    if(root == null) {
        throw new java.util.NoSuchElementException("tree is empty");
    }

    // Sonderfall: Wurzelknoten löschen
    if(root.element == number) {
        if(root.left == null) {
            // wenn links nichts dranhängt, können wir einfach den rechten Teilbaum zum neuen Baum machen
            root = root.right;
            return;
        } else if(root.right == null) {
            // wenn rechts nichts dranhängt, können wir einfach den linken Teilbaum zum neuen Baum machen
            root = root.right;
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
        current.element = maximumRecursive(current.right);
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

        if(subtreeRoot.right != null) {
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
        subtreeRoot.element = maximumRecursive(subtreeRoot.left);
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
        return subtreeRoot.right;
    }

    BinaryNode current = subtreeRoot;
    while(current.right.right != null) {
        current = current.right;
    }

    // current.right ist jetzt das Maximum
    current.right = current.right.left;
    return subtreeRoot;
}
