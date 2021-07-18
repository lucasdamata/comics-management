package br.com.comicsmanagement.client.dto;


import java.util.List;

public class ResultsResponse {
    private Long id;
    private String title;
    private String description;
    private String isbn;
    private List<PricesResponse> prices;
    private CreatorsResponse creators;

    public ResultsResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CreatorsResponse getCreators() {
        return creators;
    }

    public void setCreators(CreatorsResponse creators) {
        this.creators = creators;
    }

    @Override
    public String toString() {
        return "ResultsResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                ", prices=" + prices.get(0).getPrice() +
                ", creators=" + creators.getItems().get(0).getName() +
                '}';
    }
}
