package ua.lviv.logos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.logos.dao.StudentDao;
import ua.lviv.logos.domain.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext  ctx = SpringApplication.run(Application.class, args);
		StudentDao studentDaoImpl = (StudentDao) ctx.getBean("studentDaoImpl");
		
		//create 
		studentDaoImpl.create(new Student(0, "Petro", 23));
		studentDaoImpl.create(new Student(1, "Mars", 50));
		studentDaoImpl.create(new Student(2, "Avacado", 15));
		
		//read
		Student studentRead = studentDaoImpl.read(2);
		System.out.println("Student with id 2 is ----> " + studentRead);
		
		//update
		studentRead.setAge(40);
		studentDaoImpl.update(studentRead);
		
		//delete
		Student studentDelete = studentDaoImpl.read(0);
		System.out.println("Before delete: " + studentDelete);
		studentDaoImpl.delete(0);
		System.out.println("After delete: " + studentDelete);
		
	}
}
