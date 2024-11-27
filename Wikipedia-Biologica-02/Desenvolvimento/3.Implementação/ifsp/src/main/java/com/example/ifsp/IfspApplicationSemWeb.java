//package com.example.ifsp;
//
//import com.example.ifsp.principal.Principal;
//import com.example.ifsp.repository.AnimalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class IfspApplicationSemWeb implements CommandLineRunner {
//
//	@Autowired
//    private AnimalRepository animalRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal(animalRepository);
//		principal.menu();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(IfspApplicationSemWeb.class, args);
//	}
//
//}
