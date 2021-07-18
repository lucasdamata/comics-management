package br.com.comicsmanagement.dto;

import br.com.comicsmanagement.model.Autors;
import br.com.comicsmanagement.model.Comic;
import br.com.comicsmanagement.model.User;
import java.util.List;

public class ComicResponseDTO {
    private Long id;
    private Long comicId;
    private String title;
    private String description;
    private String isbn;
    private String dayDiscount;
    private Boolean discountActive;
    private Double price;
    private List<Autors> autors;
    private User user_id;

    public ComicResponseDTO(Long id, Long comicId, String title, String description, String isbn, String dayDiscount, Boolean discountActive, Double price, List<Autors> autors, User user_id) {
        this.id = id;
        this.comicId = comicId;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.dayDiscount = dayDiscount;
        this.discountActive = discountActive;
        this.price = price;
        this.autors = autors;
        this.user_id = user_id;
    }

    public ComicResponseDTO(Comic comic) {
        this.id = comic.getId();
        this.comicId = comic.getComicId();
        this.title = comic.getTitle();
        this.description = comic.getDescription();
        this.isbn = comic.getIsbn();
        this.dayDiscount = comic.getDayDiscount();
        this.discountActive = comic.getDiscountActive();
        this.price = comic.getPrice();
        this.autors = comic.getAutors();
        this.user_id = comic.getUser();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDayDiscount() {
        return dayDiscount;
    }

    public void setDayDiscount(String dayDiscount) {
        this.dayDiscount = dayDiscount;
    }

    public Boolean getDiscountActive() {
        return discountActive;
    }

    public void setDiscountActive(Boolean discountActive) {
        this.discountActive = discountActive;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Autors> getAutors() {
        return autors;
    }

    public void setAutors(List<Autors> autors) {
        this.autors = autors;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
