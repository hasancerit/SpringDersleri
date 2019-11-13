package guru.springframework.joke.services;

import guru.springframework.joke.config.DenemeBean;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/25/17.
 */
@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    
    @Autowired
    private DenemeBean denemeBean1; 
    
    @Autowired				
    public JokeServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getJoke() {
    	System.out.println("Servis İçindeki:"+denemeBean1.getD());
        return chuckNorrisQuotes.getRandomQuote();
    }
}
