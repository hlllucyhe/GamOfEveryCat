import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Class name: Controller
 *
 * @author Lucy He
 * This class is responsible for controlling the animation timeline of the game.
 * It checks if the game can procede and creates random cat objects based on the level of the player.
 * It also keeps track of the start and end of the game by creating pop-up windows and resetting everything.
 */
public class Controller {
    private static Controller singleton;
    private Group root;
    private Stage stage;
    private Player player;
    private Timeline animation;
    private Random random;

    /**
     * Private constructor
     *
     * @param stage the stage of the GUI
     * @param root  the group of elements presented in GUI
     */
    private Controller(Stage stage, Group root) {
        this.stage = stage;
        this.root = root;
        player = Player.getInstance(root);
        animation = new Timeline();
        random = new Random();
        animation.setCycleCount(Timeline.INDEFINITE);
        KeyFrame frames = new KeyFrame(
                Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //checking if the game can continue
                        if (player.getHealth() == 0) {
                            Controller.getInstance().startDialog(false);
                        }

                        //creating different classes of cats based on the level of the player
                        try {
                            if (player.getLevel() < 5) {
                                Cat.getCat(0, root);
                            } else if (player.getLevel() < 20) {
                                Cat.getCat(random.nextInt(2), root);
                            } else if (player.getLevel() < 40) {
                                Cat.getCat(random.nextInt(3), root);
                            } else if (player.getLevel() < 60) {
                                Cat.getCat(random.nextInt(3), root);
                                Cat.getCat(random.nextInt(3), root);
                            } else {
                                Cat.getCat(random.nextInt(3), root);
                                Cat.getCat(random.nextInt(3), root);
                                Cat.getCat(random.nextInt(3), root);
                                Cat.getCat(random.nextInt(3), root);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        animation.getKeyFrames().add(frames);
    }

    /**
     * method name: setSingleton()
     * this function allows the single instance of the Controller to be constructed.
     *
     * @param stage the stage of the GUI
     * @param root  the group of elements presented in GUI
     */
    public static void setSingleton(Stage stage, Group root) {
        if (singleton == null) {
            singleton = new Controller(stage, root);
        }
    }

    /**
     * method name: getInstance()
     *
     * @return singleton instance of the class
     */
    public static Controller getInstance() {
        return singleton;
    }

    /**
     * method name: startDialog()
     * this method is responsible for creating a pop-up window at the start and end of the game and managing the timeline.
     *
     * @param start boolean to show if the game is starting or restarting
     */
    public void startDialog(boolean start) {
        animation.stop();                               //reset animation to the beginning at the start of the game

        //pop-up window
        final Stage dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(22);
        Text txtInstructions;
        Button btnStart;
        if (start) {
            //instructions at the start of the game
            dialog.setTitle("Instructions");
            txtInstructions = new Text(10, 40, "You are the mouse.\nSome cats are trying to catch you.\nBeing caught by the cats will decrease your health.\nEating some cheese can help you to recover.\nClick on the button below to start the game.\nGood luck!");
            btnStart = new Button("Start");
        } else {
            //instructions to restart the game
            dialog.setTitle("Game Over");
            txtInstructions = new Text(10, 40, "Uh Oh!\nYou have lost the game!\nClick on the button below to play again.\nGood luck!");
            btnStart = new Button("Restart");
        }
        //start/restart button
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                //reset everything
                root.getChildren().clear();
                player.reset();
                animation.play();
            }
        });
        dialogVbox.getChildren().addAll(txtInstructions, btnStart);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
