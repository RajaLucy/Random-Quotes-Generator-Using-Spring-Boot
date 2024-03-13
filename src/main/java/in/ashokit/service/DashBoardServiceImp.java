package in.ashokit.service;

import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.Quote;

@Service
public class DashBoardServiceImp implements DashBoardService {

	private String quoteUrl="https://type.fit/api/quotes";

	private Quote[] quotes =null;
	
	 Random random = new Random();

	
	@Override
	public String getQuote() {
		
		String text="";
		if(quotes ==null)
		{
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> entity = template.getForEntity(quoteUrl, String.class);
		String body = entity.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			quotes = mapper.readValue(body,Quote[].class);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		else {
	 int i = random.nextInt(quotes.length-1);
	  text = quotes[i].getText();	
		}
		return text;
		
		
	}
	

}
