package revolusibumi;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RevolusiBumi extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image earth = new Image(this.getClass().getResourceAsStream("bumi.png"));
        Image sun = new Image(this.getClass().getResourceAsStream("matahari.png"));
        Image space = new Image(this.getClass().getResourceAsStream("galaksi.png"));

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
                
                // background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);

            }
            //
        }.start();

        Scene scene = new Scene(root);
        primaryStage.setTitle("FOSALGO - Revolusi Bumi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
