package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//on donne une collection d’étudiants (nom, prenom, moyenne). En utilisant
//les streams et les lambda, écrire fonctions qui :
//- renvoie la liste des étudiants, triés par moyenne ;
//- retourne tous les étudiants qui ont la moyenne ;
//- retourne le nom de tous les étudiants qui ont la moyenne, sous forme
//d’un ensemble java
//- retourne le nom de tous les étudiants qui ont la moyenne, sous forme
//d’une liste, séparée par des virgules (regardez la classe Collectors)
//- calcule la moyenne générale.
//
//- récupérer une map promo vers étudiant.
//- construire une map avec trois clefs : recalé, passable, bien, très bien
//- retourner le nom de la personne qui a eu la meilleure moyenne

public class TestStreams {

	public static void main(String[] args) {

		List<Etudiant> etudiants = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			etudiants.add(new Etudiant("etu" + i, "prenom" + i, i * 2));
			etudiants.add(new Etudiant("etuX" + i, "prenomX" + i, i * 1.5));
		}
		etudiants.forEach(System.out::println);
//		
//		System.out.println("Apres tri : ");
//		//- renvoie la liste des étudiants, triés par moyenne ;
//		List<Etudiant> luMoy = etudiants.stream()
//				.sorted(Comparator.comparing(Etudiant::getMoyenne))
//				.collect(Collectors.toList());
//		luMoy.forEach(System.out::println);
//		
		
		//- retourne tous les étudiants qui ont la moyenne ;
//		System.out.println("moyenne > 10 : ");
//		List<Etudiant> luMoyOk = etudiants.stream()
//				.filter(a -> a.getMoyenne() >= 10)
//				.collect(Collectors.toList())
//				;
//		luMoyOk.forEach(System.out::println);
//		//- retourne le nom de tous les étudiants qui ont la moyenne, sous forme
//		//d’un ensemble java
//		System.out.println("retourne le nom de tous les étudiants qui ont la moyenne, sous forme\r\n d’un ensemble java");
//		List<Etudiant> luMoyOk3 = etudiants.stream()
//				.filter(a -> a.getMoyenne() >= 10)
//				.collect(Collectors.toList());
//		luMoyOk3.forEach(System.out::println);
//		//- retourne le nom de tous les étudiants qui ont la moyenne, sous forme d’une liste, séparée par des virgules (regardez la classe Collectors)
//		System.out.println("retourne le nom de tous les étudiants qui ont la moyenne, sous forme\r\n d’un ensemble java");
//		List<String> luMoyOk4 = etudiants.stream()
//				.filter(a -> a.getMoyenne() >= 10) 
//				.map(Etudiant::getNom) //applique une fonction à chaque elt
//				// ou map((p)->getNom())
//				.collect(Collectors.toList()));
//		luMoyOk4.forEach(System.out::println);

//		System.out.println("retourne le nom de tous les étudiants qui ont la moyenne, sous forme d’une liste, séparée par des virgules (regardez la classe Collectors)");
//		String etuMoy = etudiants.stream()
//				.filter(a -> a.getMoyenne() >= 10) 
//				.map(Etudiant::getNom)
//				.collect(Collectors.joining(","));
//		System.out.println(etuMoy);
		//- calcule la moyenne générale.
//		Double etuMoyGen =  etudiants.stream().collect(Collectors.averagingDouble(Etudiant::getMoyenne));
//		//ou
//		Double etuMoyGen2 =  etudiants.stream()
//				.mapToDouble(Etudiant::getMoyenne)
//				.average()
//				.getAsDouble();
//		System.out.println("moyenn 1:"+etuMoyGen+"\n\r compare:"+ etuMoyGen2);
//		
		//- - retourner le nom de la personne qui a eu la meilleure moyenne
		System.out.println("- retourner le nom de la personne qui a eu la meilleure moyenne");
		String maxMoyEtu = etudiants.stream()
				.max(Comparator.comparing(Etudiant::getMoyenne)) 
				.get() //pour récupérer les optional types, lesquels acceptent les valeurs null
				.getNom();
		//ou
		String maxMoyEtu1 = etudiants.stream()
				.max(Comparator.comparing(Etudiant::getMoyenne)) 
				.map(Etudiant::getNom)
				.get();
		
		System.out.println(maxMoyEtu1);
		//construire une map avec trois clefs : recalé, passable, bien, très bien
//		System.out.println("- construire une map avec trois clefs : recalé, passable, bien, très bien");
//		etudiants.stream()
//		.forEach((e)-> (e.getMoyenne() < 10 )? "recalé" : (e.getMoyenne()<12)? "passable": (e.getMoyenne()< 14)? "bien" : "très bien" ) ;
//		
		 //Une map avec plusieurs clefs : Recalé, Passable, Bien, Très bien
         //(règle de calcul à définir dans une méthode getMention de la classe Etudiant)
        
		Map<String, List<Etudiant>> myMap =
                         etudiants.stream()
                         .collect(Collectors.groupingBy(Etudiant::getMention));
         
         myMap.forEach((cle,valeur)->{
                 System.out.print(cle + "=");
                 valeur.forEach(e->System.out.print(e.getNom()+","));
                 System.out.println();
         });
         
         //Solution 1 ; parcours des clés puis récupération de chaque valeur
//         for (String cle : myMap.keySet()) {
//                 System.out.print(cle +" = ");
//                 for (Etudiant et : myMap.get(cle)) {
//                         System.out.print(et.getNom()+ ",");
//                 }
//                 System.out.println();
//         }
//         //Solution 2 : parcours avec Entry<K,V>
//         for(Map.Entry<String, List<Etudiant>> entry : myMap.entrySet()) {
//                 System.out.print(entry.getKey() + " = ");
//                 for (Etudiant et : entry.getValue()) {
//                         System.out.print(et.getNom()+ ",");
//                 }
//                 System.out.println();
//         }

	
	}
}