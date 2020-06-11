package com.service;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class WordServiceUnitTest {

//    @Test
//    public void addCorrectWord(){
//        //Arrange
//        WordTarget wordTarget = mock(WordTarget.class);
//        String word = "testen";
//        WordService wordService = new WordService(wordTarget);
//
//        //Act
//        wordService.addWord(word);
//
//        //Assert
//        verify(wordTarget,times(1)).create(word);
//    }

    @Test
    public void importFromWordSource() throws Exception {
        //Arrange
        WordTarget wordTarget = mock(WordTarget.class);
        WordSource wordSource = mock(WordSource.class);
        ArrayList<String> words = new ArrayList<>();
        words.add("laptop");
        words.add("t8est@");

        when(wordSource.read()).thenReturn(words);

        WordService wordService = new WordService(wordTarget);

        //Act
        wordService.importFromWordSource(wordSource);

        //Assert
        verify(wordTarget,times(1)).create(any());
    }

    @ParameterizedTest()
    @MethodSource("provideExampleWord")
    public void addWordIfAllowed(String word, int isAllowed){
        //Arrange
        WordTarget wordTarget = mock(WordTarget.class);
        WordService wordService = new WordService(wordTarget);

        //Act
        wordService.addWord(word);

        //Assert
        verify(wordTarget,times(isAllowed)).create(word);
    }

    public static Stream<Arguments> provideExampleWord(){
        return Stream.of(
                /*The following words are incorrect due to special characters or the length*/
                Arguments.of("68bla", 0),
                Arguments.of("testtesten", 0),
                Arguments.of("test", 0),

                /*The following words have no special characters and the lenght is 5,6 or 7 characters*/
                Arguments.of("testen", 1),
                Arguments.of("laptop", 1),
                Arguments.of("masters", 1),
                Arguments.of("tafel", 1)
        );
    }

}
