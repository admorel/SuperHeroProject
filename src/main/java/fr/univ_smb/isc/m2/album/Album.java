package fr.univ_smb.isc.m2.album;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private Integer year;

    protected Album() {
    }

    public Album(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format(
                "Album[id=%d, title='%s', year='%d']",
                id, title, year);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }
}