import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Class name: Cheese
 *
 * @author Lucy He
 * This class is the cheese object in the game.
 * It is responsible for adding and removing itself from the group and increasing the health and level of the player.
 */
public class Cheese {
    /**
     * Constructor
     *
     * @param root the group of elements presented in GUI
     * @throws FileNotFoundException error when the image file cannot be read
     */
    public Cheese(Group root) throws FileNotFoundException {
        Player player = Player.getInstance(root);
        Random random = new Random();
        Image image = new Image(new FileInputStream("Resources/Cheese.png"));
        ImageView cheese = new ImageView(image);
        cheese.setX(900 * random.nextDouble());
        cheese.setY(650 * random.nextDouble());

        //the cheese is eaten by the mouse when it is clicked
        cheese.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.changeHealthBy(5);
                player.increaseLevel();
                root.getChildren().remove(cheese);
            }
        });
        root.getChildren().add(cheese);
    }
}
