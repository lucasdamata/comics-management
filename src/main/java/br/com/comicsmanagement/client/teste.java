package br.com.comicsmanagement.client;

import br.com.comicsmanagement.client.dto.ResponseApiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class teste {
    @Autowired
    private ClientMarvel clientMarvel;

    private Logger qualquer = LoggerFactory.getLogger(this.getClass());

//    @GetMapping
//    public void teste() {
//        ResponseApiDTO responseApiDTO = clientMarvel.getApi();
//        qualquer.info(responseApiDTO.toString());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApiDTO> teste(@PathVariable Long id) {
        ResponseApiDTO responseApiDTO = clientMarvel.getApi(id);
        qualquer.info(responseApiDTO.toString());
        return ResponseEntity.ok(responseApiDTO);
    }
}
