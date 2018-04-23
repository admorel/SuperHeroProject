package fr.univ_smb.isc.m2.domain.superH;

import java.util.List;
import java.util.ArrayList;


public class SuperHero {


    private String nom;
    private String identiteSecrete;
    private String pouvoir;
    private String nemesis;


    private List<String> commentaires;


    public SuperHero(){}

    /**
     * Constructeur du Super Hero
     *
     * @param nom : Le nom du Hero, ex:Batman, Superman...
     * @param identiteSecrete : La vraie identité du personnage, ex: Bruce Wayne, Clark Kent...
     * @param pouvoir : super pouvoir ou capacité du héros
     * @param nemesis : son ennemis jurés, ex: le joker, lex luthor...
     */
    public SuperHero(String nom, String identiteSecrete, String pouvoir, String nemesis)
    {
        this.nom = nom;
        this.identiteSecrete = identiteSecrete;
        this.pouvoir = pouvoir;
        this.nemesis = nemesis;
        this.commentaires = new ArrayList<String>();
    }

    /**
     * Getter du nom du héro
     *
     * @return un string, son attibut nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du nom
     *
     * @param nouveau nom du héro
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de l'identité secrète
     *
     * @return attribut identiteSecrete
     */
    public String getIdentiteSecrete() {
        return identiteSecrete;
    }


    public void setIdentiteSecrete(String identiteSecrete) {
        this.identiteSecrete = identiteSecrete;
    }



    public String getPouvoir() {
        return pouvoir;
    }


    public void setPouvoir(String pouvoir) {
        this.pouvoir = pouvoir;
    }


    public String getNemesis() {
        return nemesis;
    }


    public void setNemesis(String nemesis) {
        this.nemesis = nemesis;
    }

    /**
     * Ajoute un commentaire à la liste des commentaires du héro
     *
     * @param comment : String, le commentaire à ajouter
     */
    public void addCommentaires(String comment)
    {
        commentaires.add(comment);
    }


    /**
     * Récupère le commentaire à l'indice i
     *
     * @param indexCommentaireARecuperer
     * @return le commentaire
     */
    public String getACommentaire(int indexCommentaireARecuperer)
    {
        return commentaires.get(indexCommentaireARecuperer);
    }


    /**
     * Modifie le commentaire à l'indice entré en paramètre
     *
     * @param indexCommentaireAModifier: int entre 0 et taille de la liste de commentaire -1
     * @param newCommentaire: String, nouveau commentaire
     */
    public void setCommentaire(int indexCommentaireAModifier, String newCommentaire)
    {
        commentaires.set(indexCommentaireAModifier, newCommentaire);
    }


    /**
     * Donne la taille de la liste des commentaires
     *
     * @return la longueur de la liste des commentaires
     */
    public int commentairesLength()
    {
        return commentaires.size();
    }


    /**
     * Retire le commentaire à l'indice indexCommentaireASupprimer
     *
     * @param indexCommentaireASupprimer: int entre 0 et taille de la liste de commentaire -1
     */
    public void removeCommentaire(int indexCommentaireASupprimer)
    {
        commentaires.remove(indexCommentaireASupprimer);
    }


    /**
     * Getter de la liste des commentaires
     *
     * @return les commentaires
     */
    public List<String> getCommentaires() {
        return commentaires;
    }


    /**
     * Vérifie si la liste des commentaires est vide
     *
     * @return vrai si la liste est vide, faux sinon
     */
    public boolean commentairesIsEmpty()
    {
        return commentaires.isEmpty();
    }

}
