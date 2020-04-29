package com.service;

import com.persistence.model.Word;
import com.persistence.repo.WordRepository;
import com.service.exception.NoWordFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired
    private WordRepository wordRepository;

    @GetMapping
    public Iterable<Word> findAll(){
        return wordRepository.findAll();
    }

    @GetMapping("/{id}")
    public Word findOne(@PathVariable long id){
        return wordRepository.findById(id)
                .orElseThrow(NoWordFoundException::new);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Word create(@RequestBody Word word) {
        Word word1 = wordRepository.save(word);
        return word1;
    }
}
