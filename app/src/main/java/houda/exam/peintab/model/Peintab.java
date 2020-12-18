package houda.exam.peintab.model;

public class Peintab {

    private int img_tb;
    private String  titre;
    private String artist;
    private String date;
    private String description;

    public Peintab(int img_tb , String titre, String artist, String date, String description) {

        this.img_tb=img_tb;
        this.titre = titre;
        this.artist = artist;
        this.date = date;
        this.description = description;
    }

    public Peintab() {
    }

    public int getImg_tb() {
        return img_tb;
    }

    public void setImg_tb(int img_tb) {
        this.img_tb = img_tb;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
