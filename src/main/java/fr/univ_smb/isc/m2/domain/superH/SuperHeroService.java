package fr.univ_smb.isc.m2.domain.superH;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Service
public class SuperHeroService {

    private final ArrayList<SuperHero> heros;

    /**
     * Constructeur de la classe SuperHeroService
     */
    public SuperHeroService() {
        heros = new ArrayList<SuperHero>();
        heros.add(new SuperHero("Batman", "Bruce Wayne", "Aucun", "le Joker"));
        heros.add(new SuperHero("Wolverine", "James Howlett", "Regénération", "Dent de sabre"));
        heros.add(new SuperHero("Iron man", "Tony Stark", "Aucun", "le Mandarin"));
        heros.add(new SuperHero("Magneto", "Erik Lensherr", "Magnétisme", "Professeur X"));
    }

    /**
     * Renvoie la liste complête des super heros
     *
     * @return la liste heros
     */
    public List<SuperHero> all() {
        return heros;
    }


    /**
     * selection un héro dans la liste des héros
     *
     * @param superHeroNom -> on sélectionne le héro en fonction de son nom
     * @return le super héro correspondant au nom
     */
    public SuperHero selectById(String superHeroNom) {
        List<SuperHero> collect = heros.stream()
                .filter(u -> u.getNom().equals(superHeroNom))
                .collect(toList());

        if (collect.isEmpty()) {
            return null;
        } else {
            return collect.get(0);
        }
    }


    /**
     * Créer un nouveau héro
     *
     * @param nom, ex:Batman
     * @param identiteSecrete, ex: Bruce Wayne
     * @param pouvoir, ex: Etre riche
     * @param nemesis, ex: le Joker
     * @return le héro
     */
    public SuperHero create(String nom, String identiteSecrete, String pouvoir, String nemesis){
        SuperHero superHero = new SuperHero(nom, identiteSecrete, pouvoir, nemesis);
        heros.add(superHero);
        return superHero;
    }


    /**
     * Ajoute un commentaire au héro
     *
     * @param superH, le nom du héro à qui on veut ajouter un commentaire
     * @param commentaire, le commentaire à ajouter
     */
    public void addCommentaire(String superH, String commentaire)
    {
        int i = 0;

        //on verifie que le héro est bien présent
        for(i = 0; i < heros.size(); i++)
        {
            if(superH.equals(heros.get(i).getNom()))
            {
                break;
            }
        }

        if(i < heros.size())
        {
           heros.get(i).addCommentaires(commentaire);
        }

    }


    /**
     * Retire le super héro de la liste de héro
     *
     * @param nomSH, nom du héro à retirer
     */
    public void removeSH(String nomSH){
        int i = 0;
        for(i = 0; i < heros.size(); i++)
        {
            if(nomSH.equals(heros.get(i).getNom()))
            {
                break;
            }
        }

        if(i < heros.size())
        {
            heros.remove(i);
        }

    }


    /**
     * Retire un commentaire au héro
     *
     * @param nomSH, nom du héro dont on veut enlever un commentaire
     * @param indexCommentaireASupprimer
     */
    public void removeComment(String nomSH, int indexCommentaireASupprimer){
        int i = 0;

        //on verifie que le héro est bien présent
        for(i = 0; i < heros.size(); i++)
        {
            if(nomSH.equals(heros.get(i).getNom()))
            {
                break;
            }
        }


        if(i < heros.size())
        {
           if(indexCommentaireASupprimer < heros.get(i).commentairesLength() && !heros.get(i).commentairesIsEmpty())
           {
               heros.get(i).removeCommentaire(indexCommentaireASupprimer);
           }
        }

    }
}
