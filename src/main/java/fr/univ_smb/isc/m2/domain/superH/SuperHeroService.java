package fr.univ_smb.isc.m2.domain.superH;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Service
public class SuperHeroService {

    private final ArrayList<SuperHero> heros;

    public SuperHeroService() {
        heros = new ArrayList<SuperHero>();
        heros.add(new SuperHero("Batman", "Bruce Wayne", "Aucun", "le Joker"));
        heros.add(new SuperHero("Wolverine", "James Howlett", "Regénération", "Dent de sabre"));
        heros.add(new SuperHero("Iron man", "Tony Stark", "Aucun", "le Mandarin"));
        heros.add(new SuperHero("Magneto", "Erik Lensherr", "Magnétisme", "Professeur X"));
    }

    public List<SuperHero> all() {
        return heros;
    }

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


    public SuperHero create(String nom, String identiteSecrete, String pouvoir, String nemesis){
        SuperHero superHero = new SuperHero(nom, identiteSecrete, pouvoir, nemesis);
        heros.add(superHero);
        return superHero;
    }


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
