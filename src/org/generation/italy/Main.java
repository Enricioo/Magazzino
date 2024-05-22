package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import org.generation.italy.model.Movimenti;

public class Main {

	public class Fornitori {
		public String codFornitore = new String();
		public String nomeFornitore = new String();
	}

	public class Clienti {
		public String codCliente = new String();
		public String nomeCliente = new String();
	}

	public class Prodotti {
		public String codProdotto = new String();
		public String descrProdotto = new String();
	}

	public class TipologieMovimento {
		public String codMovimento = new String();
		public String descrMovimento = new String();
	}

	public static void main(String[] args) {

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Movimenti mov;
		int codInserito;
		String risposta;
		boolean giacValida;
		String codiceProdottoGiacenza;
		ArrayList<Movimenti> elencoMovimenti = new ArrayList<Movimenti>();
		ArrayList<Movimenti> elencoEntrate = new ArrayList<Movimenti>();
		ArrayList<Movimenti> elencoUscite = new ArrayList<Movimenti>();
		HashMap<String, String> elencoFornitori = new HashMap<String, String>() {
			{
				put("F01", "Fornitore 1");
				put("F02", "Fornitore 2");
				put("F03", "Fornitore 3");
				put("F04", "Fornitore 4");
			}
		};
		HashMap<String, String> elencoClienti = new HashMap<String, String>() {
			{
				put("C01", "Cliente 1");
				put("C02", "Cliente 2");
				put("C03", "Cliente 3");
				put("C04", "Cliente 4");
			}
		};
		HashMap<String, String> elencoProdotti = new HashMap<String, String>() {
			{
				put("P01", "Prodotto 1");
				put("P02", "Prodotto 2");
				put("P03", "Prodotto 3");
				put("P04", "Prodotto 4");
			}
		};
		HashMap<String, String> elencoTipologie = new HashMap<String, String>() {
			{
				put("E01", "acquisto da fornitore");
				put("E02", "reso da cliente");
				put("E03", "produzione interna");
				put("E04", "spostamento da altro magazzino");
				put("U01", "vendita a cliente");
				put("U02", "reso a fornitore");
				put("U03", "sostituzione in garanzia");
				put("U04", "spostamento a altro magazzino");
			}
		};
		do {
			mov = new Movimenti();
			System.out.println("Che tipo di operazione vuoi effettuare?");
			System.out.println(
					"\u001B[33m1. Inserire movimenti in entrata \n\u001B[31m2. Inserire movimenti in uscita \n\u001B[32m3. Visualizzazione movimenti in entrata \n\u001B[35m4. Visualizzazione movimenti in uscita \n\u001B[36m5. Giacenza prodotto\u001B[37m");

			codInserito = sc.nextInt();
			sc.nextLine();

			if (codInserito == 0 || codInserito > 5) {
				do {
					System.out.println("Il codice inserito è errato, riprova!");
					System.out.println(
							"\u001B[33m1. Inserire movimenti in entrata \n\u001B[31m2. Inserire movimenti in uscita \n\u001B[32m3. Visualizzazione movimenti in entrata \n\u001B[35m4. Visualizzazione movimenti in uscita \n\u001B[36m5. Giacenza prodotto\u001B[37m");
					codInserito = sc.nextInt();
					sc.nextLine();
				} while (codInserito <= 0 || codInserito > 5);
			}

			if (codInserito == 1) {
				System.out.println("\u001B[33mInserimento movimento in entrata...");
				System.out.println("Inserisci la data: ");
				mov.data = LocalDate.parse(sc.nextLine(), df);
				System.out.println("Inserisci codice prodotto: ");
				mov.codProdotto = sc.nextLine();
				System.out.println("Inserisci quantità prodotto: ");
				mov.qtaProdotto = sc.nextInt();
				sc.nextLine();
				System.out.println("Inserisci codice movimento: ");
				mov.codMovimento = sc.nextLine();
				System.out.println("\u001B[36m(Opzionale)\u001B[33mInserisci riferimento: ");
				mov.riferimento = sc.nextLine();
				System.out.println("\u001B[37m");
				elencoEntrate.add(mov);
				elencoMovimenti.add(mov);
			} else if (codInserito == 2) {
				System.out.println("\u001B[31mInserimento movimento in uscita...");
				System.out.println("Inserisci la data: ");
				mov.data = LocalDate.parse(sc.nextLine(), df);
				System.out.println("Inserisci codice prodotto: ");
				mov.codProdotto = sc.nextLine();
				System.out.println("Inserisci quantità prodotto: ");
				mov.qtaProdotto = sc.nextInt();
				sc.nextLine();
				System.out.println("Inserisci codice movimento: ");
				mov.codMovimento = sc.nextLine();
				System.out.println("\u001B[36m(Opzionale)\u001B[31mInserisci riferimento: ");
				mov.riferimento = sc.nextLine();
				System.out.print("\u001B[37m");
				elencoUscite.add(mov);
				elencoMovimenti.add(mov);
			} else if (codInserito == 3) {
				System.out.println("Elenco dei movimenti in entrata: ");
				for (int i = 0; i < elencoEntrate.size(); i++) {
					System.out.println("Movimento in entrata n." + (i + 1) + ":");
					for (String prodotto : elencoProdotti.keySet()) {
						if (prodotto.equals(elencoEntrate.get(i).codProdotto)) {
							System.out.println("Il prodotto in entrata: " + elencoProdotti.get(prodotto));
						}
					}
					System.out
							.println("È stato importato in magazzino in data: " + elencoEntrate.get(i).data.format(df));
					System.out
							.println("È stato importato nella seguente quantità: " + elencoEntrate.get(i).qtaProdotto);
					for (String tipologia : elencoTipologie.keySet()) {
						if (tipologia.equals(elencoTipologie.get(tipologia)))
							;
						System.out.println("L'operazione effettuata è: " + elencoEntrate.get(i).codMovimento);
						break;
					}

				}

			} else if (codInserito == 4) {
				System.out.println("Elenco dei movimenti in entrata: ");
				for (int i = 0; i < elencoUscite.size(); i++) {
					System.out.println("Movimento in entrata n." + (i + 1) + ":");
					for (String prodotto : elencoProdotti.keySet()) {
						if (prodotto.equals(elencoUscite.get(i).codProdotto)) {
							System.out.println("Il prodotto in entrata: " + elencoProdotti.get(prodotto));
						}
					}
					System.out
							.println("È stato importato in magazzino in data: " + elencoUscite.get(i).data.format(df));
					System.out.println("È stato importato nella seguente quantità: " + elencoUscite.get(i).qtaProdotto);
					for (String tipologia : elencoTipologie.keySet()) {
						if (tipologia.equals(elencoUscite.get(i).codMovimento))
							;
						System.out.println("L'operazione effettuata è: " + elencoTipologie.get(tipologia));
						break;
					}
				}
			} else if (codInserito == 5) {
				do {
					giacValida = false;
					System.out.println("Di quale prodotto vuoi vedere la giacenza?");
					codiceProdottoGiacenza = sc.nextLine();
					if (elencoProdotti.containsKey(codiceProdottoGiacenza)) {
						int giacenza = 0;
						for (Movimenti movimenti : elencoEntrate) {
							if (movimenti.codProdotto.equals(codiceProdottoGiacenza)) {
								giacenza += movimenti.qtaProdotto;
							}
						}
						for (Movimenti movimenti : elencoUscite) {
							if (movimenti.codProdotto.equals(codiceProdottoGiacenza)) {
								giacenza -= movimenti.qtaProdotto;
								giacValida = true;
							}
						}
						System.out.println("Giacenza del prodotto " + elencoProdotti.get(codiceProdottoGiacenza)
								+ " è: " + giacenza);
						giacValida = true;
					} else {
						System.out.println("Codice errato, riprova.");
					}
				} while (!giacValida);
			}
			// Messaggio di fine operazioni e riavvio
			System.out.println("Vuoi effettuare un'altra operazione?");
			risposta = sc.nextLine();
		} while (risposta.equalsIgnoreCase("s"));

	}

}
