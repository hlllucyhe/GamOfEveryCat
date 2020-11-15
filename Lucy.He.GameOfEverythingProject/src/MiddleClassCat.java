import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class name: MiddleClassCat
 *
 * @author Lucy He
 * This class extends the Cat class, and creates MiddleClassCats with deduction values between 5-8.
 * It is responsible for creating each specific cats with unique images and deduction points, as well as moving the Cat object along a path transition.
 */
public class MiddleClassCat extends Cat {
    /**
     * Constructor
     *
     * @param image     the image of the cat
     * @param root      the group of elements presented in GUI
     * @param deduction the integer value of point deduction for each cat
     */
    public MiddleClassCat(Image image, Group root, int deduction) {
        super(image, root, deduction);
    }

    /**
     * method name: move()
     * This method retrieves a medium path transition and applies it on the cat node.
     */
    public void move() {
        PathTransition pathTransition = PathFactory.getLevel(2).getPath(root);
        pathTransition.setNode(cat);
        pathTransition.play();
    }

    /**
     * method name: getMiddleClassCat()
     * This method provides access to the MiddleClassCats object by creating a random MiddleClassCat and returning it.
     *
     * @param root the group of elements presented in GUI
     * @return randomly generated MiddleClassCat
     * @throws FileNotFoundException error when the image file cannot be read
     */
    protected static Cat getMiddleClassCat(Group root) throws FileNotFoundException {
        int num = random.nextInt(4);
        if (num == 0) {
            return new MiddleClassCat(new Image(new FileInputStream("Resources/AmericanShorthair.png")), root, -5);
        } else if (num == 1) {
            return new MiddleClassCat(new Image(new FileInputStream("Resources/Munchkin.png")), root, -6);
        } else if (num == 2) {
            return new MiddleClassCat(new Image(new FileInputStream("Resources/ScottishFold.png")), root, -7);
        }
        return new MiddleClassCat(new Image(new FileInputStream("Resources/Ragdoll.png")), root, -8);
    }
}
