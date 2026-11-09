package de.hhu.pp2.profilapp.persistence;

import de.hhu.pp2.profilapp.domain.Profil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Profile {
    //temporäre ich werde es später ersetzen
    private final Map<Long, Profil> store=new HashMap<>();

    public Profil load(Long id){
        Profil p = store.get(id);

        if(p==null) throw new RuntimeException("Profil nicht gefunden");
        return p;
    }

    public void save(Profil profil){
        store.put(profil.getId(), profil);
    }

}
