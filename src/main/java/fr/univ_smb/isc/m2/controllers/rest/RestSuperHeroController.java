package fr.univ_smb.isc.m2.controllers.rest;

import fr.univ_smb.isc.m2.config.rest.ResourceNotFoundException;
import fr.univ_smb.isc.m2.domain.superH.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class RestSuperHeroController {

    private final SuperHeroService superHeroService;

    @Autowired()
    public RestSuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }


    @RequestMapping(value = "/superHero", method = GET, produces = "application/json;charset=UTF-8")
    public List<SuperHero> allSuperHero() {
        return superHeroService.all();
    }


    @RequestMapping(value = "/superHero", method = POST, produces = "application/json;charset=UTF-8")
    public SuperHero createSuperHero(@RequestParam String nom, @RequestParam String identiteSecrete,
                                     @RequestParam String pouvoir, @RequestParam String nemesis) {
        return superHeroService.create(nom, identiteSecrete, pouvoir, nemesis);
    }


    @RequestMapping(value = "/superHero/{nom}", method = GET, produces = "application/json;charset=UTF-8")
    public SuperHero superHero(@PathVariable String nom) {
        SuperHero superHero = superHeroService.selectById(nom);
        return Optional.ofNullable(superHero).orElseThrow(ResourceNotFoundException::new);
    }


    @RequestMapping(value = "/superHero/{nom}", method = POST, produces = "application/json;charset=UTF-8")
    public void postCommentaire(@RequestParam String nom, @RequestParam String comment) {
        superHeroService.addCommentaire(nom, comment);
    }


    @RequestMapping(value = "/superHero", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void deleteSuperHero(@RequestParam String nom)
    {
        superHeroService.removeSH(nom);
    }



}