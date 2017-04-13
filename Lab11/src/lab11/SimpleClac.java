/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author exchange
 */
public class SimpleClac extends Application implements EventHandler {
    private TextField tf;
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        
        pane.setTop(createTextField());
        pane.setBottom(createHBox());
        pane.setCenter(createGridPane());
        
        Scene scene = new Scene(pane);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    public void toLaunch(){
        this.launch();
    }
    private TextField createTextField(){    
        tf = new TextField();
        tf.setEditable(false);
        return tf;
    }    
    private GridPane createGridPane(){
        GridPane gp = new GridPane();
        int counter = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                CircleButton newButt = new CircleButton(counter + "");
                counter++;
                
               
                newButt.setOnMousePressed(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        newButt.setColor(Color.BLUE);
                    }
                });
                
                newButt.setOnMouseReleased(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        newButt.setColor(Color.WHITE);
                        tf.appendText(newButt.getValue());
                    }
                });
                
                gp.add(newButt, j, i);
            }
    }
    return gp;
}
    public HBox createHBox(){
        
        Button sqrdButt = new Button("x^2");
        Button sqrtButt = new Button("Sqrt");
        Button clearButt = new Button("Clear");
    
        sqrtButt.setOnAction(this);
        sqrdButt.setOnAction(this);
        clearButt.setOnAction(this);
        HBox hbox = new HBox(sqrdButt , sqrtButt , clearButt);
        return hbox;
    }

    @Override
    public void handle(Event calc){ 
        Button butt = (Button) calc.getSource();
        if(butt.getText().equals("Clear")){
            tf.clear();
         
        }
        else if(butt.getText().equals("x^2")){
            Math.pow(Double.parseDouble(tf.getText()), 2);
            tf.setText(Math.pow(Double.parseDouble(tf.getText()), 2) + "");
            
        }
        else if(butt.getText().equals("Sqrt")){
            Math.sqrt(Double.parseDouble(tf.getText()));
            tf.setText(Math.sqrt(Double.parseDouble(tf.getText()))+ "");
        }
    }
    
}    