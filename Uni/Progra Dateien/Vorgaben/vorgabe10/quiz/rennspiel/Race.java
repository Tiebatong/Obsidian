class Race implements KeyboardListener {
    private final Racecar[] cars;
    private final Draw canvas;
    
    private static final double SPEED_CHANGE_PER_KEY_PRESS = 0.1;
    private static final double ANGLE_CHANGE_PER_KEY_PRESS = 0.1;
    private static final int FRAMES_PER_SECOND = 25;

    static void main() {
        Race race = new Race();
        race.start();
    }
    
    Race() {
        canvas = new Draw();
        canvas.enableDoubleBuffering();
        canvas.addKeyboardListener(this);
        cars = new Racecar[]{
            new Racecar(),
            new Racecar(Draw.BLUE)
        };
    }
    
    void start() {
        while(true) {
            for(car: cars) {
                System.out.println(car);
                car.draw(canvas);
                car.drive(1. / FRAMES_PER_SECOND);
            }
            canvas.show();
            canvas.pause((int)(1. / FRAMES_PER_SECOND * 1000.));
            canvas.clear();
        }
    }
    
    @Override
    public void keyTyped(char characterTyped) {
        System.out.println(characterTyped + " pressed");
        if (characterTyped == 'w') {
            cars[0].accelerate(SPEED_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 's') {
            cars[0].decelerate(SPEED_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'a') {
            cars[0].turnLeft(ANGLE_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'd') {
            cars[0].turnRight(ANGLE_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'i') {
            cars[1].accelerate(SPEED_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'k') {
            cars[1].decelerate(SPEED_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'j') {
            cars[1].turnLeft(ANGLE_CHANGE_PER_KEY_PRESS);
        } else if (characterTyped == 'l') {
            cars[1].turnRight(ANGLE_CHANGE_PER_KEY_PRESS);
        }
    }

}
