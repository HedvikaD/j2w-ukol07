package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView list() {
        return new ModelAndView("index")
                .addObject("index", postService.list());
    }


    @GetMapping("/{slug}")
    public ModelAndView singlePost(@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("detail", postService.singlePost(slug));


    }
    @PostMapping("/edit_post/{slug}")
    public String updatePost(@PathVariable("slug") String slug, @ModelAttribute Post updatedPost) {
        postService.updatePost(slug, updatedPost);
        return "redirect:/";
    }

}