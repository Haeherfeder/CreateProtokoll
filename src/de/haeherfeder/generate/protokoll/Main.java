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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Name: ");
		String name = user_input.nextLine();
		System.out.println("Klasse: ");
		String klasse = user_input.nextLine();
		System.out.println("Thema: ");
		String thema = user_input.nextLine();
		writer.write(name+"\t\t\t"+klasse+"\t\t\t"+"Thema: "+thema+"\n\n");
		System.out.println("Aufgabenstellung: ");
		String aufgabe = user_input.nextLine();
		writer.write("Aufgabenstellung: "+aufgabe+"\n\n");
		System.out.println("Hypothese: ");
		String hypothese = user_input.nextLine();
		writer.write("Hypothese: "+hypothese+"\n\n");
		System.out.println("Anzahl der Materialen:  ");
		writer.write("Materialen :\n");
		int matanz = Integer.parseInt(user_input.nextLine());
		for(int i=0;i<matanz;) {
			i++;
			System.out.println("Material "+i+":");
			String material = user_input.nextLine();
			writer.write("\t"+material+"\n");
		}
		writer.write("\n");
		System.out.println("Zeilen für Skizze/Versuchsaufbau: ");
		int freizeilen = Integer.parseInt(user_input.next());
		writer.write("Skizze/Versuchsaufbau:"+zeilen(freizeilen+1)+"Tabelle:\n");
		System.out.println("Tabelle\nZeilen: ");
		int zeilen = Integer.parseInt(user_input.nextLine());
		System.out.println("Spalten: ");
		int spalten = Integer.parseInt(user_input.nextLine());
		for(int i=0;i<zeilen;i++) {
			for(int i2=0;i2<spalten;i2++) {
				System.out.println("Feld: "+i+"und"+i2);
				String inp = user_input.nextLine();
				writer.write(inp+"\t");
			}
			writer.write("\n");
		}
		writer.write("\n");
		System.out.println("Beobachtung: ");
		String beobachtung = user_input.nextLine();
		writer.write("Beobachtung: "+beobachtung+"\n\n");
		System.out.println("Auswertung: ");
		String auswertung = user_input.nextLine();
		writer.write("Auswertung: "+auswertung+"\n\n");
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