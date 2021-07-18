package br.com.comicsmanagement.service;

import br.com.comicsmanagement.model.Comic;
import br.com.comicsmanagement.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    @Autowired
    private ComicRepository comicRepository;

    private String isbn;

    public void weekDay(Comic comic) {
        if(comic.getIsbn().endsWith("0") || comic.getIsbn().endsWith("1")) isbn = "segunda-feira";
        if(comic.getIsbn().endsWith("2") || comic.getIsbn().endsWith("3")) isbn = "terça-feira";
        if(comic.getIsbn().endsWith("4") || comic.getIsbn().endsWith("5")) isbn = "quarta-feira";
        if(comic.getIsbn().endsWith("6") || comic.getIsbn().endsWith("7")) isbn = "quinta-feira";
        if(comic.getIsbn().endsWith("8") || comic.getIsbn().endsWith("9")) isbn = "sexta-feira";

        comic.setDayDiscount(isbn);
        comicRepository.save(comic);
    }

    public String activeDiscount(String dayWeek){
        if(dayWeek.equals("MONDAY")) return "segunda-feira";
        if(dayWeek.equals("TUESDAY")) return "terça-feira";
        if(dayWeek.equals("WEDNESDAY")) return "quarta-feira";
        if(dayWeek.equals("THURSDAY")) return "quinta-feira";
        if(dayWeek.equals("FRIDAY")) return "sexta-feira";

        return  " ";
    }
}
