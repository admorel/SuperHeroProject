package fr.univ_smb.isc.m2.album;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("select u from Album u")
    Stream<Album> findAllByAlbumQueryAndStream();

}