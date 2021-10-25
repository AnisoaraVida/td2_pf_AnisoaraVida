package exo2;

import java.util.function.Predicate;

public class App {

    public static void main(String[] args){
        Predicate<Integer> tropPetite = taille -> taille < 100;
        Predicate<Integer> tropGrande = taille -> taille > 200;
        Predicate<Integer> tailleIncorrecte = tropGrande.or(tropPetite);
        Predicate<Integer> taillecorrecte = tailleIncorrecte.negate();
        Predicate<Double> tropLourd = poids -> poids > 150.0;
        Predicate<Double> poidCorrect = tropLourd.negate();
        Predicate< Paire<Integer, Double> > accesautorise = (taille) -> (taillecorrecte.test(taille.fst) && poidCorrect.test(taille.snd));

        System.out.println("Test : Taille trop petite 80 : " + tropPetite.test(80));
        System.out.println("Test : Taille trop petite  120 : " + tropPetite.test(120));
        System.out.println("Test : Taille trop grande 220 : " + tropGrande.test(220));
        System.out.println("Test : Taille trop grande 180 : " + tropGrande.test(180));
        System.out.println("Test : Taille incorrecte  220 : " + tailleIncorrecte.test(220));
        System.out.println("Test : Taille incorrecte  110 : " + tailleIncorrecte.test(110));
        System.out.println("Test : Taille correcte 120 : " + taillecorrecte.test(120));
        System.out.println("Test : Taille correcte 220 : " + taillecorrecte.test(220));
        System.out.println("Test : Poids trop lourd 140.0 : " + tropLourd.test(140.0));
        System.out.println("Test : Poids trop lourd 160.0 : " + tropLourd.test(160.0));
        System.out.println("Test : Poids correct 140.0 : " + poidCorrect.test(140.0));
        System.out.println("Test : Poids correct 160.0 : "+ poidCorrect.test(160.0));
        //System.out.println("Test : Acces autorisé taille 80, poids 120.0 : " + accesautorise.test() );

    }
}
