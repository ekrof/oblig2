package no.hib.dat102.mengde.kjedet;

import no.hib.dat102.mengde.adt.*;
import no.hib.dat102.mengde.tabell.TabellMengde;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//


	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}


	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			leggTil(teller.next());
		}
	}


	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++){
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		}// if
		return resultat;
	}//


	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell = null;

		T resultat = null;

		if(!erTom()) {
			if(start.getElement().equals(element)) { //dersom første element er det vi leter etter
				funnet = true;
				resultat = start.getElement();
				start = start.getNeste(); //setter starten til neste node
				antall--;
			} else {
				forgjenger = start;
				aktuell = forgjenger.getNeste();

				do {
					if(aktuell.getElement().equals(element)) {
						forgjenger.setNeste(aktuell.getNeste());
						resultat = aktuell.getElement();
						antall--;
						funnet = true;
					} else {
						forgjenger = forgjenger.getNeste();
						aktuell = aktuell.getNeste();
					}
				} while(!aktuell.getNeste().equals(null) && !funnet);
			} //else
		} //if

		return resultat;
	}//

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {// OBS! En bedre i kladdeopg4
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}// while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			begge.leggTil(teller.next());
		}
		return begge;
	}//


	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			if(m2.inneholder(aktuell.getElement())) {
				begge.leggTil(aktuell.getElement());
			}
			aktuell = aktuell.getNeste();
		}// while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			T element = teller.next();
			
			if(this.inneholder(element)) {
				begge.leggTil(element);
			}
		}
		return begge;
	}
	
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			if(!m2.inneholder(aktuell.getElement())) {
				begge.leggTil(aktuell.getElement());
			}
			aktuell = aktuell.getNeste();
		}// while
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()){
			T element = teller.next();
			
			if(!this.inneholder(element)) {
				begge.leggTil(element);
			}
		}
		return begge;
	}


	private void settInn(T element){
		LinearNode<T>nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode; 
		antall++;
	}


	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int sok = 0; sok < antall && !funnet; sok++) {
			if (aktuell.getElement().equals(element)){
				funnet = true;
			}
			else{
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}


	@Override
	public boolean erLik(MengdeADT<T> m2) {
		boolean likeMengder = true;
		T element = null;

		if(m2.antall() == this.antall) {
			Iterator<T> teller = m2.oppramser();
			while(teller.hasNext() && likeMengder) {
				element = teller.next();

				if(!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}

		return likeMengder;
	}


	@Override
	public boolean erTom() {
		return antall == 0;
	}


	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

}// class
