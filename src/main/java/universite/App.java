package universite;


import java.lang.ref.PhantomReference;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class App {


    public static void main(String[] args){
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1); e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1); e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1); e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);
        afficheSi("** TOUS LES ETUDIANTS", e -> true, a1);

    }

    public static final Predicate<Etudiant> aDEF = etudiant -> {
         boolean rtr = true;
        for (Matiere m : etudiant.notes().keySet()){
            if(etudiant.notes().containsKey(m)){
                 rtr = true;
            }
        }
        return rtr;
    };



    public static void afficheSi(String entete, Predicate<Etudiant> pred, Annee annee){
        System.out.println(entete);
        annee.etudiants().forEach(etudiant -> {
            if (pred.test(etudiant))
                System.out.println(etudiant);
        }  );
    }

}
