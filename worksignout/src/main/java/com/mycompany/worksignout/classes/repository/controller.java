/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worksignout.classes.repository;

import com.mycompany.worksignout.classes.repository.User;
import com.mycompany.worksignout.classes.repository.Tarefas;
import com.mycompany.worksignout.classes.repository.RepositoryUser;
import com.mycompany.worksignout.classes.repository.RepositoryTarefas;
import java.util.ArrayList;
import javassist.bytecode.stackmap.BasicBlock;
import javax.naming.Binding;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author root
 */
@Controller
public class controller {

    @RequestMapping(value = "/")
    public String index(Model model) {

        Iterable<Tarefas> tarefas = repositoryTarefas.findAll();
        model.addAttribute("tarefas", tarefas);

        return "index";
    }

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryTarefas repositoryTarefas;

//    @RequestMapping("showtarefas")
//    public String showtarefas(Model model){
//        
//        Iterable<Tarefas> tarefas = repositoryTarefas.findAll();
//        model.addAttribute("tarefas", tarefas);
//
//        return "showtarefas";
//    }
    @RequestMapping(value = "Update_Page")
    public String pagina_update(Model model) {

        return "Update_Page";

    }

    @RequestMapping(value = "cadastro_usuarios")
    public String cadastro_usuarios_mapping(Model model) {

        Iterable<User> usuarios = repositoryUser.findAll();
        model.addAttribute("usuarios", usuarios);

        return "cadastro_usuarios";
    }

    @RequestMapping(value = "cadastro_tarefas", method = RequestMethod.GET)
    public String Cadastrar_Tarefas(Model model) {

        Iterable<User> users = repositoryUser.findAll();
        model.addAttribute("users", users);

        return "cadastro_tarefas";

    }

    @RequestMapping(value = "/salvar_user", method = RequestMethod.POST)
    public String salvar_user(@ModelAttribute("user")User usuario , RedirectAttributes attributes) {

//        User novoUsuario = new User();
//        novoUsuario.setEmail(email);
//        novoUsuario.setName(name);
//        novoUsuario.setPassword(password);
//
//        repositoryUser.save(novoUsuario);
//
//        attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso.");
//
//        return "redirect:/cadastro_usuarios";

    repositoryUser.save(usuario);
    
    attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso.");
    
    return "redirect:/cadastro_usuarios";

    }

    @RequestMapping(value = "salvar_tarefa",method = RequestMethod.PATCH)
    public String salvar_tarefa(@RequestParam("name") String name, @RequestParam("dataini") String dataini, @RequestParam("datafinal") String datafinal, @RequestParam("ctarefa") String ctarefa, @RequestParam String etarefa, RedirectAttributes attributes,
            Model model) {

        Tarefas novaTarefa = new Tarefas();

        novaTarefa.setName(name);
        novaTarefa.setDataini(dataini);
        novaTarefa.setDatafinal(datafinal);
        novaTarefa.setCtarefa(ctarefa);
        novaTarefa.setEtarefa(etarefa);

        repositoryTarefas.save(novaTarefa);

        attributes.addFlashAttribute("mensagem", "Tarefa salva com sucesso.");

        return "redirect:/";

    }

//    @DeleteMapping("/deletar_tarefa/{id}")
    @RequestMapping(value = "/deletar_tarefa/{id}", method = RequestMethod.GET)
    public String deletar_tarefa(@PathVariable Integer id, RedirectAttributes attributes, Model model) {

        repositoryTarefas.deleteById(id);
        attributes.addFlashAttribute("message", "A linha foi deletada com sucesso!");

        Iterable<Tarefas> tarefas = repositoryTarefas.findAll();
        model.addAttribute("tarefas", tarefas);

        return "redirect:/";

    }

    @RequestMapping(value = "/deletar_usuario/{id}", method = RequestMethod.GET)
    public String deletar_usuario(@PathVariable int id, RedirectAttributes attributes, Model model) {

        repositoryUser.deleteById(id);
        attributes.addFlashAttribute("message", "A linha foi deletada com sucesso!");

        Iterable<User> usuarios = repositoryUser.findAll();
        model.addAttribute("usuarios", usuarios);

        return "redirect:/cadastro_usuarios";

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditUserPage(@PathVariable int id){
        
       ModelAndView mav = new ModelAndView("Update_Page");
       User usuarios = repositoryUser.findById(id).get();
       mav.addObject("usuarios",usuarios);
       
       return mav;
       
    }
    @RequestMapping(value = "/salvar_atualizacao" ,method = RequestMethod.POST)
    public String save_update(@RequestParam("name") String name,@RequestParam("email") String email,Model model,RedirectAttributes attributes){
        
        User Usuario = new User();
        Usuario.setEmail(email);
        Usuario.setName(name);
        
        repositoryUser.save(Usuario);

        attributes.addFlashAttribute("message", "Usuário atualizado com sucesso.");

        return "redirect:/cadastro_usuarios";
        
    }
    
}
