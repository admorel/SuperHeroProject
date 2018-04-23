package fr.univ_smb.isc.m2.unitTest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import fr.univ_smb.isc.m2.domain.superH.*;
import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;


public class SuperHeroServiceUnitTest {

    @Test
    public void shouldNeverFail() {
        // Do nothing -> can't fail !
    }

    /*
    * Test du service de création
    */

    @Test
    public void should_add_superHero_to_the_end_of_superHero_list()
    {
        SuperHeroService shService = new SuperHeroService();
        SuperHero shTest = new SuperHero("M. Lachaud", "JOL", "le C++", "Aucun");

       assertThat(shService.all().get(shService.all().size()-1).equals(shTest)).isEqualTo(false);
       assertThat(shService.all().get(shService.all().size()-1).getNom().equals(shTest.getNom())).isEqualTo(false);
       assertThat(shService.all().get(shService.all().size()-1).getIdentiteSecrete().equals(shTest.getIdentiteSecrete())).isEqualTo(false);
       assertThat(shService.all().get(shService.all().size()-1).getPouvoir().equals(shTest.getPouvoir())).isEqualTo(false);
       assertThat(shService.all().get(shService.all().size()-1).getNemesis().equals(shTest.getNemesis())).isEqualTo(false);

       shService.create("M. Lachaud", "JOL", "le C++", "Aucun");

       assertThat(shService.all().get(shService.all().size()-1).getNom().equals(shTest.getNom())).isEqualTo(true);
       assertThat(shService.all().get(shService.all().size()-1).getIdentiteSecrete().equals(shTest.getIdentiteSecrete())).isEqualTo(true);
       assertThat(shService.all().get(shService.all().size()-1).getPouvoir().equals(shTest.getPouvoir())).isEqualTo(true);
       assertThat(shService.all().get(shService.all().size()-1).getNemesis().equals(shTest.getNemesis())).isEqualTo(true);
    }


    /*
    * Test du service des commentaires
    */
    @Test
    public void should_return_the_good_comment()
    {
        SuperHeroService shService = new SuperHeroService();

        SuperHero shTest = shService.create("Thanos", "Thanos", "Bourrin", "A peu près tout l'univers");
        String newCommentaire = "Lisez Thanos Quest c'est bien";

        shService.addCommentaire(shTest.getNom(), newCommentaire);

        assertThat(shTest.getACommentaire(0).equals(newCommentaire)).isEqualTo(true);
    }


    @Test
    public void should_add_a_comment_to_a_hero()
    {
        SuperHeroService shService = new SuperHeroService();

        SuperHero shTest = shService.create("Thanos", "Thanos", "Bourrin", "A peu près tout l'univers");
        String newCommentaire = "Lisez Thanos Quest c'est bien";

        shService.addCommentaire(shTest.getNom(), newCommentaire);


        assertThat(shTest.commentairesLength() == 1).isEqualTo(true);

        assertThat(shTest.getACommentaire(0).equals(newCommentaire)).isEqualTo(true);

    }

    @Test
    public void should_do_nothing_if_add_a_comment_to_an_non_existant_hero()
    {
        SuperHeroService shService = new SuperHeroService();
        String newCommentaire = "Lisez Thanos Quest c'est bien";

        shService.addCommentaire("Francis", newCommentaire);

        //On s'assure que le commentaire ne s'est pas mis chez un autre super hero
        assertThat(shService.all().get(0).getCommentaires().size()).isEqualTo(0);
        assertThat(shService.all().get(1).getCommentaires().size()).isEqualTo(0);
        assertThat(shService.all().get(2).getCommentaires().size()).isEqualTo(0);
        assertThat(shService.all().get(3).getCommentaires().size()).isEqualTo(0);
    }


    @Test
    public void should_remove_the_first_comment_to_the_batman_list()
    {
        SuperHeroService shService = new SuperHeroService();
        String newCommentaire = "Lisez la cour des hiboux";

        shService.addCommentaire("Batman", newCommentaire);

        assertThat(shService.all().get(0).getCommentaires().size()).isEqualTo(1);

        shService.removeComment("Batman", 0);

        assertThat(shService.all().get(0).getCommentaires().size()).isEqualTo(0);


    }


    @Test
    public void should_do_nothing_first_if_remove_a_comment_to_the_batman_list()
    {
        SuperHeroService shService = new SuperHeroService();

        assertThat(shService.all().get(0).getCommentaires().size()).isEqualTo(0);

        shService.removeComment("Batman", 1);

        assertThat(shService.all().get(0).getCommentaires().size()).isEqualTo(0);

    }


    /*
    * Test de délétion d'un hero
     */
    @Test
    public void should_delete_an_hero()
    {
        SuperHeroService shService = new SuperHeroService();

        assertThat(shService.all().size() == 4).isEqualTo(true);

        SuperHero shTest =  shService.create("M. Lachaud", "JOL", "le C++", "Aucun");

        assertThat(shService.all().size() == 5).isEqualTo(true);

        shService.removeSH("yy");

        assertThat(shService.all().size() == 5).isEqualTo(true);

        shService.removeSH("M. Lachaud");

        //il y a déjà héros pré enregistré
        assertThat(shService.all().size() == 4).isEqualTo(true);
    }


    @Test
    public void should_delete_the_last_hero()
    {
        SuperHeroService shService = new SuperHeroService();
        SuperHero shTest =  shService.create("M. Lachaud", "JOL", "le C++", "Aucun");

        assertThat(shService.all().get(shService.all().size()-1).getNom().equals("M. Lachaud")).isEqualTo(true);
        assertThat(shService.all().get(shService.all().size()-1).getIdentiteSecrete().equals("JOL")).isEqualTo(true);
        assertThat(shService.all().get(shService.all().size()-1).getPouvoir().equals("le C++")).isEqualTo(true);
        assertThat(shService.all().get(shService.all().size()-1).getNemesis().equals("Aucun")).isEqualTo(true);

        shService.removeSH("M. Lachaud");

        assertThat(shService.all().get(shService.all().size()-1).getNom().equals("M. Lachaud")).isEqualTo(false);
        assertThat(shService.all().get(shService.all().size()-1).getIdentiteSecrete().equals("JOL")).isEqualTo(false);
        assertThat(shService.all().get(shService.all().size()-1).getPouvoir().equals("le C++")).isEqualTo(false);
        assertThat(shService.all().get(shService.all().size()-1).getNemesis().equals("Aucun")).isEqualTo(false);

    }

    @Test
    public void should_delete_the_first_hero()
    {
        SuperHeroService shService = new SuperHeroService();

        assertThat(shService.all().get(0).getNom().equals("Batman")).isEqualTo(true);

        shService.removeSH("Batman");

        assertThat(shService.all().get(0).getNom().equals("Batman")).isEqualTo(false);

    }



    /*
    * Test de selection d'un héro
    */

    @Test
    public void should_select_batman()
    {
        SuperHeroService shService = new SuperHeroService();
        SuperHero shTest;

        shTest = shService.selectById("Batman");

        assertThat(shTest.getNom()).isEqualTo("Batman");
        assertThat(shTest.getIdentiteSecrete()).isEqualTo("Bruce Wayne");
        assertThat(shTest.getPouvoir()).isEqualTo("Aucun");
        assertThat(shTest.getNemesis()).isEqualTo("le Joker");
    }






}