package GUI;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;



public class WorldBoard extends Pane {

    static public final Color[] STATE_COLORS = {Color.BLUE, Color.RED, Color.GREEN};
    private final int CELL_SIZE;
    private final int nLinesPane;
    private final int nColsPane;
    public int i = 10 ;

    Rectangle[] array = new Rectangle[10];

    private Rectangle rectangle;

    public WorldBoard(WorldWithOneCell world, int size) {
        this.CELL_SIZE = size;
        this.nLinesPane = world.nLines() * CELL_SIZE;
        this.nColsPane = world.nCols() * CELL_SIZE;
        this.setPrefSize(this.nLinesPane, this.nColsPane);


    }

    public void populateWorld(CellPosition position) {

        array = new Rectangle[i];
        for ( i = 0; i <10; i++) {
            array [i]= this.addRectangle(position);

            this.rectangle = this.addRectangle(position);



        }
    }




//    public void updatePosition(int dx, int dy) {
//        this.rectangle.setX(this.rectangle.getX() + dx * CELL_SIZE); // move rectangle graphic
//        this.rectangle.setY(this.rectangle.getY() + dy * CELL_SIZE); // move rectangle graphic
//    }

    public void updatePosition(int dx, int dy) {

        for ( i = 0; i < 11; i++) {

            int k =(int) Math.random()*40;
            TranslateTransition tt = new TranslateTransition(Duration.millis(100*(i+1)), array[i]);

            tt.setByX(dx * CELL_SIZE*(i+1));
            tt.setByY(dy * CELL_SIZE*(i+1));

            tt.play();

        }
    }

    private Rectangle addRectangle(CellPosition position) {




        int line = position.getLine() * CELL_SIZE;
        int col = position.getCol() * CELL_SIZE;


        Rectangle r = new Rectangle(col, line, CELL_SIZE, CELL_SIZE);
        r.setFill(Color.BLUE);


        Platform.runLater(() -> {

            this.getChildren().add(r);


        });

        return r;
    }
}