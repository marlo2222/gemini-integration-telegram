package com.gemini.integration.model;

public class Content {
    public static String get_content(String input){
        return String.format("{\"contents\":[{\"parts\":[{\"text\":\"%s\"}]}]}", input);
    }
}
