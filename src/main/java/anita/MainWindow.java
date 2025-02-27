package anita;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Anita anita = new Anita();

    private Image userImage = new Image(this.getClass().getResourceAsStream("/DaUser.png"));
    private Image anitaImage = new Image(this.getClass().getResourceAsStream("/DaDuke.png"));

    /**
     * Creates a dialogue box showing Anita's prompt message.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        String greet = anita.getGreeting();
        dialogContainer.getChildren().addAll(
                DialogBox.getAnitaDialog(greet, anitaImage)
        );
    }

    /**
     * Sets Anita to the parameter d.
     *
     * @param a The Anita instance.
     */
    public void setAnita(Anita a) {
        anita = a;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Anita's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = anita.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getAnitaDialog(response, anitaImage)
        );
        if (input.equals("bye")) {
            javafx.application.Platform.exit();
        }
        userInput.clear();
    }
}

