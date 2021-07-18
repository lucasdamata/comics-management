package br.com.comicsmanagement.repository;

import br.com.comicsmanagement.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComicRepository extends JpaRepository<Comic, Long> {

    @Query("select c from Comic c where c.user.id = :id")
    List<Comic> listUserComics(Long id);
}
