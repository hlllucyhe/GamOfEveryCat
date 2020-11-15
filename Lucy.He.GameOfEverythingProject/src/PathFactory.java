import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Random;

/**
 * Class name: PathFactory
 *
 * @author Lucy He
 * This is the parent class for all path factories.
 * It is responsible for creating random path transitions moving in all four directions.
 */
public class PathFactory {
    private static PathFactory hardPathFactory;
    private static PathFactory mediumPathFactory;
    private static PathFactory easyPathFactory;
    protected Path path1 = new Path();
    protected Path path2 = new Path();
    protected Path path3 = new Path();
    protected Path path4 = new Path();
    protected MoveTo hMove1;
    protected MoveTo hMove2;
    protected MoveTo vMove3;
    protected MoveTo vMove4;
    protected Random random = new Random();

    /**
     * method name: init()
     * This method will be overriden by the child classes.
     * It is responsible for initializing a random starting and ending points of the transition and adding them to the path.
     * The content below is kept in the parent class because it can be used repeatedly to construct a random starting point.
     */
    protected void init() {
        //horizontal paths
        hMove1 = new MoveTo(-100, 700 * random.nextDouble());
        hMove2 = new MoveTo(1100, 700 * random.nextDouble());
        //vertical paths
        vMove3 = new MoveTo(1000 * random.nextDouble(), -100);
        vMove4 = new MoveTo(1000 * random.nextDouble(), 800);
    }

    /**
     * method name: update()
     * This method will be overriden by the child classes.
     * It is responsible for updating the random starting and ending points of the transition.
     * The content below is kept in the parent class because it can be used repeatedly to construct a random starting point.
     */
    protected void update() {
        hMove1.setY(700 * random.nextDouble());
        hMove2.setY(700 * random.nextDouble());
        vMove3.setX(1000 * random.nextDouble());
        vMove4.setX(1000 * random.nextDouble());
    }

    /**
     * method name: getLevel()
     * this method creates singleton objects for each levels of path factories and returns them based on a given integer type
     *
     * @param type integer value representing the level of path transition: 1=easy, 2=medium, 3=hard
     * @return PathFactory that corresponds with the input level
     */
    public static PathFactory getLevel(int type) {
        if (easyPathFactory == null) {
            easyPathFactory = new EasyPathFactory();
        }
        if (mediumPathFactory == null) {
            mediumPathFactory = new MediumPathFactory();
        }
        if (hardPathFactory == null) {
            hardPathFactory = new HardPathFactory();
        }
        if (type == 1) {
            return easyPathFactory;
        }
        if (type == 2) {
            return mediumPathFactory;
        }
        return hardPathFactory;
    }

    /**
     * method name: getPath()
     * This method returns a path transition in a random direction out of the four paths randomly generated previously.
     * it is also responsible for removing the cat when the transition is finished, and increasing the level of the player.
     *
     * @param root the group of elements presented in GUI
     * @return randomly generated PathTransition
     */
    public PathTransition getPath(Group root) {
        update();
        int type = random.nextInt(4);
        PathTransition pathTransition = new PathTransition();
        if (type == 0) {
            pathTransition.setPath(path1);
        } else if (type == 1) {
            pathTransition.setPath(path2);
        } else if (type == 2) {
            pathTransition.setPath(path3);
        } else if (type == 3) {
            pathTransition.setPath(path4);
        }
        pathTransition.setDuration(Duration.millis(5000));
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().remove(pathTransition.getNode());
                Player.getInstance(root).increaseLevel();
            }
        });
        return pathTransition;
    }
}
