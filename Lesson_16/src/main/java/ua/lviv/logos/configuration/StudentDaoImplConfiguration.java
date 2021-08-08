package ua.lviv.logos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.logos.dao.StudentDao;
import ua.lviv.logos.dao.impl.StudentDaoImpl;

@Configuration
public class StudentDaoImplConfiguration {

	@Bean(name = "studentDaoImpl")
	public StudentDaoImpl getStudentDaoImplConfiguration() {
		return StudentDaoImpl.getStudentDaoImpl();
	}
	
}
