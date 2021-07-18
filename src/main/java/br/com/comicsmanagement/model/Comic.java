package br.com.comicsmanagement.model;

import br.com.comicsmanagement.dto.ComicRequestDTO;
import br.com.comicsmanagement.repository.UserRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Comic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long comicId;
    private String title;
    private String isbn;
    private Double price;
    @Column(length = 2000)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComic")
    private List<Autors> autors;
    @ManyToOne
    private User user;
    private String dayDiscount = null;
    private Boolean discountActive = false;


    public Comic(ComicRequestDTO comicRequestDTO, UserRepository userRepository, Long id, List<Autors> autors) {
        User user = userRepository.getById(id);
        this.comicId = comicRequestDTO.getComicId();
        this.title = comicRequestDTO.getTitle();
        this.isbn = comicRequestDTO.getIsbn();
        this.price = comicRequestDTO.getPrices().get(0).getPrice();
        this.description = comicRequestDTO.getDescription();
        this.autors = autors;
        this.user = user;

    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comic other = (Comic) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Autors> getAutors() {
        return autors;
    }

    public void setAutors(List<Autors> autors) {
        this.autors = autors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
