package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}

	private static String HTMLPREFIX = "<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

	private static String HTMLPOSTFIX = "\t</body>\n</html>";

	private static String[] array;

	@Override
	public String toString() {
		String str = HTMLPREFIX;

		for (int i = 0; i < super.getAntall(); i++) {
			array = getSamling()[i].toString().split("\n");

			str += html();
			
			str += "<hr>\n";
		}

		return str + HTMLPOSTFIX;
	}

	private String html() {
		String str = "\t\t<h2>" + array[2] + "@" + array[3] + " [" + array[4] + "]<h2>\n";
		
		str += "\t\t<p>" + array[5] + "<p>\n\t\t";
		
		if (array[0].contains("BILDE")) {
		str += "<iframe src=\"" + array[6] + "\" height=600 width=800></iframe>";
		}
		
		return str;
	}
}
