package com.challenge.shortener.application.controllers;


import com.challenge.shortener.application.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@RequestMapping(name = "/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/short-url")
    public ResponseEntity<Map<String, String>> shortUrl(@RequestBody Map<String, String> request) {

        String original = request.get("url");

        String sort = urlService.shortenUrl(original);

        Map<String, String> resposta = new HashMap<String, String>();
        if (sort != null) {


            resposta.put("url", "https://shorter.com.br/" + sort);

            return ResponseEntity.ok(resposta);

        } else {
            return (ResponseEntity<Map<String, String>>) ResponseEntity.badRequest();
        }


    }



}
