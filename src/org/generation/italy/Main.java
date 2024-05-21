package org.generation.italy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

		Scanner sc = new Scanner(System.in);
		int codInserito;
		ArrayList<Movimenti> elencoMovimenti = new ArrayList<Movimenti>();
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

		System.out.println("Che tipo di operazione vuoi effettuare?");

		codInserito = sc.nextInt();
		sc.nextLine();
		if (codInserito == 1) {

		} else if (codInserito == 2) {

		} else if (codInserito == 3) {

		} else if (codInserito == 4) {
			
		} else if (codInserito == 5) {
			
		} else if (codInserito == 6) {
			
		} 
		
	}

}
