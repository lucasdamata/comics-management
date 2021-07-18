package br.com.comicsmanagement.client;

import br.com.comicsmanagement.client.dto.ResponseApiDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "marvel", url = "http://gateway.marvel.com/v1/public/comics")
public interface ClientMarvel {


    @GetMapping("/{id}?ts=1&apikey=40069cad3e89a897bbaa19847e76936c&hash=dcf9eb522c7737587fed8b58a2659862")
    public ResponseApiDTO getApi(@PathVariable Long id);
}
