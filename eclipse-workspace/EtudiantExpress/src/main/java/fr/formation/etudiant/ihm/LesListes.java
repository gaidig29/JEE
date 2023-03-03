package fr.formation.etudiant.ihm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import fr.formation.etudiant.bo.Etudiant;

public class LesListes {

	public static void main(String[] args) {
		Etudiant j1 =new Etudiant("Prendbien","Jacques",20.0);
		Etudiant j2 = new Etudiant("Prendmal","Jacques",5.0);
		Etudiant j3 = new Etudiant("Pas","Jessy",7.0);
		Etudiant j4 = new Etudiant("Pasplus","Jessy",3.0);
		Etudiant j5 = new Etudiant("Tout","Jessy",15.0);
		
		List<Etudiant> lst = Arrays.asList(j1,j2,j3,j4,j5);
		
		lst.forEach(System.out::println);
		
//		Collections.sort(lst,(e1,e2)->e2.getNote().compareTo(e1.getNote()));
		lst.sort((e1,e2)->e2.getNote().compareTo(e1.getNote()));
		
		System.out.println();
		lst.forEach(System.out::println);
		

	}

}
