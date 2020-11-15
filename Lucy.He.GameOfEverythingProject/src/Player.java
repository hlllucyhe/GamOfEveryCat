import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * Class name: Player
 *
 * @author Lucy He
 * This class is responsible for keeping track of the health value and level of the player, and exhibiting the health value through GUI.
 */
public class Player {
    private int health;
    private static Player singleton;
    private Label lblHealth;
    private AnchorPane scoreBoard;
    private int level;
    private Group root;

    /**
     * Private constructor
     *
     * @param root the group of elements presented in GUI
     */
    private Player(Group root) {
        health = 100;
        level = 0;
        this.root = root;
        lblHealth = new Label("Health: " + health);
        lblHealth.setFont(Font.font(20));
        scoreBoard = new AnchorPane(lblHealth);
        scoreBoard.setLayoutX(850);
        scoreBoard.setLayoutY(10);
        scoreBoard.setMaxSize(50, 20);
        root.getChildren().add(scoreBoard);
    }

    /**
     * method name: reset()
     * This method resets the Player's scores when the game restarts
     */
    public void reset() {
        health = 100;
        level = 0;
        root.getChildren().add(scoreBoard);
        lblHealth.setText("Health: " + health);
    }

    /**
     * method name: getInstance()
     *
     * @param root the group of elements presented in GUI
     * @return singleton instance of the player object (only one player is allowed)
     */
    public static Player getInstance(Group root) {
        if (singleton == null) {
            singleton = new Player(root);
        }
        return singleton;
    }

    /**
     * method name: changeHealthBy()
     * this method increases or decreases the health value by the value passed in.
     *
     * @param change integer value representing the increase or decrease in health
     */
    public void changeHealthBy(int change) {
        if ((health + change) < 0) {
            health = 0;
        } else if ((health + change) > 100) {
            health = 100;
        } else {
            health += change;
        }
        lblHealth.setText("Health: " + health);
    }

    //getters and setters
    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel() {
        level++;
    }
}
