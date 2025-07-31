package com.challenge.shortener.application.services;

import com.challenge.shortener.application.models.Url;
import com.challenge.shortener.application.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private String shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setInspirateData(LocalDateTime.now().plusDays(7));
        urlRepository.save(url);

        return url.getShortUrl();
    }

    private String generateShortUrl() {
        String uppers = IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        String lowers = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        String chars = uppers + lowers;

        StringBuilder shortUrl = new StringBuilder();
        Random rand = new Random();
        int len = 5 + rand.nextInt(5);

        for (int i = 0; i < len; i++) {
            shortUrl.append(chars.charAt(rand.nextInt(chars.length())));
        }

        return shortUrl.toString();
    }

}
