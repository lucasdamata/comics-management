package br.com.comicsmanagement.repository;

import br.com.comicsmanagement.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {
}
