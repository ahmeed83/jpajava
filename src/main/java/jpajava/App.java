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

            //savePerson(session);
            getPerson(session, 1L);

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

    private static void savePerson(final Session session){
        Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
        Student student = new Student("2014JT50123", "John Smith", guide);
        session.save(guide);
        session.save(student);
    }

    private static void getPerson(final Session session, long personId){
        Student person = (Student) session.get(Student.class, personId);
        System.out.println(person);
    }
}
