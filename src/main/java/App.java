import java.util.List;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session s = factory.openSession();
    Transaction x = s.beginTransaction();

        Student student = new Student("Julio", "Salas", "Julio@gmail.com");
        Student student1 = new Student("John", "Cena", "JohnCena#gmail.com");
        Student student2 = new Student("Jennifer", "Bai", "Jbai@gmail.com");

        //Save the student objects
        s.save(student);
        s.save(student1);
        s.save(student2);
        x.commit();

        // Retrive data from H2 database
        String hql = "SELECT s FROM Student s";
        Query query = s.createQuery(hql);
        List<Student> list  =  query.getResultList();

        for (Student stu : list) {
            System.out.println("Student Id: " + stu.getId() + " | First name: " + stu.getFirstName() + " | LastName: " + stu.getLastName() + " | Email: " + stu.getEmail());

        }
    }
}