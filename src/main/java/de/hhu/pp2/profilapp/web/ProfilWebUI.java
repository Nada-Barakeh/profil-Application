package de.hhu.pp2.profilapp.web;

import de.hhu.pp2.profilapp.logic.ProfilEditor;
import org.h2.engine.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfilWebUI {
    private final ProfilEditor editor;

    public ProfilWebUI(ProfilEditor editor){
        this.editor=editor;
    }

    @GetMapping("/profil")
    public String showForm(Model model){
        model.addAttribute("profilID" ,1L);
        return "profilForm";

    }


    @PostMapping("/profil")
    public String editProfil(@RequestParam Long id ,@RequestParam String text, Model model){
       // es fehlt noch ein klasse ProfilForm die die Parameter zusammenpackt
        // und ein mit @Valid annotierte obj ersetzt
        // außerdem ein BindingResult hinder dem Validiereten Object hinzufugen

        editor.edit(id,text);
        model.addAttribute("erfolgreich" ,"Profil aktualisiert!");
        return "profilForm";
    }


    }

