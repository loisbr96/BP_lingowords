package com.wordsource;

import com.service.WordSource;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileWordSourceIntegrationTest {

    public static final File FILE = new File("src/test/resources/woorden-2correct.txt");

    @Test
    public void readFile() throws Exception {
        //arrange
        WordSource wordSource = new FileWordSource(FILE);

        //act
        List<String> result = wordSource.read();

        //assert
        assertThat(result).contains("laptop", "testen");

    }
}
