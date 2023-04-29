package com.example.imagemanager.components;
import com.drew.imaging.ImageProcessingException;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// Panel class defines the user panel interface of our JavaFX App
public class Panel {
    private final List<String> formatList = Arrays.asList("JPG", "JPEG", "PNG", "BMP", "TIF", "TIFF");
    private final List<String> sizeList = Arrays.asList("Original Size", "100px * 100px", "320px * 180px", "360px * 360px", "820px * 312px");
    private final List<String> filterList = Arrays.asList("No filter", "Black & White", "Tint", "Invert Colors", "Mosaic");
    private final HBox panel;
    private final Button deleteBtn;
    private final Button downloadBtn;

    public Panel(Image image) throws ImageProcessingException, IOException {
        // Create panel for each image file
        this.panel = new HBox();
        this.panel.setPrefSize(800, 150);
        this.panel.setPadding(new Insets(10, 10, 10, 10));
        this.panel.setSpacing(10);
        this.panel.setId(String.valueOf(image.getId()));

        // Create thumbnail
        ImageView thumbNail = new ImageView();
        thumbNail.setFitHeight(100);
        thumbNail.setFitWidth(100);
        thumbNail.setImage(image.getFXImage());

        // Create Image Properties
        var imageProperties = new VBox();
        imageProperties.setPrefSize(230, 150);
        imageProperties.setSpacing(3);
        imageProperties.getChildren().add(new Label("Name: " + image.getName()));
        if (image.getModel() != null) {
            imageProperties.getChildren().add(new Label("Camera: " + image.getModel()));
        }
        if (image.getLatitude() != null && image.getLongitude() != null) {
            imageProperties.getChildren().add(new Label("Location: LAT " + image.getLatitude() + ", LONG " + image.getLongitude()));
        }

        imageProperties.getChildren().add(new Label("Type: " + image.getInputFormat()));
        imageProperties.getChildren().add(new Label("Size: " + image.getImageSize()));
        imageProperties.getChildren().add(new Label("Height: " + image.getInputHeight()));
        imageProperties.getChildren().add(new Label("Width: " + image.getInputWidth()));

        // Choice box for formats
        ChoiceBox<String> formatChoiceBox = new ChoiceBox<>();
        formatChoiceBox.setPrefWidth(105);
        for (String format : formatList) {
            formatChoiceBox.getItems().add(format);
        }
        formatChoiceBox.setValue(formatList.get(0));
        String btnStyle = "-fx-background-color: #f1f3f4;" +
                "-fx-border-color: #dadce0;" +
                "-fx-text-fill: #1a73e8;" +
                "-fx-border-radius: 4px;";
        formatChoiceBox.setStyle(btnStyle);

        // Set output format
        image.setOutputFormat(formatList.get(0));
        formatChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
                        image.setOutputFormat(formatList.get(new_val.intValue()))
        );

        // Choice box for output sizes
        ChoiceBox<String> sizeChoiceBox = new ChoiceBox<>();
        sizeChoiceBox.setPrefWidth(135);
        sizeChoiceBox.setStyle(btnStyle);

        for (String size : sizeList) {
            sizeChoiceBox.getItems().add(size);
        }
        sizeChoiceBox.setValue(sizeList.get(0));

        // Set output size
        image.setOutputSizeOriginal();
        sizeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
                    image.setOutputSize(sizeList.get(new_val.intValue()))
        );

        // Choice box for filters
        ChoiceBox<String> filterChoiceBox = new ChoiceBox<>();
        filterChoiceBox.setPrefWidth(135);
        for (String filter : filterList) {
            filterChoiceBox.getItems().add(filter);
        }
        filterChoiceBox.setValue(filterList.get(0));
        filterChoiceBox.setStyle(btnStyle);

        // Set the filter to be applied to the image
        image.setSelectedFilter(filterList.get(0));
        filterChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) ->
                        image.setSelectedFilter(filterList.get(new_val.intValue()))
        );

        // Delete button for each image
        deleteBtn = new Button("Delete");
        deleteBtn.setPrefWidth(110);
        deleteBtn.setStyle(btnStyle);

        // Download button for each image
        downloadBtn = new Button("Download");
        downloadBtn.setPrefWidth(110);
        downloadBtn.setStyle(btnStyle);

        // Append all child nodes to parent node
        this.panel.getChildren().add(thumbNail);
        this.panel.getChildren().add(imageProperties);
        this.panel.getChildren().add(formatChoiceBox);
        this.panel.getChildren().add(sizeChoiceBox);
        this.panel.getChildren().add(filterChoiceBox);
        this.panel.getChildren().add(deleteBtn);
        this.panel.getChildren().add(downloadBtn);
    }

    public HBox getPanel() {
        return panel;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getDownloadBtn() {
        return downloadBtn;
    }

}
