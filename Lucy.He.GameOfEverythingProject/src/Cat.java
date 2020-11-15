import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Class name: Cat
 *
 * @author Lucy He
 * This is an abstract class of a cat object.
 * Each cat has a different image and a different value of deduction points, and is categorized into three classes:Upper, Middle, and Lower.
 * Each category of cats implements a different way of moving, thus the abstract method move() is used for polymorphism.
 * The cat object is responsible for adding and removing itself from the Group, moving with path transitions,
 * decreasing the player's health, and creating a Cheese object when points are deducted.
 * This class is also responsible for creating a random cat object given its category and passing it out.
 */
public abstract class Cat {
    protected ImageView cat;
    protected static Random random = new Random();
    protected static Group root;
    private Player player;

    /**
     * Constructor
     *
     * @param image     the image of the cat
     * @param root      the group of elements presented in GUI
     * @param deduction the integer value of point deduction for each cat
     */
    protected Cat(Image image, Group root, int deduction) {
        player = Player.getInstance(root);
        cat = new ImageView(image);
        this.root = root;
        cat.setX(-100);
        cat.setY(-100);

        //when a cat captures the mouse
        cat.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.changeHealthBy(deduction);
                root.getChildren().remove(cat);

                //creating a cheese object when health is deducted
                try {
                    new Cheese(root);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        move();
        root.getChildren().add(cat);
    }

    /**
     * method name: getCat()
     * This method provides access to the Cat object by creating a random cat in a chosen category and passing them.
     *
     * @param classNum the integer representation of the category of a cat: 0=Lower, 1=Middle, 2=Upper
     * @param root     the group of elements presented in GUI
     * @return the created Cat object
     * @throws FileNotFoundException error when the image file cannot be read
     */
    public static Cat getCat(int classNum, Group root) throws FileNotFoundException {
        if (classNum == 0) {
            return LowerClassCat.getLowerClassCat(root);
        } else if (classNum == 1) {
            return MiddleClassCat.getMiddleClassCat(root);
        }
        return UpperClassCat.getHigherClassCat(root);
    }

    /**
     * abstract method: move()
     * This method uses polymorphism for the different movements of each category of cats.
     */
    abstract public void move();
}
