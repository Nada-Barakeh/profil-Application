package de.hhu.pp2.profilapp.logic;

import de.hhu.pp2.profilapp.domain.Profil;
import de.hhu.pp2.profilapp.persistence.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfilEditor {
    //Dependency Injection
    private final Profile profile;

    public ProfilEditor(Profile profile){
        this.profile=profile;
    }
    public void edit(long id, String text){
        Profil profil=profile.load(id); // git ein AggregatRoot zurück
        profil.changeText(text);// text wird geändert
        profile.save(profil);
    }

}
