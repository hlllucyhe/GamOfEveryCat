import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class name: Main()
 *
 * @author Lucy He
 * This is the main function of the project used to run the program.
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("The Game of EveryCat");
        stage.setScene(scene);
        stage.show();

        Controller.setSingleton(stage, root);
        Controller controller = Controller.getInstance();
        controller.startDialog(true);
    }

}
