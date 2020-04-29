package com.persistence.repo;
import org.springframework.data.repository.CrudRepository;
import com.persistence.model.Word;

import java.util.List;

public interface WordRepository extends CrudRepository<Word, Long>{
    List<Word> findByWord(String word);


}
