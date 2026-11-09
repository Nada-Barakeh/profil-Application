package de.hhu.pp2.profilapp.logic;

import de.hhu.pp2.profilapp.domain.Profil;
import de.hhu.pp2.profilapp.persistence.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfilEditor {
    private final Profile profile;
    public ProfilEditor(Profile profile){
        this.profile=profile;
    }
    public void edit(long id, String text){
        Profil profil=profile.load(id);
        profil.changeText(text);
        profile.save(profil);
    }

}
