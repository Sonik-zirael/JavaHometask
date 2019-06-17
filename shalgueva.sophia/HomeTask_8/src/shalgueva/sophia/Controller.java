package shalgueva.sophia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    private Button btn;

    @FXML
    private Button clear;

    @FXML
    private ChoiceBox<String> combo;

    @FXML
    private TextArea text;

    @FXML
    private TextField input;

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    private static void append(String filePath, String text) {
        File file = new File(filePath);
        try (FileWriter fr = new FileWriter(file, true)) {
            fr.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(
                "Show Files",
                "New File",
                "Delete File",
                "Write in File");
        combo.setItems(list);
        input.setPromptText("Enter File name");

        clear.setOnAction(event -> {
            text.clear();
            input.clear();
        });

        btn.setOnAction(event -> {
            if (combo.getValue().equals("Show Files")) {
                if (!input.getText().equals("")) {
                    File file = new File(input.getText());
                    if (file.isDirectory()) {
                        for (File item : file.listFiles()) {
                            if (item.isDirectory()) {
                                text.setStyle("-fx-text-fill: #00FF00");
                                text.appendText(item.getName() + "  \t folder \n");
                            } else {
                                text.appendText(item.getName() + "\t file \n");
                            }
                        }
                    }
                } else {
                    text.setText("Don't forget to enter name");
                }
            }
            if (combo.getValue().equals("New File")) {
                if (!input.getText().equals("")) {
                    File file = new File(input.getText());
                    try {
                        if (!file.exists()) {
                            if (file.createNewFile()) {
                                text.setText("File created!");
                            }
                        } else {
                            text.setText("File has already exists");
                        }
                    } catch (IOException ioEx) {
                        ioEx.printStackTrace();
                    }
                } else {
                    text.setText("Don't forget to enter name");
                }
            }
            if (combo.getValue().equals("Delete File")) {
                if (!input.getText().equals("")) {
                    File file = new File(input.getText());

                    if (file.exists()) {
                        if (file.delete()) {
                            text.setText("File deleted!");
                        }
                    } else {
                        text.setText("File doesn't exist");
                    }

                } else {
                    text.setText("Enter name");
                }
            }
            if (combo.getValue().equals("Write in File")) {
                if (!input.getText().equals("")) {
                    File file = new File(input.getText().split("\\|")[0]);
                    if (getFileExtension(file).equals("txt")) {
                        if (file.exists()) {
                            append(file.getPath(), input.getText().split("\\|")[1]);
                        } else {
                            try {
                                file.createNewFile();
                                append(file.getPath(), input.getText().split("\\|")[1]);
                            } catch (IOException io) {
                                io.printStackTrace();
                            }
                        }
                    }
                } else {
                    text.setText("Don't forget to enter name");
                }
            }
        });

    }
}
