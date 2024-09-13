package ir.freeland.springboot.service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ir.freeland.springboot.controller.exception.ArticleNotFoundException;
import ir.freeland.springboot.controller.exception.PublisherNotFoundException;
import ir.freeland.springboot.model.Article;
import ir.freeland.springboot.model.Publisher;
import ir.freeland.springboot.repository.ArticleRepository;
import ir.freeland.springboot.repository.PublisherRepository;

@Service
public class MainService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PublisherRepository publisherRepository;

    public List<Article> findArticlesByNameAndDateRange(String name, Date fromDate, Date toDate) {
        return articleRepository.searchByNameAndDateRange(name, fromDate, toDate);
    }

    public List<Article> allArticles() {
        return articleRepository.findAll();
    }

    @Transactional
    public Article saveArticle(Article article) {
        Publisher publisher = article.getPublisher();
        Optional<Publisher> publisherOptional =
                publisherRepository.findById(article.getPublisher().getId());
        if (!publisherOptional.isPresent())
            publisher = savePublisher(article.getPublisher());

        article.setPublisher(publisher);
        return articleRepository.save(article);
    }

    @Transactional
    public boolean deleteArticle(long id) {
        articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        articleRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Article updateArticle(long id, Article newArticle) {
        long publisherID = newArticle.getPublisher().getId();
        Article exsitArticle =
                articleRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
        Publisher existPublisher = publisherRepository.findById(publisherID)
                .orElseThrow(PublisherNotFoundException::new);

        exsitArticle.setName(newArticle.getName());
        exsitArticle.setDescription(newArticle.getDescription());
        exsitArticle.setPublisher(existPublisher);
        return articleRepository.save(exsitArticle);
    }

    public List<Publisher> allPublishers() {
        return publisherRepository.findAll();
    }

    @Transactional
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Transactional
    public Publisher updatePublisher(long id, Publisher newPublisher) {
        Publisher existingPublisher =
                publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
        existingPublisher.setName(newPublisher.getName());
        existingPublisher.setDate(newPublisher.getDate());
        return publisherRepository.save(existingPublisher);
    }

    @Transactional
    public boolean deletePublisher(long id) {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            if (article.getPublisher().getId() == id) {
                articleRepository.delete(article);
            }
        }
        publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
        publisherRepository.deleteById(id);
        return true;
    }
}
