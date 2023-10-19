package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledige;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledige = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledige = 0;
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		if (innlegg == null)
			return -1;
		
		for (int i = 0; i < nesteledige; i++) {
			if (innleggtabell[i].erLik(innlegg))
				return i;
		}
		
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (innlegg == null)
			return false;
		
		for (int i = 0; i < nesteledige; i++) {
			if (innleggtabell[i].erLik(innlegg))
				return true;
		}
		
		return false;
	}

	public boolean ledigPlass() {
		return nesteledige < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(finnes(innlegg) || !ledigPlass())
			return false;
		
		innleggtabell[nesteledige++] = innlegg;
		return true;
	}
	
	public String toString() {
		String str = nesteledige + "\n";
		
		for (int i = 0; i < nesteledige; i++) {
			str += innleggtabell[i].toString();
		}
		
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nyTab = new Innlegg[innleggtabell.length * 2];
		
		for (int i = 0; i < innleggtabell.length; i++) {
			nyTab[i] = innleggtabell[i];
		}
		
		innleggtabell = nyTab;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (innleggtabell.length <= nesteledige && !finnes(innlegg) && innlegg != null) {
			utvid();
		}
		
		return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		int i = finnInnlegg(innlegg);
		
		if (i == -1)
			return false;
		
		for (; i < nesteledige-1; i++) {
			innleggtabell[i] = innleggtabell[i+1];
		}
		
		innleggtabell[--nesteledige] = null;
		return true;
	}
	
	public int[] search(String keyword) {
		int[] temp = new int[1000];
		int antall = 0;
		
		for (Innlegg innlegg : innleggtabell) {
			if (innlegg.toString().contains(keyword)) {
				temp[antall++] = innlegg.getId();
			}
		}
		
		int [] ider = new int[antall];
		
		for (int i = 0; i < antall; i++) {
			ider[i] = temp[i];
		}
		
		return ider;
	}
}