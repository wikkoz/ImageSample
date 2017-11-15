package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageController {

    private final DragContext dragContext = new DragContext();
    private Rectangle rect = new Rectangle();

    @FXML
    private Group group;

    @FXML
    private ImageView image;

    public ImageController() {
        rect = new Rectangle(0, 0, 0, 0);
        rect.setStroke(javafx.scene.paint.Color.BLUE);
        rect.setStrokeWidth(1);
        rect.setStrokeLineCap(StrokeLineCap.ROUND);
        rect.setFill(javafx.scene.paint.Color.LIGHTBLUE.deriveColor(0, 1.2, 1, 0.6));
    }

    @FXML
    public void initialize() {
        Image cat = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Gatto_europeo4.jpg/1024px-Gatto_europeo4.jpg");
        image.setImage(cat);
    }


    @FXML
    public void mousePressed(MouseEvent event) {
        if (event.isSecondaryButtonDown())
            return;

        rect.setX(0);
        rect.setY(0);
        rect.setWidth(0);
        rect.setHeight(0);

        group.getChildren().remove(rect);

        dragContext.mouseAnchorX = event.getX();
        dragContext.mouseAnchorY = event.getY();

        rect.setX(dragContext.mouseAnchorX);
        rect.setY(dragContext.mouseAnchorY);
        rect.setWidth(0);
        rect.setHeight(0);

        group.getChildren().add(rect);
    }

    @FXML
    public void mouseDragged(MouseEvent event) {
        if (event.isSecondaryButtonDown())
            return;

        double offsetX = event.getX() - dragContext.mouseAnchorX;
        double offsetY = event.getY() - dragContext.mouseAnchorY;

        if (offsetX > 0)
            rect.setWidth(offsetX);
        else {
            rect.setX(event.getX());
            rect.setWidth(dragContext.mouseAnchorX - rect.getX());
        }

        if (offsetY > 0) {
            rect.setHeight(offsetY);
        } else {
            rect.setY(event.getY());
            rect.setHeight(dragContext.mouseAnchorY - rect.getY());
        }
    }

    @FXML
    public void mouseReleased(MouseEvent event) {
        if (event.isSecondaryButtonDown())
            return;
    }

    @FXML
    public void cropEvent(ActionEvent event) {
        Bounds bounds = getBounds();
        System.out.println("Selected area: " + bounds);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");

        File file = fileChooser.showSaveDialog(group.getScene().getWindow());
        if (file == null)
            return;

        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();

        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        parameters.setViewport(new Rectangle2D(bounds.getMinX(), bounds.getMinY(), width, height));

        WritableImage wi = new WritableImage(width, height);
        image.snapshot(parameters, wi);
        image.setImage(wi);

        BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
        BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);

        Graphics2D graphics = bufImageRGB.createGraphics();
        graphics.drawImage(bufImageARGB, 0, 0, null);

        try {
            ImageIO.write(bufImageRGB, "jpg", file);
            System.out.println("Image saved to " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics.dispose();
    }

    private Bounds getBounds() {
        return rect.getBoundsInParent();
    }

    private static final class DragContext {

        double mouseAnchorX;
        double mouseAnchorY;

    }
}
