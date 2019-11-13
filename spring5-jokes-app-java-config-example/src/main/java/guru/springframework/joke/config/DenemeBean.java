package guru.springframework.joke.config;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")//Her AutoWired isteğinde yeni bir bean bağlar.
@Component
public class DenemeBean {
	private long d;
	public DenemeBean() {
		System.out.println("Olustu");
		setD(System.currentTimeMillis());
		System.out.println(getD());
	}
	public long getD() {
		return d;
	}
	public void setD(long d) {
		this.d = d;
	}
}
