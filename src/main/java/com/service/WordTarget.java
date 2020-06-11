package com.service;

import reactor.core.publisher.Mono;

public interface WordTarget {

     Mono<String> create(String word);

}
