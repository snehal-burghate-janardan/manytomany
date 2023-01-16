package many_to_many_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many_uni_dto.Course;
import many_to_many_uni_dto.Student;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//object for student
		Student student1=new Student();
		student1.setId(1);
		student1.setName("rahul");
		student1.setPhone(234567890);
		student1.setAddress("pune");
		
		Student student2=new Student();
		student2.setId(2);
		student2.setName("niru");
		student2.setPhone(3456789);
		student2.setAddress("nagpur");
		
		Student student3=new Student();
		student3.setId(3);
		student3.setName("pakhi");
		student3.setPhone(45678899);
		student3.setAddress("akola");
		
		//object for course
		
		Course course1=new Course();
		course1.setId(1001);
		course1.setName("Java");
		course1.setFess(10000);
		course1.setDuration(2);
		
		Course course2=new Course();
		course2.setId(1002);
		course2.setName("Advance java");
		course2.setFess(10500);
		course2.setDuration(1);
		
		Course course3=new Course();
		course3.setId(1003);
		course3.setName("sql");
		course3.setFess(12000);
		course3.setDuration(1);
		
		List<Course>list1=new ArrayList<Course>();
		list1.add(course1);
		list1.add(course2);
		
		student1.setCourses(list1);
		student2.setCourses(list1);
		
		List<Course>list2=new ArrayList<Course>();
		list2.add(course2);
		list2.add(course3);
		
		student3.setCourses(list2);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityTransaction.commit();
		

	}

}
