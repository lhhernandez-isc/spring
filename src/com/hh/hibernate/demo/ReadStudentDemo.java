package com.hh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hh.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
//		create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		create session
		Session session = factory.getCurrentSession();

		try {
//			use the session object to save a Java Object
//			create a student object
			System.out.println("Creando un nuevo objeto Estudiante");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@hh.com");

//			start a transaction
			session.beginTransaction();

//			save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

//			commit transaction
			session.getTransaction().commit();

//			MY NEW CODE

//			find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());

//			now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

//			retrieve student based on the id: primary key
			System.out.println("\nGetting student whit id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get complete: " + myStudent);

//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {

		} finally {
			factory.close();
		}
	}

}
