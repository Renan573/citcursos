package com.citbarueri.cursos.controller;

import com.citbarueri.cursos.entities.Data;
import com.citbarueri.cursos.model.Cursos;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/cursos/sympla")
public class CursosController {
    
    @GetMapping("/listar")
    public String getCursos(Model model) {

        List<Cursos> listaDeCursos = new ArrayList<Cursos>();
        Data data = Data.getData();

        listaDeCursos = data.getCoursesList();
        
        model.addAttribute("cursoslist", listaDeCursos);
        return "cursos";

    }

}
