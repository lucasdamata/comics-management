package br.com.comicsmanagement.controller;

import br.com.comicsmanagement.client.ClientMarvel;
import br.com.comicsmanagement.client.dto.ResponseApiDTO;
import br.com.comicsmanagement.dto.ComicRequestDTO;
import br.com.comicsmanagement.dto.ComicResponseDTO;
import br.com.comicsmanagement.model.Autors;
import br.com.comicsmanagement.model.Comic;
import br.com.comicsmanagement.model.User;
import br.com.comicsmanagement.repository.AutorsRepository;
import br.com.comicsmanagement.repository.ComicRepository;
import br.com.comicsmanagement.repository.UserRepository;
import br.com.comicsmanagement.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ClientMarvel clientMarvel;

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private AutorsRepository autorsRepository;

    @PostMapping("/{id}/{userId}")
    @Transactional
    public ResponseEntity<?> create(@Valid @PathVariable Long id, @PathVariable Long userId, UriComponentsBuilder uribuilder) {
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            ResponseApiDTO resp = clientMarvel.getApi(id);
            ComicRequestDTO comicRequestDTO = new ComicRequestDTO(resp, userId);
            comicRequestDTO.getCreators().forEach(e -> {
                Autors autors = autorsRepository.save(new Autors(e.getName(), comicRequestDTO.getComicId()));
            });
            List<Autors> autors = autorsRepository.findByIdComic(id);
            Comic comic = comicRepository.save(new Comic(comicRequestDTO, userRepository, userId, autors));
            discountService.weekDay(comic);

            URI uri = uribuilder.path("/comics/{id}").buildAndExpand(comic.getId()).toUri();
            return ResponseEntity.created(uri).body(new ComicResponseDTO(comic));
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> list(@PathVariable Long id) {
        if (!userRepository.existsById(id)) return ResponseEntity.notFound().build();
        List<Comic> comics = comicRepository.listUserComics(id);
        comics.forEach(e -> {
            List<Autors> autors = autorsRepository.findByIdComic(e.getComicId());
            e.setAutors(autors);
        });
        return ResponseEntity.ok(comics);
    }

}
