package ua.lviv.logos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ua.lviv.logos.dao.StudentDao;
import ua.lviv.logos.domain.Student;

public class StudentDaoImpl implements StudentDao {
	
	private static StudentDaoImpl studentDao;
	private List<Student> listOfStudent = new ArrayList<Student>();
	
	public static StudentDaoImpl getStudentDaoImpl() {
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	
	private StudentDaoImpl() {}
	
	@Override
	public Student create(Student student) {
		listOfStudent.add(student);
		return student;
	}

	@Override
	public Student read(int id) {
		return listOfStudent.get(id);
	}

	@Override
	public Student update(Student t) {
		Student studentUpdate = listOfStudent.get(t.getId());
		if(studentUpdate != null) {
			studentUpdate.setName(t.getName());
			studentUpdate.setAge(t.getAge());
		}else {
			System.err.println("Coudn`t fint student with this id");
		}
		return studentUpdate;
	}

	@Override
	public void delete(int id) {
		listOfStudent.remove(id);
	}

}
