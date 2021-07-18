package br.com.comicsmanagement.service;

import br.com.comicsmanagement.model.Comic;
import br.com.comicsmanagement.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class UpdateDiscount {
    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private DiscountService discountService;

    public void updateDiscount() {
        String dayWeek = LocalDate.now().getDayOfWeek().toString();
         List<Comic> comics = comicRepository.findAll();
        comics.stream().forEach(e->{
            if(e.getDayDiscount() == discountService.activeDiscount(dayWeek)) e.setDiscountActive(true);
        });
        comicRepository.saveAll(comics);
    }


}
