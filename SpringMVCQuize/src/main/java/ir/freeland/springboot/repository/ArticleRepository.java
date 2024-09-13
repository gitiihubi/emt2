package ir.freeland.springboot.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ir.freeland.springboot.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.name LIKE %:name% AND a.publisher.date BETWEEN :fromDate AND :toDate")
    List<Article> searchByNameAndDateRange(@Param("name") String name,
            @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}
