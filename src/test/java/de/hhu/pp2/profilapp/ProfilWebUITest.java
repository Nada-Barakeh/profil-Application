/*

package de.hhu.pp2.profilapp;


import de.hhu.pp2.profilapp.logic.ProfilEditor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.expression.spel.ast.PropertyOrFieldReference;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfilWebUITest.class)
public class ProfilWebUITest {
    @Autowired
    MockMvc mvc;

    @MockitoBean
    ProfilEditor editor;

    @Test
    @DisplayName("")
    void test() throws Exception{

        /*
        //kein konfiguration


            mvc.perform(post("/profil")
                           .param("id", "123L")
                           .param("text","text")
                   )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("Profil aktualisiert!"));


      //  verify(editor).edit(123L, "text");


    }

}
*/