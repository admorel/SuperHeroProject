package fr.univ_smb.isc.m2.album;

import fr.univ_smb.isc.m2.controllers.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumRepository albumRepository;

    @Autowired(required = true)
    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album customer(@PathVariable String id) {


        Album album = albumRepository.findOne(Long.parseLong(id));

        if (album == null) {
            throw new ResourceNotFoundException();
        }

        return album;

    }

}
