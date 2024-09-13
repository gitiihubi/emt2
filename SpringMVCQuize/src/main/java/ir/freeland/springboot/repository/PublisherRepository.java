package ir.freeland.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ir.freeland.springboot.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
