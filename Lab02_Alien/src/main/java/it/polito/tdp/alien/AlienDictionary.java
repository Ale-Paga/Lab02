package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dizionario;
	private List<WordEnhanced> dizionario2;

	public AlienDictionary() {
		super();
		this.dizionario = new ArrayList<>();
		this.dizionario2 = new ArrayList<>();
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
	
	
	public void addWord2(String alienWord, String translation) {

		WordEnhanced vv = new WordEnhanced(alienWord, translation);
		
		this.dizionario2.add(vv);
		
	}
	
	
	
	public String translateWord(String alienWord) {
		for(int i=0; i<dizionario.size();i++) {
			if(dizionario.get(i).getAlienWord().equals(alienWord)) {
				return dizionario.get(i).getTranslation();
			}
		}
		
		return null;
	}
	
	public ArrayList<String> translateWord2(String alienWord) {
			
			ArrayList<String> ris= new ArrayList<>();;
			for(int i=0; i<dizionario2.size();i++) {
				if(dizionario2.get(i).getAlienWord().equals(alienWord)) {
					ris.add(dizionario2.get(i).getTranslation());
				}
			}
			
			return ris;
		}
	
	public void resetDizionario() {
		this.dizionario.clear();
		this.dizionario2.clear();
	}
	
	public String dizionarioCompleto() {
		String elenco="";
		for(int i=0; i<dizionario.size();i++) {
			elenco =elenco + dizionario.get(i).toString()+"\n";
		}
		return elenco;
	}
}
