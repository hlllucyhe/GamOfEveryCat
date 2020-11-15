import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

/**
 * Class name: EasyPathFactory
 *
 * @author Lucy He
 * This class extends the PathFactory class, and creates random straight line path transitions used on LowerClassCats that are easy to predict.
 */
public class EasyPathFactory extends PathFactory {
    private LineTo hLineTo1;
    private LineTo hLineTo2;
    private LineTo vLineTo3;
    private LineTo vLineTo4;

    /**
     * Constructor
     */
    protected EasyPathFactory() {
        init();
    }

    /**
     * Overriden init() method to create random horizontal or vertical linear paths
     */
    @Override
    protected void init() {
        double randomY = 700 * random.nextDouble();
        double randomX = 1000 * random.nextDouble();
        //horizontal paths
        hMove1 = new MoveTo(-100, randomY);
        hMove2 = new MoveTo(1100, randomY);
        hLineTo1 = new LineTo(1100, randomY);
        hLineTo2 = new LineTo(-100, randomY);
        path1.getElements().addAll(hMove1, hLineTo1);
        path2.getElements().addAll(hMove2, hLineTo2);
        //vertical paths
        vMove3 = new MoveTo(randomX, -100);
        vMove4 = new MoveTo(randomX, 800);
        vLineTo3 = new LineTo(randomX, 800);
        vLineTo4 = new LineTo(randomX, -100);
        path3.getElements().addAll(vMove3, vLineTo3);
        path4.getElements().addAll(vMove4, vLineTo4);
    }

    /**
     * Overriden update() method to create a new random horizontal or vertical linear paths
     */
    @Override
    protected void update() {
        double randomY = 700 * random.nextDouble();
        double randomX = 1000 * random.nextDouble();
        hMove1.setY(randomY);
        hMove2.setY(randomY);
        vMove3.setX(randomX);
        vMove4.setX(randomX);
        hLineTo1.setY(randomY);
        hLineTo2.setY(randomY);
        vLineTo3.setX(randomX);
        vLineTo4.setX(randomX);
    }
}
