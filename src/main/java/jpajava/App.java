package jpajava;

import jpajava.domain.Guide;
import jpajava.domain.Student;
import jpajava.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        final Session session = HibernateUtil.getSessionFactory().openSession();
        final Transaction trx = session.getTransaction();

        try {
            trx.begin();

            saveStudent(session);
//            getStudent(session, 1L);
//            deleteStudent(session, 3L);


            trx.commit();
        } catch (HibernateException e) {
            if (trx != null) {
                trx.rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        HibernateUtil.shutdown();
    }

    private static void deleteStudent(final Session session, final long studentId) {
        Student student = (Student) session.get(Student.class, studentId);
        session.delete(student);
    }

    private static void saveStudent(final Session session){
        Guide guide = new Guide("323232324ddswds", "Ahmed Aziz", 2000);
        Student student = new Student("wu8y3y483hhx", "Hayder Aziz", guide);
        //you use cascade so you don't have to save the guid object yourself
        //session.save(guide);
        //session.save(student);
        // use persist and not save
        session.persist(student);
    }

    private static void getStudent(final Session session, long studentId){
        Student student = (Student) session.get(Student.class, studentId);
        System.out.println(student);
    }
}
