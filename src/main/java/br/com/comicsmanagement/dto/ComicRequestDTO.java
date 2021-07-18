package br.com.comicsmanagement.dto;

import br.com.comicsmanagement.client.dto.CreatorsItemsResponse;
import br.com.comicsmanagement.client.dto.PricesResponse;
import br.com.comicsmanagement.client.dto.ResponseApiDTO;
import java.util.List;

public class ComicRequestDTO {

    private Long comicId;
    private String title;
    private String description;
    private String isbn;
    private List<PricesResponse> prices;
    private List<CreatorsItemsResponse> creators;
    private Long user_id;

    public ComicRequestDTO(ResponseApiDTO resp, Long user_id) {
        this.comicId = resp.getData().getResults().get(0).getId();
        this.title = resp.getData().getResults().get(0).getTitle();
        this.description = resp.getData().getResults().get(0).getDescription();
        this.isbn = resp.getData().getResults().get(0).getIsbn();
        this.prices = resp.getData().getResults().get(0).getPrices();
        this.creators = resp.getData().getResults().get(0).getCreators().getItems();
        this.user_id = user_id;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<PricesResponse> getPrices() {
        return prices;
    }

    public void setPrices(List<PricesResponse> prices) {
        this.prices = prices;
    }

    public List<CreatorsItemsResponse> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorsItemsResponse> creators) {
        this.creators = creators;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

}
