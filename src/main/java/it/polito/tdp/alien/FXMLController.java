/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.*;

import it.polito.tdp.alien.model.dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	
	dizionario diz; 
	

    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML // fx:id="btnClear"
    private Button btnClear; 

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; 

    @FXML // fx:id="txtArea"
    private TextArea txtArea; 

    @FXML // fx:id="txtInserisci"
    private TextField txtInserisci; 

    @FXML
    void doClear(ActionEvent event) {
    	txtInserisci.clear();
    	txtArea.clear();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String txt= txtInserisci.getText();
    	String token[]= txt.split(" ");
    	
    	String parola= token[0].toLowerCase();
    	
        	
    	if(parola.matches("^.*[0-9].*$")==true) {
    		txtArea.setText("Formato della parola non valido");
		    return;
    	}
    	
    	
    	 if(token.length==1) { //translate
    		List <String> listaTT = new LinkedList<String>(); 

     		listaTT= diz.trovaTraduzione(parola);
     		txtArea.setText("la traduzione di " +parola+" e' : "+listaTT);
    		 
     	}
    	 
    	 String traduzione= token[1].toLowerCase();
    	 
     	if(traduzione.matches("^.*[0-9].*$")==true) {
     		txtArea.setText("Formato della parola non valido");
 		    return;
    	 }
    	 
    	
    	if(token.length==2) { //add
    		diz.aggiungiParola(parola, traduzione);
     		txtArea.setText(""+parola +" e' stata aggiunta correttamente con relativa traduzione: "+traduzione);
 
    	}
          
    	
      
    
       	
}	
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";

         diz = new dizionario() ;
    }

}
