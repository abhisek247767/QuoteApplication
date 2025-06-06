package com.quote.quoteapplication.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quote.quoteapplication.Model.Quote;

import jakarta.annotation.PostConstruct;

@Service
public class QuoteService {
	
	 private List<Quote> quotes;

	    @PostConstruct
	    public void loadQuotes() throws IOException {
	        ObjectMapper mapper = new ObjectMapper();
	        quotes = mapper.readValue(
	                new ClassPathResource("Data/Quotes.json").getInputStream(),
	                new TypeReference<List<Quote>>() {
	                });
	    }

	    public Quote getRandomQuote() {
	        return quotes.get(new Random().nextInt(quotes.size()));
	    }


}
