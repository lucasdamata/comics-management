package br.com.comicsmanagement.client.dto;

import java.util.List;

public class CreatorsResponse {
    private List<CreatorsItemsResponse> items;

    public List<CreatorsItemsResponse> getItems() {
        return items;
    }

    public void setItems(List<CreatorsItemsResponse> items) {
        this.items = items;
    }
}
