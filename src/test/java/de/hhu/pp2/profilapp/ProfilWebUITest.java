package de.hhu.pp2.profilapp;

import de.hhu.pp2.profilapp.logic.ProfilEditor;
import de.hhu.pp2.profilapp.web.ProfilWebUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfilWebUI.class)
public class ProfilWebUITest {
    @Autowired
    MockMvc mvc;

    @MockitoBean
    ProfilEditor editor;

    @Test
    @DisplayName("Get /profil zeigt das Formuler mit profilID")
    void testGetProfil() throws Exception {
        mvc.perform(get("/profil"))
                .andExpect(status().isOk()) //Status: 200 OK
                .andExpect(view().name("profilForm")) //view-Name
                .andExpect(model().attributeExists("profilID"))// Attribute
                .andExpect(model().attribute("profilID", 1L));//Attribute

    }

    @Test
    @DisplayName("Post /profil ruft editor.edit() & andert Text ins Formuler")
    void testPost() throws Exception {
        mvc.perform(post("/profil")
                        .param("id", "42")
                        .param("text", "Neu"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("erfolgreich"))
                .andExpect(model().attribute("erfolgreich", "Profil aktualisiert!"))
                .andExpect(view().name("profilForm"));

        verify(editor).edit(42L, "Neu");
    }


    @Test
    @DisplayName("Post /profil mit leerem Text soll Fehlermeldung zeigen")
    void testLeerText() throws Exception {
        mvc.perform(post("/profil")
                        .param("id", "42")
                        .param("text", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("profilForm"))
                .andExpect(model().attributeExists("fehler"));

        verify(editor, never()).edit(anyLong(), anyString());

    }


    @Test
    @DisplayName("Post /profil mit nicht existierenden Profil zeigt Fehler")
    void testNicht_Exis_Profil() throws Exception {

        doThrow((new RuntimeException("Profil nicht gefunden")))
                .when(editor).edit(anyLong(), anyString());

        mvc.perform(post("/profil")
                        .param("id", "999")
                        .param("text", "any"))
                .andExpect(status().isOk())
                .andExpect(view().name("profilForm"))
                .andExpect(model().attributeExists("fehler"));

    }


}
