package br.com.comicsmanagement.dto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreatorsRequestDTO {
    private List<String> name = new ArrayList<>();
    private Long id_comic;

    public CreatorsRequestDTO(ComicRequestDTO comicRequestDTO) {
        comicRequestDTO.getCreators().forEach(itemsResponse -> {
            this.name = Collections.singletonList(itemsResponse.getName());
            this.id_comic = comicRequestDTO.getComicId();
        });

    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Long getId_comic() {
        return id_comic;
    }

    public void setId_comic(Long id_comic) {
        this.id_comic = id_comic;
    }
}
