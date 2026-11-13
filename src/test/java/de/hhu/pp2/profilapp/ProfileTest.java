package de.hhu.pp2.profilapp;

import de.hhu.pp2.profilapp.domain.Profil;
import de.hhu.pp2.profilapp.persistence.Profile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ProfileTest {

    @Test
    @DisplayName("wenn id nicht existiert soll RuntimeException werfen")
    void testLoad1() {

        //Arrange:
        Profile profile = new Profile();

        //Act + Assert:
        assertThatThrownBy(()-> profile.load(99L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Profil nicht gefunden");
    }

    @Test
    @DisplayName("wenn id existiert soll ein Profil zurückgeben")
    void testLoad2(){
        //Arr:
        Long id=1L;
        Profile profile=new Profile();
        Profil  profil = new Profil(id,"text");
        profile.save(profil);

        //Act:
         Profil geladen  =profile.load(id);

         //Assert
        assertThat(geladen).isNotNull();
        assertThat(geladen.getText()).isEqualTo(id);
        assertThat(geladen.getText()).isEqualTo("text");
    }



    @Test
    @DisplayName("wenn wir save dann load machen bekommen wir ein ")
    void testSave(){

        //Arr;
        long id=1L;
        Profile profile = new Profile();
        Profil originProfil = new Profil(id,"Alt");
        profile.save(originProfil);

        //Act: neuen Text ersetzen unter den gleichen id & dann speichern
        originProfil.changeText("Neu");
        profile.save(originProfil);
       Profil geladen = profile.load(id);

       //Assert;
        assertThat(geladen.getText()).isEqualTo("Neu");
    }






}