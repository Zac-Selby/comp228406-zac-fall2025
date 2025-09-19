package exercise1;

import java.time.LocalDate;

public class Singers {
    // Instance variables
    private int singerId;
    private String singerName;
    private String singerAddress;
    private LocalDate dateOfBirth;
    private int albumsPublished;

    // No-argument constructor
    public Singers() {
        this.singerId = 0;
        this.singerName = "";
        this.singerAddress = "";
        this.dateOfBirth = null;
        this.albumsPublished = 0;
    }

    // 5-argument constructor
    public Singers(int id, String name, String address, LocalDate dateOfBirth, int albumsPublished) {
        this.singerId = id;
        this.singerName = name;
        this.singerAddress = address;
        this.dateOfBirth = dateOfBirth;
        this.albumsPublished = albumsPublished;
    }

    // Getters
    public int getSingerId() {return singerId;}
    public String getSingerName() {return singerName;}
    public String getSingerAddress() {return singerAddress;}
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public int getAlbumsPublished() {return albumsPublished;}

    // Setters
    public void setSingerId(int id) {this.singerId = id;}
    public void setSingerName(String name) {this.singerName = name;}
    public void setSingerAddress(String address) {this.singerAddress = address;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setAlbumsPublished(int albumsPublished) {this.albumsPublished = albumsPublished;}

    // Bulk/multi setter
    public void setAll(int id, String name, String address, LocalDate dateOfBirth, int albumsPublished)
    {
        this.singerId = id;
        this.singerName = name;
        this.singerAddress = address;
        this.dateOfBirth = dateOfBirth;
        this.albumsPublished = albumsPublished;
    }

    @Override
    public String toString() {
        return """
               Singer ID           : %d
               Singer Name         : %s
               Singer Address      : %s
               Date of Birth       : %s
               Albums Published    : %d
               """.formatted(singerId, singerName, singerAddress, dateOfBirth, albumsPublished);
    }
}
