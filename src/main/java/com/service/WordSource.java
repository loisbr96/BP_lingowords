package com.service;

import java.util.List;

public interface WordSource {

    List<String> read() throws Exception;

}
