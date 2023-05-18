package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class PiSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(PiSeminar2Application.class, args);
	}

	@Bean // isauks funkciju automātiski, kad startēs sistēmu
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo stRepo, ICourseRepo courRepo,
			IGradeRepo grRepo) {

		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {

				Professor pr1 = new Professor("Karina", "Skirmante", Degree.MG);
				Professor pr2 = new Professor("Martins", "Saulitis", Degree.MG);
				profRepo.save(pr1);
				profRepo.save(pr2);

				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Kalnina");
				stRepo.save(st1);
				stRepo.save(st2);

				Course c1 = new Course("JAVA I", 4, pr1);
				Course c2 = new Course("Datubazes", 4, pr2);
				courRepo.save(c1);
				courRepo.save(c2);

				grRepo.save(new Grade(10, st1, c1));// Janis sanem 10 JAVA I
				grRepo.save(new Grade(6, st1, c2));
				grRepo.save(new Grade(8, st2, c1));
				grRepo.save(new Grade(10, st2, c2));
			}
		};

	}

}
