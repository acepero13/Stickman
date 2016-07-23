package de.dfki.stickmanfx;

import de.dfki.stickman.view.*;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Robbie
 */
public class StickmanStageController {

//    ObservableList<String> options = 
//    FXCollections.observableArrayList(
//        "Option 1",
//        "Option 2",
//        "Option 3"
//    );
    
    public static StickmanFX sStickman;
    
    @FXML
    private Label BodyColour;
    @FXML
    private Label Environment;
    @FXML
    private Label EmotionExpression;
    @FXML
    private Label IdleSection;
    @FXML
    private Label Posture;

    @FXML
    private RadioButton CoverMouth;
    @FXML
    private RadioButton TouchHead;
    @FXML
    private RadioButton WaveLeft;
    @FXML
    private RadioButton WaveRight;

    @FXML
    private ComboBox<String> HeadComboBoxColor;
    @FXML
    private ComboBox<String> HairComboBoxColor;
    @FXML
    private ComboBox<String> FaceComboBoxColor;
    @FXML
    private ComboBox<String> BodyComboBoxColor;
    @FXML
    private ComboBox<String> LegComboBoxColor;
    @FXML
    private GridPane gridPaneControlColor;
    @FXML
    private GridPane gridPaneControlEmotion;
    @FXML
    private GridPane gridPaneControlIdleSection;
    @FXML
    private GridPane gridPaneControlEnvironment;
    @FXML
    private GridPane gridPaneControlPosture;
    @FXML
    private FlowPane StickmanFlowPane;

    @FXML
    public void initialize() 
    {
        sStickman = TEST.sMale;
        setIdForLabel();
        HeadComboBoxColor.setValue("Beige");
        HeadComboBoxColor.getItems().addAll("Blue", "Black");

        HairComboBoxColor.setValue("Yellow");
        HairComboBoxColor.getItems().addAll("Beige","Blue","Black","Red","Blond");

        FaceComboBoxColor.setValue("Beige");
        FaceComboBoxColor.getItems().addAll("Blue","Black","Red");

        BodyComboBoxColor.setValue("Beige");
        BodyComboBoxColor.getItems().addAll("Black","Yellow","White");

        LegComboBoxColor.setValue("Black");
        LegComboBoxColor.getItems().addAll("Black","Yellow","White");
        
        gridPaneControlColor.setVisible(true);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
        
        //change bodyColor
        BodyComboBoxColor.setOnAction((event) -> 
        {
            String color = BodyComboBoxColor.getSelectionModel().getSelectedItem();
            
            Platform.runLater(() -> 
            {
                sStickman.mBodyFX.mMaleColor = switchColor(color);
                sStickman.mBodyFX.update();
            });
            
        });

    }
    
    private Color switchColor(String color)
    {
        Color c = null;
        switch(color)
        {
            case "Beige": 
                c = Color.BEIGE;
                break;
            case "Yellow":
                c = Color.YELLOW;
                break;
            case "White":
                c = Color.WHITE;
                break;
            case "Black":
                c = Color.BLACK;
                break;
        }
        return c;
    }
    
    @FXML
    private void handleBodyColour()
    {
        gridPaneControlColor.setVisible(true);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleEmotionExpression()
    {
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(true);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleIdleSection()
    {
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(true);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handleEnvironment()
    {
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(true);
        gridPaneControlPosture.setVisible(false);
    }
    
    @FXML
    private void handlePosture()
    {
        gridPaneControlColor.setVisible(false);
        gridPaneControlEmotion.setVisible(false);
        gridPaneControlIdleSection.setVisible(false);
        gridPaneControlEnvironment.setVisible(false);
        gridPaneControlPosture.setVisible(true);
    }

    private void setIdForLabel() 
    {
        BodyColour.setId("Menu");
        Environment.setId("Menu");
        EmotionExpression.setId("Menu");
        IdleSection.setId("Menu");
        Posture.setId("Menu");

    }
}
