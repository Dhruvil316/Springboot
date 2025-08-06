package com.dhruvil.learnSpringbootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//the component scanning starts from here
//spring are the java objects that are manage by spring container
//Constructor dependency injection does not require the @Autowired

@SpringBootApplication
public class LearnSpringbootAppApplication implements CommandLineRunner {

	private PayementService payementService ;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringbootAppApplication.class, args);
	}

//	Constructor dependency injection
//	Use @Primary to mark one bean as the default choice:
//	Use @Qualifier("beanName") to tell Spring exactly which bean to use.
//	checkout the notes
	@Autowired
	LearnSpringbootAppApplication (@Qualifier("stripe") PayementService payementService ) {
		this.payementService = payementService ;
	}


	@Override
	public String toString() {
		return "LearnSpringbootAppApplication{" +
				"payementService=" + payementService +
				'}';
	}

//	CommandLineRunner gives us method which runs after everything is built
	@Override
	public void run(String... args) throws Exception {
		String pay = payementService.pay() ;
		System.out.println(pay) ;
	}
}
