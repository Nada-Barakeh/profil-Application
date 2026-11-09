package de.hhu.pp2.profilapp;

import de.hhu.pp2.profilapp.domain.Profil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfilTest {

    @Test
    @DisplayName("new Profil wird erfolgreich erstellt mit einem id = 123L & einen new Text")
    void testProfil(){
        //Arrange:
        Profil p = new Profil(123L,"text");
        //Act:
        p.changeText("new Text");
        //Assert:
        assertThat(p.getText()).isEqualTo("new Text");
    }


}
