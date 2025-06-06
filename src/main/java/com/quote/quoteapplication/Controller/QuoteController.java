package com.quote.quoteapplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quote.quoteapplication.Model.Quote;
import com.quote.quoteapplication.Service.QuoteService;


@Controller
public class QuoteController {
	private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }
	
	@GetMapping("/")
    public String home(Model model) {
        Quote quote = quoteService.getRandomQuote();
        model.addAttribute("quote", quote);
        return "index";
    }

}
