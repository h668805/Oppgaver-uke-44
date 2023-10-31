package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = new Blogg();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(mappe, filnavn)));

			int antall = Integer.parseInt(reader.readLine());

			for (int i = 0; i < antall; i++) {
				String line = reader.readLine();
				if (line.startsWith(TEKST)) {
					blogg.leggTilUtvid(new Tekst(Integer.parseInt(reader.readLine()), reader.readLine(),
							reader.readLine(), Integer.parseInt(reader.readLine()), reader.readLine()));
					
				} else if (line.startsWith(BILDE)) {
					blogg.leggTilUtvid(new Bilde(Integer.parseInt(reader.readLine()), reader.readLine(),
							reader.readLine(), Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine()));
				}
				else {
					System.out.println("Det skjedde en feil.");
				}
			}

		} catch (Exception e) {
			System.out.println("Det skjedde en feil.");
		}

		return blogg;
	}
}
