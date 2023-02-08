package com.jsp.car.chassis.registration.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.car.chassis.registration.dto.Car;
import com.jsp.car.chassis.registration.dto.Chassis;
import com.jsp.car.chassis.registration.dto.Registration;

public class CarDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pratham");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Car insertCar(Car car, Chassis chassis, Registration registration) {
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(chassis);
		entityManager.persist(registration);
		entityTransaction.commit();
		System.out.println("All Data Add");
		return car;

	}

	public Car deleteCar(Car car, Chassis chassis, Registration registration) {
		Car car2 = entityManager.find(Car.class, car.getId());
		Chassis chassis2 = entityManager.find(Chassis.class, car.getId());
		Registration registration2 = entityManager.find(Registration.class, car.getId());

		entityTransaction.begin();
		entityManager.remove(car2);
		entityManager.remove(chassis2);
		entityManager.remove(registration2);
		entityTransaction.commit();
		System.out.println("All Record Delete");
		return car;

	}

	public Car updateCar(Car car, Chassis chassis, Registration registration) {
		Car car2 = entityManager.find(Car.class, 3);
		Chassis chassis2 = entityManager.find(Chassis.class, 3);
		Registration registration2 = entityManager.find(Registration.class, 3);

		if (car2 != null) {
			car2.setName(car.getName());
			car2.setBrand(car.getBrand());
			car2.setColor(car.getColor());

			entityTransaction.begin();
			entityManager.merge(car2);
			entityTransaction.commit();

			System.out.println("A Record Is Update");

		} else {
			System.out.println("Record Not found");
		}
		return car2;

	}

	public void getAllRecords() {
		String sql1 = "select car from Car car";
		String sql2 = "select chassis from Chassis chassis";
		String sql3 = "select registration from Registration registration";

		Query query1 = entityManager.createQuery(sql1);
		Query query2 = entityManager.createQuery(sql2);
		Query query3 = entityManager.createQuery(sql3);

		java.util.List<Car> cars = query1.getResultList();
		java.util.List<Chassis> chassis = query2.getResultList();
		java.util.List<Registration> registrations = query3.getResultList();
		for (Car c1 : cars) {

			System.out.println("===========================================================");
			System.out.print("Car id: " + c1.getId());
			System.out.print(" Car name: " + c1.getName());
			System.out.print(" Car brand: " + c1.getBrand());
			System.out.println(" Car color: " + c1.getColor());

		}
		for (Chassis c2 : chassis) {
			System.out.println("===========================================================");
			System.out.print("Chassis id: " + c2.getId());
			System.out.println(" Chassis no: " + c2.getChassis());
		}
		for (Registration r : registrations) {
			System.out.println("===========================================================");
			System.out.print("Registration id: " + r.getId());
			System.out.println(" Registration no: " + r.getRegistration());
		}

	}
}
