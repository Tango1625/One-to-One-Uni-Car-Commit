package com.jsp.car.chassis.registration.controller;

import com.jsp.car.chassis.registration.dto.Car;
import com.jsp.car.chassis.registration.dto.Chassis;
import com.jsp.car.chassis.registration.dto.Registration;
import com.jsp.car.chassis.registration.service.CarService;

public class TestDriver {

	public static void main(String[] args) {

		// Inserting a record

		Chassis chassis = new Chassis();
		chassis.setChassis("SV30-0169288");

		Registration registration = new Registration();
		registration.setRegistration(" MH-19-AG-1000");

		Car car = new Car();
		car.setName("Nexon");
		car.setBrand("TATA");
		car.setColor("White");
		car.setChassis(chassis);
		car.setRegistration(registration);

		Chassis chassis1 = new Chassis();
		chassis1.setChassis("SV30-0169288");

		Registration registration1 = new Registration();
		registration1.setRegistration(" MH-19-AG-1000");

		CarService carService = new CarService();
		carService.insertCar(car, chassis, registration);

		// Deleting a record

		Car car2 = new Car();
		car2.setId(2);

		Chassis chassis2 = new Chassis();
		chassis2.setId(2);

		Registration registration2 = new Registration();
		registration.setId(2);

		CarService carService1 = new CarService();
		carService1.deleteCar(car2, chassis2, registration2);

//updating a record
		Car car3 = new Car();
		car3.setName(" C7");
		car3.setBrand("BMW");
		car3.setColor("Red");

		Chassis chassis3 = new Chassis();

		Registration registration3 = new Registration();
		CarService carService3 = new CarService();
		carService3.updateCar(car3, chassis3, registration3);

//fetch all Records		

		CarService carService4 = new CarService();
		carService4.getAllRecords();

	}

}
