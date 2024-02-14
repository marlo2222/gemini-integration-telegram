package com.gemini.integration.service;

import com.gemini.integration.model.Candidate;
import com.gemini.integration.model.Content;
import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class GeminiService {
    private final String api_key = System.getenv("TOKEN_GEMINI");
    private final String url_api = System.getenv("URL");
    public String gemini_generate(String input){

        HttpResponse<JsonNode> response = Unirest.post(url_api + api_key)
                .header("Content-Type", "application/json")
                .body(Content.get_content(input))
                .asJson();

        int status = response.getStatus();
        Candidate candidate = new Gson().fromJson(response.getBody().toString(), Candidate.class);

        return candidate.candidates.get(0).content.parts.get(0).text;
    }

}
