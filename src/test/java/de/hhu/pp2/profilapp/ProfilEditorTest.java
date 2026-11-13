package de.hhu.pp2.profilapp;

import de.hhu.pp2.profilapp.domain.Profil;
import de.hhu.pp2.profilapp.logic.ProfilEditor;
import de.hhu.pp2.profilapp.persistence.Profile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class ProfilEditorTest {

    @Test
    @DisplayName("methode edit in ProfilEditor funktioniert Korrekt ")
    void testProfilEditor(){
        // Arrange:
        Profil p = new Profil(123L ,"text");
        Profile ps = mock(Profile.class);
        // Stub/Mock ,weil ich möchte den kein echten DadenBank in test benutzen
        //sondern mein Test von DatenBank zu isolieren somit bekomme ich einen schnellen Test

        when(ps.load(123L)).thenReturn(p); // konfigurieren
        ProfilEditor editor = new ProfilEditor(ps);
        //Act:
        editor.edit(123L , "new Text"); // edit() gibt void zuruck
        //Assert:
        assertThat(p.getText()).isEqualTo("new Text");
        verify(ps).save(p);


    }
}
