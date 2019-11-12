package guru.springframework;


import guru.springframework.controllers.Controller;
import guru.springframework.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		Controller controller2 = (Controller) ctx.getBean("controller");

		System.out.println(controller.hello());
		System.out.println(controller2.sayHello());
	}
}
