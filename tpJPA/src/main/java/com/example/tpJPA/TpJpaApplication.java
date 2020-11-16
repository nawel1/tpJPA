package com.example.tpJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VehiculeRepository repository, PersonRepository repo, RentRepository rep) {
		return (args) -> {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = dateFormat.parse("2020-10-09");
			System.out.println(beginDate.toString());

			Date endDate = dateFormat.parse("2020-11-09");
			System.out.println(endDate.toString());


			/**
			 * rent a VEHICULE
			 */
			Vehicule vehicule = new Vehicule("vehicule");
			Person tintin = new Person("Tintin", 22);
			Rent rent = new Rent(beginDate, endDate, vehicule, tintin);
			vehicule.getRents().add(rent);

			repository.save(vehicule);
			repo.save(tintin);
			rep.save(rent);


			/**
			 * rent a van
			 */
			Vehicule van = new Van("van", 300);
			Person prousoth = new Person("Prousoth", 22);
			Rent rent2 = new Rent(beginDate, endDate, van, prousoth);
			van.getRents().add(rent2);

			repository.save(van);
			repo.save(prousoth);
			rep.save(rent2);

			/**
			 * rent a car
			 */
			Vehicule voiture = new Car("Voiture", 6);
			Person nawel = new Person("Nawel", 20);
			Rent rent1 = new Rent(beginDate, endDate, voiture, nawel);
			voiture.getRents().add(rent1);




			/**
			 * Nawel rent two Cars
			 * */

			Vehicule car2 = new Car("CAR_TEST_2", 5);
			Rent rentCar2= new Rent(beginDate, endDate, car2, nawel);
			car2.getRents().add(rentCar2);

			repository.save(voiture);
			repo.save(nawel);
			rep.save(rent1);

			repository.save(car2);
			rep.save(rentCar2);








			System.out.println("-------------------------------");
			System.out.println("vehicules found with findAll():");
			for (Vehicule vehicules : repository.findAll()) {
				System.out.println(vehicules.toString());
			}

			System.out.println("-------------------------------");
			System.out.println("Persons associted with a rent");
			Iterable<Vehicule> vehicules = repository.findAll();
			Vehicule v = vehicules.iterator().next();

			List<Rent> persons = v.getRents();
			System.out.println(persons.toString());

			System.out.println("--------------------------------------------");
			System.out.println("City found with findName('Paris'):");
			repository.findByPlateNumber("CAR_TEST_2").forEach(vec -> {
				System.out.println(vehicule.toString());
			});

		};
	}


}
