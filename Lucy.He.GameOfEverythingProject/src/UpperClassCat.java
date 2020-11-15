import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class name: UpperClassCat
 *
 * @author Lucy He
 * This class extends the Cat class, and creates LowerClassCats with deduction values between 10-20.
 * It is responsible for creating each specific cats with unique images and deduction points, as well as moving the Cat object along a path transition.
 */
public class UpperClassCat extends Cat {
    /**
     * Constructor
     *
     * @param image     the image of the cat
     * @param root      the group of elements presented in GUI
     * @param deduction the integer value of point deduction for each cat
     */
    public UpperClassCat(Image image, Group root, int deduction) {
        super(image, root, deduction);
    }

    /**
     * method name: move()
     * This method retrieves a hard path transition and applies it on the cat node.
     */
    public void move() {
        PathTransition pathTransition = PathFactory.getLevel(3).getPath(root);
        pathTransition.setNode(cat);
        pathTransition.play();
    }

    /**
     * method name: getUpperClassCat()
     * This method provides access to the UpperClassCats object by creating a random UpperClassCat and returning it.
     *
     * @param root the group of elements presented in GUI
     * @return randomly generated UpperClassCat
     * @throws FileNotFoundException error when the image file cannot be read
     */
    protected static Cat getHigherClassCat(Group root) throws FileNotFoundException {
        int num = random.nextInt(3);
        if (num == 0) {
            return new UpperClassCat(new Image(new FileInputStream("Resources/Sphinx.png")), root, -10);
        } else if (num == 1) {
            return new UpperClassCat(new Image(new FileInputStream("Resources/MaineCoon.png")), root, -15);
        }
        return new UpperClassCat(new Image(new FileInputStream("Resources/Siamese.png")), root, -20);
    }
}
