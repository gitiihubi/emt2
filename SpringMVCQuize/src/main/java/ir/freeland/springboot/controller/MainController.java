package ir.freeland.springboot.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ir.freeland.springboot.model.Article;
import ir.freeland.springboot.model.Publisher;
import ir.freeland.springboot.service.MainService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@Controller
@RequestMapping
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/searchArticles")
    @ResponseBody
    public ResponseEntity<List<Article>> searchArticles(@RequestParam String name,
            @RequestParam Date fromDate, @RequestParam Date toDate) {
        List<Article> articles = mainService.findArticlesByNameAndDateRange(name, fromDate, toDate);
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/articles")
    @ResponseBody
    public List<Article> allArticles() {
        return mainService.allArticles();
    }

    @GetMapping("/Publishers")
    @ResponseBody
    public List<Publisher> allPublishers() {
        return mainService.allPublishers();
    }

    @PostMapping("/article/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Article insertArticle(@RequestBody Article article) {
        return mainService.saveArticle(article);
    }

    @PostMapping("/publisher/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Publisher insertPublisher(@RequestBody Publisher publisher) {
        return mainService.savePublisher(publisher);
    }

    @DeleteMapping("/article/delete/{id}")
    @ResponseBody
    public String delteArticle(@PathVariable long id) {
        mainService.deleteArticle(id);
        return "The article has been deleted";
    }

    @PutMapping("/publisher/update/{id}")
    @ResponseBody
    public Publisher updatePublisher(@PathVariable long id, @RequestBody Publisher publisher) {
        return mainService.updatePublisher(id, publisher);
    }

    @PutMapping("/article/update/{id}")
    @ResponseBody
    public Article updatePublisher(@PathVariable long id, @RequestBody Article article) {
        return mainService.updateArticle(id, article);
    }

    @DeleteMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        mainService.deletePublisher(id);
        return "The publisher and its articles have been deleted";
    }

    // @RequestMapping("*")
    // @ResponseBody
    // public String allFallback() {
    // return "Bad api called";
    // }

}
