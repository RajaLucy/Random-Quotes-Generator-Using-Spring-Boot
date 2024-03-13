package in.ashokit.binding;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuoteApiResponse {
	
	
	private List<Quote> quotes;

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
	

}
