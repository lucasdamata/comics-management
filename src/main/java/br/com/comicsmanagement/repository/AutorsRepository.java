package br.com.comicsmanagement.repository;

import br.com.comicsmanagement.model.Autors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorsRepository extends JpaRepository<Autors, Long> {
    @Query("select a from Autors a where a.idComic = :id")
    List<Autors> findByIdComic(Long id);
}
