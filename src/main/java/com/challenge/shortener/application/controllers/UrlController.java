package com.challenge.shortener.application.controllers;


import com.challenge.shortener.application.models.Url;
import com.challenge.shortener.application.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


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

    @GetMapping("/{short-url}")
    public ResponseEntity<Objects> redirect(@PathVariable String shortUrl) {


        Optional<Url> originalUrl = urlService.getOriginalUrl(shortUrl);

        if (originalUrl.isPresent()) {
            Url url = originalUrl.get();
            return ResponseEntity.status(200).location((URI.create(url.getOriginalUrl()))).build();
        }

        System.out.println("Not found URL or date expire");

        return ResponseEntity.notFound().build();

    }

}
