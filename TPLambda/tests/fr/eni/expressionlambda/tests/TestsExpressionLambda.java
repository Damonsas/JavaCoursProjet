package TPLambda.tests.fr.eni.expressionlambda.tests;

import java.util.ArrayList;
import java.util.List;

import TPLambda.fr.eni.expressionelambda.modele.Chanson;


public class TestsExpressionLambda {

	public static void main(String[] args) {
		List<Chanson> chansons = new ArrayList<Chanson>(List.of( new Chanson("Space Oddity", "David Bowie", 5.17),
				 new Chanson("Paint It, Black", "The Rolling Stones", 3.22),
				 new Chanson("Smoke On The Water", "Deep Purple", 5.40),
				 new Chanson("Cocaine", "Eric Clapton", 3.36),
				 new Chanson("Englishman In New York", "Sting", 4.26),
				 new Chanson("Mojo", "M", 3.16),
				 new Chanson("Battez-vous", "Brigitte", 4.04),
				 new Chanson("Frida", "Sanseverino", 4.08),
				 new Chanson("Demons", "Imagine Dragons", 2.57),
				 new Chanson("Supersonic", "Oasis", 4.44),
				 new Chanson("Boulevard of Broken Dreams", "Green Day", 4.21),
				 new Chanson("Come Out and Play", "The Offspring", 3.17),
				 new Chanson("Under the Bridge", "Red Hot Chili Peppers", 4.25),
				 new Chanson("Come As You Are", "Nirvana", 3.38),
				 new Chanson("Nothing Else Matters", "Metallica", 6.28),
				 new Chanson("Sympathy For The Devil", "Motorhead", 5.26),
				 new Chanson("You Really Got Me", "Van Halen", 2.36),
				 new Chanson("Knockin' On Heaven's Door", "Guns N' Roses", 5.36)));
		
		//Enoncés


		System.out.println("Afficher la liste des chansons (titre + duree)");
        chansons.forEach(c->System.out.println(c.getTitre()+" ("+c.getDuree()+")"));

		System.out.println("Trier la liste des chansons par ordre alphabétique");
        chansons.sort((Chanson c1, Chanson c2) -> c1.getTitre().compareTo(c2.getTitre()));

		System.out.println("Afficher la liste des chansons (toString)");
        chansons.forEach(chanson -> chanson.toString());
        chansons.forEach(System.out::println);
		
		System.out.println("Supprimer les chansons trops longues (>5 minutes)");
        chansons.removeIf(chanson -> chanson.getDuree() > 5);


		System.out.println("Trier la liste des chansons par durée croissante");


	}
	

}
