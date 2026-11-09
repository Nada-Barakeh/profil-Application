package de.hhu.pp2.profilapp.domain;

//AggregatRoot(kein Bean Klass)
public class Profil {

    private Long id;
    private String text;

    public Profil(Long id, String text){
        this.id=id;
        this.text=text;
    }

    public void changeText(String newText){
        this.text=newText;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
