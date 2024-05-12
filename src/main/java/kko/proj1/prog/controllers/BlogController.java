package kko.proj1.prog.controllers;


import kko.proj1.prog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kko.proj1.prog.repo.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    PostRepo postRepository;

    @GetMapping("/blog")
    public String greeting(Model model) {
        System.out.println(">>>"+postRepository.count());
        Iterable<Post> posts=postRepository.findAll();
        for(Post p:posts){
            System.out.println(">>>"+p.getTitle());
        }
        model.addAttribute("title1", "blogs page");
        model.addAttribute("posts", posts);
        return "blog-main";
    }
    @GetMapping("/add")
    public String add(Model model) {
        //Post p=new Post("title","anons","full_text");
        //postRepository.save(p);
        //model.addAttribute("title", "add completed");
        return "add";
    }
    @PostMapping("/add")
    public String add1(@RequestParam String title,@RequestParam String anons, @RequestParam String full_text,Model model) {
        Post p=new Post(title,anons,full_text);
        postRepository.save(p);
        model.addAttribute("title", "add completed");
        return "home";
    }

    @GetMapping("/blog/{id}")
    public String blog_id(@PathVariable(value="id") long id, Model model) {
        Optional<Post> p=postRepository.findById(id);
        ArrayList<Post> res=new ArrayList<>();
        p.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blog_id_edit(@PathVariable(value="id") long id, Model model) {
        Optional<Post> p=postRepository.findById(id);
        ArrayList<Post> res=new ArrayList<>();
        p.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String upd1(@PathVariable(value="id") long id, @RequestParam String title,@RequestParam String anons, @RequestParam String full_text,Model model) {
        Post p=postRepository.findById(id).orElseThrow();
        p.setTitle(title);
        p.setAnons(anons);
        p.setFull_text(full_text);
        //Post p=new Post(title,anons,full_text);
        postRepository.save(p);
        model.addAttribute("title", "add completed");
        return "home";
    }
}