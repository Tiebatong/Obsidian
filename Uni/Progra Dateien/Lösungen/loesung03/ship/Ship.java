static void main() {
    StdDraw.setScale(0, 7);
    
    drawShip();
    drawMast();
    drawSail();
}

static void drawShip() {
    StdDraw.line(1, 2, 6, 2);
    StdDraw.line(6, 2, 5, 1);
    StdDraw.line(5, 1, 2, 1);
    StdDraw.line(2, 1, 1, 2);
}

static void drawMast() {
    StdDraw.line(3.5, 2, 3.5, 5.5);
}

static void drawSail() {
    StdDraw.line(1.5, 3, 3.5, 3);
    StdDraw.line(1.5, 3, 3.5, 5.5);
}
