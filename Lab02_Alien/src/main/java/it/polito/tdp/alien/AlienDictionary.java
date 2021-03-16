package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dizionario;

	public AlienDictionary() {
		super();
		this.dizionario = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		int flag =0;
		int i;
		Word vv = new Word(alienWord, translation);
		for(i=0; i<this.dizionario.size(); i++) {
			if(vv.equals(dizionario.get(i))) {
				flag=1;
				break;
			}
				
		}
		
		if(flag==1) {
			this.dizionario.get(i).setTranslation(translation);
		}else {
			this.dizionario.add(vv);
		}
	}
	
	
	public String translateWord(String alienWord) {
		for(int i=0; i<dizionario.size();i++) {
			if(dizionario.get(i).getAlienWord().equals(alienWord)) {
				return dizionario.get(i).getTranslation();
			}
		}
		
		return null;
	}
	
	public void resetDizionario() {
		this.dizionario.clear();
	}
	
	public String dizionarioCompleto() {
		String elenco="";
		for(int i=0; i<dizionario.size();i++) {
			elenco =elenco + dizionario.get(i).toString()+"\n";
		}
		return elenco;
	}
}
