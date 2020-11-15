import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class name: LowerClassCat
 *
 * @author Lucy He
 * This class extends the Cat class, and creates LowerClassCats with deduction values between 1-4.
 * It is responsible for creating each specific cats with unique images and deduction points, as well as moving the Cat object along a path transition.
 */
public class LowerClassCat extends Cat {
    /**
     * Constructor
     *
     * @param image     the image of the cat
     * @param root      the group of elements presented in GUI
     * @param deduction the integer value of point deduction for each cat
     */
    private LowerClassCat(Image image, Group root, int deduction) {
        super(image, root, deduction);
    }

    /**
     * method name: move()
     * This method retrieves an easy path transition and applies it on the cat node.
     */
    public void move() {
        PathTransition pathTransition = PathFactory.getLevel(1).getPath(root);
        pathTransition.setNode(cat);
        pathTransition.play();
    }

    /**
     * method name: getLowerClassCat()
     * This method provides access to the LowerClassCats object by creating a random LowerClassCat and returning it.
     *
     * @param root the group of elements presented in GUI
     * @return randomly generated LowerClassCat
     * @throws FileNotFoundException error when the image file cannot be read
     */
    protected static Cat getLowerClassCat(Group root) throws FileNotFoundException {
        int num = random.nextInt(4);
        if (num == 0) {
            return new LowerClassCat(new Image(new FileInputStream("Resources/Persian.png")), root, -1);
        } else if (num == 1) {
            return new LowerClassCat(new Image(new FileInputStream("Resources/RussianBlue.png")), root, -2);
        } else if (num == 2) {
            return new LowerClassCat(new Image(new FileInputStream("Resources/Manx.png")), root, -3);
        }
        return new LowerClassCat(new Image(new FileInputStream("Resources/Bombay.png")), root, -4);
    }
}
