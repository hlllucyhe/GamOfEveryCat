import javafx.scene.shape.LineTo;

/**
 * Class name: MediumPathFactory
 *
 * @author Lucy He
 * This class extends the PathFactory class, and creates random linear path transitions used on MiddleClassCats that are okay to predict.
 */
public class MediumPathFactory extends PathFactory {
    private LineTo hLineTo1;
    private LineTo hLineTo2;
    private LineTo vLineTo3;
    private LineTo vLineTo4;

    /**
     * Constructor
     */
    protected MediumPathFactory() {
        init();
    }

    /**
     * Overriden init() method to create random linear paths.
     */
    @Override
    protected void init() {
        super.init();
        hLineTo1 = new LineTo(1100, 700 * random.nextDouble());
        hLineTo2 = new LineTo(-100, 700 * random.nextDouble());
        vLineTo3 = new LineTo(1000 * random.nextDouble(), 800);
        vLineTo4 = new LineTo(1000 * random.nextDouble(), -100);
        path1.getElements().addAll(hMove1, getLineTo(1));
        path2.getElements().addAll(hMove2, getLineTo(0));
        path3.getElements().addAll(vMove3, getLineTo(3));
        path4.getElements().addAll(vMove4, getLineTo(2));
    }

    /**
     * method name: getLineTo()
     * This method randomly selects an ending point of a path that is not placed on the same side as the starting point.
     *
     * @param initialSide the side that the starting point is created on
     * @return the randomly selected LineTo element.
     */
    private LineTo getLineTo(int initialSide) {
        int i = random.nextInt(3);
        while (i == initialSide) {
            i = random.nextInt(3);
        }
        if (i == 0) {
            return hLineTo1;
        } else if (i == 1) {
            return hLineTo2;
        } else if (i == 2) {
            return vLineTo3;
        }
        return vLineTo4;
    }

    /**
     * Overriden update() method to create random linear paths.
     */
    @Override
    protected void update() {
        super.update();
        hLineTo1.setY(700 * random.nextDouble());
        hLineTo2.setY(700 * random.nextDouble());
        vLineTo3.setX(1000 * random.nextDouble());
        vLineTo4.setX(1000 * random.nextDouble());
    }
}
