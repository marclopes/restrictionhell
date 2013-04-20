package barri;

import java.util.*;
import java.io.*;


class DriverHabitatge{
	public static void main() throws java.io.IOException{
		
		List<String> clases;
		Habitatge hab = new Habitatge(8000,64, "Pisos", 001, 4, 200, clases);
		
		clases.add("Mitja");
		clases.add("Baixa");
		
		System.out.println("Nom: " + hab.ConsultarNom());
		System.out.println("Codi: " + hab.ConsultarCodi());
		System.out.println("Alçada: " + hab.ConsultarH());
		System.out.println("Capacitat: " + hab.ConsultaCapacitat());
		System.out.println("Impostos: " + hab.ConsultarImpost());
		System.out.println("Aparcament: " + hab.ConsultarAparcament());
		System.out.println("Tipus d'edifici: Habitatge");
		
	}
}