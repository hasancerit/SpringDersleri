package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties") //Dışarıdan x.properties dosyası import eder.
public class PropertyConfig {
	@Value("${guru.user}") //x.properties içindeki proplar bu şekilde çekilir. (PropertyResorces gerekli.)
	String user;
	
	@Value("${app.isim}") //application.properties içindeki propları çektil. (PropertyResorces'a gerek yok direkt çekilir.)
	String user2;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	@Value("${JAVA HOME}")//Sistem Değişkenleri çekmek.
	private String homeDir;
	
	@Autowired			//Sistem Değişkenleri çekmek. env.getProperty("JAVA HOME")
	Environment env;
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUser(user2);
		fakeDataSource.setPassword(password);
		fakeDataSource.setUrl(url);
		
		return fakeDataSource;
	}
	
	//??
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer 
												= new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
}
