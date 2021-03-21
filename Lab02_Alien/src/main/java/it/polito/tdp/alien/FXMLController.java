package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary dictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtRisultato.clear();
    	this.dictionary.resetDizionario();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parola = txtParola.getText();

    	if(parola.contains(" ")) {
        	String[] testo = parola.split(" ");
        	if(testo[0].matches("[a-zA-Z]*") && testo[1].matches("[a-zA-Z]*")) {
        		testo[0]=testo[0].toLowerCase();
        		testo[1]=testo[1].toLowerCase();
        		dictionary.addWord(testo[0], testo[1]);
        		txtRisultato.setText("Parola aggiunta al dizionario correttamente");
        		txtParola.setText("");
        	}else {
        		txtRisultato.setText("ERRORE: inserire solo lettere");
        	}
        }else {
        	if(parola.matches("[a-zA-Z]*")) {
        		parola = parola.toLowerCase();
        		String traduzione = dictionary.translateWord(parola);
            	txtRisultato.setText("La traduzione è: "+traduzione);
            	txtParola.setText("");
        	}else {
        		txtRisultato.setText("ERRORE: inserire solo lettere");
        	}
        	
        }
    	
    	
    }
    
    @FXML
    void doElenco(ActionEvent event) {
    	this.txtRisultato.setText(this.dictionary.dizionarioCompleto());
    }
    
    
    @FXML
    void doTranslate2(ActionEvent event) {

    	String parola = txtParola.getText();

    	if(parola.contains(" ")) {
        	String[] testo = parola.split(" ");
        	if(testo[0].matches("[a-zA-Z]*") && testo[1].matches("[a-zA-Z]*")) {
        		testo[0]=testo[0].toLowerCase();
        		testo[1]=testo[1].toLowerCase();
        		dictionary.addWord2(testo[0], testo[1]);
        		txtRisultato.setText("Parola aggiunta al dizionario correttamente");
        		txtParola.setText("");
        	}else {
        		txtRisultato.setText("ERRORE: inserire solo lettere");
        	}
        }else {
        	if(parola.matches("[a-zA-Z]*")) {
        		parola = parola.toLowerCase();
        		String traduzione="Le traduzioni sono: \n";
        		ArrayList<String> trad = dictionary.translateWord2(parola);
        		for(int i=0; i<trad.size();i++) {
        			traduzione =traduzione + trad.get(i)+"\n";
        		}
            	txtRisultato.setText(traduzione);
            	txtParola.setText("");
        	}else {
        		txtRisultato.setText("ERRORE: inserire solo lettere");
        	}
        	
        }
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
