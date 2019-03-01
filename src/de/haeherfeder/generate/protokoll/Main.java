package de.haeherfeder.generate.protokoll;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	String filename;
	public static void main(String[] args) {
		try {
			new Main();
		} catch (IOException e) {e.printStackTrace();}
	}
	Main() throws IOException{
		System.out.println("FileName: ");
		Scanner user_input = new Scanner(System.in);
		filename = user_input.nextLine();
		File file = new File(filename+".txt");
		file.createNewFile();
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {e.printStackTrace();}
		System.out.println("Name: ");
		String name = user_input.nextLine();
		System.out.println("Klasse: ");
		String klasse = user_input.nextLine();
		System.out.println("Beisitzer: ");
		String beisitzer = user_input.nextLine();
		writer.write(name+"\t\t\t"+klasse+"\t\t\t"+"Beisitzer: "+beisitzer+"\n\n");
		System.out.println("Thema: ");
		String thema = user_input.nextLine();
		writer.write("Thema: "+thema+"\n");
		System.out.println("Aufgabenstellung: ");
		String aufgabe = user_input.nextLine();
		writer.write("Aufgabenstellung: "+aufgabe+"\n\n");
		System.out.println("Hypothese: ");
		String hypothese = user_input.nextLine();
		writer.write("Hypothese: "+hypothese+"\n\nMaterialen:\n");
		int matanz=-1;
		while(matanz==-1) {
			try {
				System.out.println("Anzahl der Materialen:  ");
				matanz = Integer.parseInt(user_input.nextLine());
			} catch (NumberFormatException e) {e.printStackTrace();matanz=-1;}
		}
		for(int i=0;i<matanz;) {
			i++;
			System.out.println("Material "+i+":");
			String material = user_input.nextLine();
			writer.write("\t"+material+"\n");
		}
		writer.write("\n");
		matanz=-1;
		while(matanz==-1) {
			try {
				System.out.println("Anzahl der Chemikalien:  ");
				matanz = Integer.parseInt(user_input.nextLine());
				if(matanz!=0) {
					writer.write("\nChemikalien: \n");
				}
			} catch (NumberFormatException e) {e.printStackTrace();matanz=-1;}
		}
		for(int i=0;i<matanz;) {
			i++;
			System.out.println("Chemikalie "+i+":");
			String chemikalien = user_input.nextLine();
			writer.write("\t"+chemikalien+"\n");
		}
		writer.write("\n");
		System.out.println("Zeilen für Skizze/Versuchsaufbau: ");
		int freizeilen=-1;
		while(freizeilen==-1) {
			try {
				freizeilen = Integer.parseInt(user_input.nextLine());
			} catch (NumberFormatException e) {e.printStackTrace();freizeilen=-1;}
		}
		writer.write("Skizze/Versuchsaufbau:"+zeilen(freizeilen+2));
		System.out.println("Durchführung: ");
		String durchfuehrung = user_input.nextLine();
		writer.write("Durchführung: "+durchfuehrung+"\n\n"+"Tabelle:\n");
		System.out.println("Tabelle\nZeilen: ");
		int zeilen=-1;
		while(zeilen==-1) {
			try {
				zeilen = Integer.parseInt(user_input.nextLine());
			} catch (NumberFormatException e) {e.printStackTrace();zeilen=-1;}
		}
		System.out.println("Spalten: ");
		int spalten = -1;
		while(spalten==-1) {
			try {
				spalten = Integer.parseInt(user_input.nextLine());
			} catch (NumberFormatException e) {e.printStackTrace();spalten=-1;}
		}
		for(int i=0;i<zeilen;i++) {
			for(int i2=0;i2<spalten;i2++) {
				System.out.println("Feld: "+i+"und"+i2);
				String inp = user_input.nextLine();
				writer.write(inp+"\t");
			}
			writer.write("\n");
		}
		System.out.println("Beobachtung: ");
		String beobachtung = user_input.nextLine();
		writer.write("\nBeobachtung: "+beobachtung+"\n\n");
		System.out.println("Auswertung: ");
		String auswertung = user_input.nextLine();
		writer.write("Auswertung: "+auswertung+"\n\n");
		System.out.println("Fehleranalyse: ");
		String fehleranalyse = user_input.nextLine();
		writer.write("Fehleranalyse: "+fehleranalyse+"\n\n");
		writer.flush();
		writer.close();
		user_input.close();
	}
	private String zeilen(int freizeilen) {
		String ze = "";
		for(int i=0;i<freizeilen;i++) {
			ze = ze + "\n";
		}
		return ze;
	}
}