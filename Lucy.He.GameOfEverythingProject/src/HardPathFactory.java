import javafx.scene.shape.CubicCurveTo;

/**
 * Class name: HardPathFactory
 *
 * @author Lucy He
 * This class extends the PathFactory class, and creates random cubic curve path transitions used on UpperClassCats that are hard to predict.
 */
public class HardPathFactory extends PathFactory {
    private CubicCurveTo hCubicCurveTo1;
    private CubicCurveTo hCubicCurveTo2;
    private CubicCurveTo vCubicCurveTo3;
    private CubicCurveTo vCubicCurveTo4;

    /**
     * Constructor
     */
    protected HardPathFactory() {
        init();
    }

    /**
     * Overriden init() method to create random cubic curve paths
     */
    @Override
    protected void init() {
        super.init();
        //horizontal paths
        hCubicCurveTo1 = new CubicCurveTo(1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), 700 * random.nextDouble(), 1100, 700 * random.nextDouble());
        hCubicCurveTo2 = new CubicCurveTo(1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), 700 * random.nextDouble(), -100, 700 * random.nextDouble());
        path1.getElements().addAll(hMove1, hCubicCurveTo1);
        path2.getElements().addAll(hMove2, hCubicCurveTo2);
        //vertical paths
        vCubicCurveTo3 = new CubicCurveTo(1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), 800);
        vCubicCurveTo4 = new CubicCurveTo(1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), 700 * random.nextDouble(), 1000 * random.nextDouble(), -100);
        path3.getElements().addAll(vMove3, vCubicCurveTo3);
        path4.getElements().addAll(vMove4, vCubicCurveTo4);
    }

    /**
     * Overriden update() method to create random cubic curve paths
     */
    @Override
    protected void update() {
        super.update();
        CubicCurveTo[] cubicCurves = {hCubicCurveTo1, hCubicCurveTo2, vCubicCurveTo3, vCubicCurveTo4};
        for (int i = 0; i < cubicCurves.length; i++) {
            cubicCurves[i].setControlX1(1000 * random.nextDouble());
            cubicCurves[i].setControlX2(1000 * random.nextDouble());
            cubicCurves[i].setControlY1(700 * random.nextDouble());
            cubicCurves[i].setControlY2(700 * random.nextDouble());
        }
        hCubicCurveTo1.setY(700 * random.nextDouble());
        hCubicCurveTo2.setY(700 * random.nextDouble());
        vCubicCurveTo3.setX(1000 * random.nextDouble());
        vCubicCurveTo4.setX(1000 * random.nextDouble());
    }
}
